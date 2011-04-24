package org.pocketcampus.plugin.mainscreen;

import java.util.Vector;

import org.pocketcampus.R;
import org.pocketcampus.core.plugin.Core;
import org.pocketcampus.core.plugin.Icon;
import org.pocketcampus.core.plugin.PluginBase;
import org.pocketcampus.core.plugin.PluginInfo;
import org.pocketcampus.core.plugin.PluginPreference;
import org.pocketcampus.core.ui.ActionBar;
import org.pocketcampus.plugin.logging.Tracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainscreenPlugin extends PluginBase {
	private Context ctx_;
	private Core core_;
	private Vector<PluginBase> plugins_;
	private Tracker tracker_;

	private MainscreenAdapter adapter_;
	
	private ActionBar actionBar_;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen_main);
		
		setupActionBar(false);

		tracker_ = Tracker.getInstance();
		tracker_.start(this);
		tracker_.trackPageView("news/home");
		
		ctx_ = this.getApplicationContext();
		core_ = Core.getInstance();
		plugins_ = core_.getAvailablePlugins();
		
		displayNews();

		LinearLayout menuLayout = (LinearLayout) findViewById(R.id.MenuLayout);

		for (final PluginBase plugin : plugins_) {
			PluginInfo pluginInfo = plugin.getPluginInfo();

			// MENU ICONS
			if(pluginInfo.hasMenuIcon() == true) {
				// layout
				RelativeLayout relLayout = new RelativeLayout(ctx_);
				RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				//layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
				relLayout.setLayoutParams(layoutParams);

				// button
				ImageButton button = new ImageButton(ctx_);

				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						core_.displayPlugin(ctx_, plugin);
					}
				});

				// icon
				if(pluginInfo.getIcon() != null) {
					button.setImageDrawable(pluginInfo.getIcon().getDrawable(ctx_));
				} else {
					button.setImageDrawable(Icon.getDefaultDrawable(ctx_));
				}

				RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
				button.setLayoutParams(buttonParams);
				button.setBackgroundColor(0x00000000);
				button.setId(1);
				relLayout.addView(button);

				// label
				TextView text = new TextView(ctx_);
				text.setText(pluginInfo.getName());

				RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				textParams.addRule(RelativeLayout.BELOW, 1);
				textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
				text.setLayoutParams(textParams);
				text.setTextColor(0xff444444);
				text.setGravity(Gravity.TOP);
				relLayout.addView(text);


				// put it in
				relLayout.setPadding(2, 5, 2, 10);
				menuLayout.addView(relLayout);
			}
		}

	}


	private void showAbout() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("About");

		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.mainscreen_about_dialog, null);
		builder.setView(layout);

		builder.setNeutralButton("Credits", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {				
				dialog.dismiss();
				showCredits();
			}
		});

		builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {				
				dialog.dismiss();
			}
		});

		AlertDialog alert = builder.create();
		alert.setCanceledOnTouchOutside(true);
		alert.show();
	}

	private void showCredits() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Credits");

		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.mainscreen_credits_dialog, null);
		builder.setView(layout);

		builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {				
				dialog.dismiss();
			}
		});

		AlertDialog alert = builder.create();
		alert.setCanceledOnTouchOutside(true);
		alert.show();
	}

	public static Intent createIntent(Context context) {
		Intent i = new Intent(context, MainscreenPlugin.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		return i;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainscreen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.transport_menu_settings:
			Intent intent = new Intent(this, MainscreenPreference.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			return true;

		case R.id.transport_menu_about:
			showAbout();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public PluginPreference getPluginPreference() {
		return new MainscreenPreference();
	}

	@Override
	public PluginInfo getPluginInfo() {
		return new MainscreenInfo();
	}
	
	
	private void displayNews() {
		final ListView l = (ListView) findViewById(R.id.mainscreen_news_list_list);
		adapter_ = new MainscreenAdapter(ctx_);
		l.setAdapter(adapter_);
		l.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				MainscreenNews selected = (MainscreenNews) adapter_.getItem(position);
				if(selected.getPlugin_() instanceof IAllowsID) {
					Core.startPluginWithID(ctx_, selected.getPlugin_(), selected.getId_());
				}
			}
		});
	}


}