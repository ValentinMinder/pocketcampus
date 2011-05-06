package org.pocketcampus.plugin.news;

import java.util.ArrayList;
import java.util.List;

import org.pocketcampus.R;
import org.pocketcampus.core.plugin.PluginBase;
import org.pocketcampus.core.plugin.PluginInfo;
import org.pocketcampus.core.plugin.PluginPreference;
import org.pocketcampus.core.ui.ActionBar;
import org.pocketcampus.core.ui.ActionBar.Action;
import org.pocketcampus.plugin.logging.Tracker;
import org.pocketcampus.plugin.mainscreen.IMainscreenNewsProvider;
import org.pocketcampus.plugin.mainscreen.MainscreenNews;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * PluginBase class for the News plugin. 
 * 
 * @status complete
 * 
 * @author Jonas
 *
 */
public class NewsPlugin extends PluginBase implements IMainscreenNewsProvider, INewsListener {

	private NewsAdapter adapter_;
	private NewsProvider newsProvider_;
	private ActionBar actionBar_;
	private final static int NB_NEWS = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_list);

		newsProvider_ = NewsProvider.getInstance(this);
		newsProvider_.addNewsListener(this);

		setupActionBar(true);

		setLayout();
		
		Tracker.getInstance().trackPageView("news/home");
	}

	@Override
	protected void setupActionBar(boolean addHomeButton) {

		actionBar_ = (ActionBar) findViewById(R.id.actionbar);
		actionBar_.addAction(new Action() {

			@Override
			public void performAction(View view) {
				newsProvider_.forceRefresh();
			}

			@Override
			public int getDrawable() {
				return R.drawable.refresh;
			}
		});
		
		super.setupActionBar(addHomeButton);

	}

	@Override
	protected void onResume() {
		super.onResume();

		newsProvider_.refreshIfNeeded();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}


	@Override
	public PluginInfo getPluginInfo() {
		return new NewsInfo();
	}

	@Override
	public PluginPreference getPluginPreference() {
		return new NewsPreference();
	}

	private void setLayout() {
		final ListView l = (ListView) findViewById(R.id.news_list_list);
		adapter_ = new NewsAdapter(this, newsProvider_);
		l.setAdapter(adapter_);

		l.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if(adapter_ != null) {
					adapter_.setClickedItem(parent, view, position, id);

					Tracker.getInstance().trackPageView("news/previewItem");
				}
			}
		});
	}

	@Override
	public void newsRefreshing() {
		actionBar_.setProgressBarVisibility(View.VISIBLE);
	}

	@Override
	public void newsRefreshed() {
		actionBar_.setProgressBarVisibility(View.GONE);
	}

	@Override
	public List<MainscreenNews> getNews(Context ctx) {
		List<MainscreenNews> l = new ArrayList<MainscreenNews>();
		
		// Number of news to display
		int min = newsProvider_.getCount();
		min = Math.min(min, NB_NEWS);
		
		NewsItem tmp;
		for(int i = 0; i < min; ++i) {
			tmp = newsProvider_.getItem(i);
			l.add(new MainscreenNews(tmp.getTitle(), tmp.getDescription(), tmp.hashCode(), this,tmp.getPubDateDate()));
		}
		
		return l;
		
	}


}
