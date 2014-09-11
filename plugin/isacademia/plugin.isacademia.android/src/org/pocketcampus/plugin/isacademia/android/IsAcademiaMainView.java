package org.pocketcampus.plugin.isacademia.android;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.pocketcampus.platform.android.core.PluginController;
import org.pocketcampus.platform.android.core.PluginView;
import org.pocketcampus.platform.android.ui.adapter.LazyAdapter;
import org.pocketcampus.platform.android.ui.adapter.SeparatedListAdapter;
import org.pocketcampus.platform.android.ui.layout.StandardLayout;
import org.pocketcampus.platform.android.utils.Preparated;
import org.pocketcampus.platform.android.utils.Preparator;
import org.pocketcampus.platform.android.utils.ScrollStateSaver;
import org.pocketcampus.plugin.isacademia.R;
import org.pocketcampus.plugin.isacademia.android.iface.IIsAcademiaView;
import org.pocketcampus.plugin.isacademia.shared.StudyPeriod;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.markupartist.android.widget.ActionBar.Action;

/**
 * IsAcademiaMainView - Main view that shows IsAcademia courses.
 * 
 * This is the main view in the IsAcademia Plugin.
 * It checks if the user is logged in, if not it pings
 * the Authentication Plugin.
 * When it gets back a valid SessionId it fetches the
 * user's IsAcademia data.
 * 
 * @author Amer <amer.chamseddine@epfl.ch>
 * 
 */
public class IsAcademiaMainView extends PluginView implements IIsAcademiaView {

	private IsAcademiaController mController;
	private IsAcademiaModel mModel;
	
//	public static final String MAP_KEY_ISACADEMIASTUDYPERIOD = "MAP_KEY_ISACADEMIASTUDYPERIOD";

	private boolean displayingList;

	ListView mList;
	ScrollStateSaver scrollState;
	
	private long currentTime;
	private SimpleDateFormat keyFormatter;

	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return IsAcademiaController.class;
	}

	@Override
	protected void onDisplay(Bundle savedInstanceState, PluginController controller) {
		
		// Get and cast the controller and model
		mController = (IsAcademiaController) controller;
		mModel = (IsAcademiaModel) controller.getModel();

		setContentView(R.layout.isacademia_main_container);
		mList = (ListView) findViewById(R.id.isacademia_main_list);
		displayingList = true;

		setActionBarTitle(getString(R.string.isacademia_plugin_title));
		
		// transform currentTime to dayKey in device's timezone
		keyFormatter = new SimpleDateFormat("yyyyMMdd", Locale.US);
		currentTime = System.currentTimeMillis();
//		try {
//			currentTime = keyFormatter.parse("20111012").getTime();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Handles the intent that was used to start this plugin.
	 * 
	 * If we were pinged by auth plugin, then we must read the sessId.
	 * Otherwise we do a normal startup, and if we do not have the
	 * isacademiaCookie we ping the Authentication Plugin.
	 */
	@Override
	protected void handleIntent(Intent aIntent) {

		
		if(IsAcademiaController.sessionExists(this)) // I think this is no longer necessary, since the auth plugin doesnt blindly redo auth (well, this saves the one call that the auth plugin does to check if the session is valid)
			updateDisplay(); // triggerRefresh(false);
		else
			IsAcademiaController.pingAuthPlugin(this);

		

		
	}


	private void triggerRefresh(boolean useCache) {
		mController.refreshSchedule(this, keyFormatter.format(new Date(currentTime)), useCache);
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		if(displayingList && scrollState != null)
			scrollState.restore(mList);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if(displayingList && mList != null)
			scrollState = new ScrollStateSaver(mList);
	}
		
	@Override
	protected String screenName() {
		return "/isacademia";
	}

	@Override
	public void scheduleUpdated() {
		updateDisplay();
	}
	
	private String formatStringWithDate(int res) {
		SimpleDateFormat fmt = new SimpleDateFormat("EEE d MMM yyyy", Locale.getDefault());
		return String.format(getString(res), fmt.format(new Date(currentTime)));
		
	}
	

	private void updateActionBar() {
		removeAllActionsFromActionBar();
		addActionToActionBar(new Action() {
			public void performAction(View view) {
				currentTime -= 24 * 3600 * 1000;
				updateDisplay();
				trackEvent("PreviousDay", null);
			}
			public int getDrawable() {
				return R.drawable.isacademia_left_arraow;
			}
		});
		addActionToActionBar(new Action() {
			public void performAction(View view) {
				currentTime += 24 * 3600 * 1000;
				updateDisplay();
				trackEvent("NextDay", null);
			}
			public int getDrawable() {
				return R.drawable.isacademia_right_arrow;
			}
		});
		
	}
	
	private static String getRoomsString(StudyPeriod p) {
		List<String> rooms = new LinkedList<String>();
		for(String r : p.getRooms()) {
			Uri.Builder builder = new Uri.Builder();
			builder.scheme("pocketcampus").authority("map.plugin.pocketcampus.org").appendPath("search").appendQueryParameter("q", r);
			rooms.add("<a href=\"" + builder.build() + "\">" + r + "</a>");
		}
		return TextUtils.join(", ", rooms);
	}

	private String getLocalizedPeriodType(String aString) {
		String packageName = getPackageName();
		int resId = getResources().getIdentifier("isacademia_period_type_" + aString, "string", packageName);
		if(resId == 0)
			return aString;
		return getString(resId);
	}

	public void updateDisplay() {
		
		updateActionBar();

		List<StudyPeriod> courses = mModel.getDay(keyFormatter.format(new Date(currentTime)));
		
		if(courses == null) {
			triggerRefresh(false);
			return;
		}

		if(displayingList)
			scrollState = new ScrollStateSaver(mList);
		

		
		SeparatedListAdapter adapter = new SeparatedListAdapter(this, R.layout.sdk_separated_list_header2);

		Preparated<StudyPeriod> p = new Preparated<StudyPeriod>(courses, new Preparator<StudyPeriod>() {
			DateFormat fmt = android.text.format.DateFormat.getTimeFormat(IsAcademiaMainView.this);
			public int[] resources() {
				return new int[] { R.id.isacademia_period_title, R.id.isacademia_period_type, R.id.isacademia_period_room, R.id.isacademia_period_time };
			}
			public Object content(int res, final StudyPeriod e) {
				switch (res) {
				case R.id.isacademia_period_title:
					return e.getName();
				case R.id.isacademia_period_type:
					return getLocalizedPeriodType(e.getPeriodType().name());
				case R.id.isacademia_period_room:
					return getRoomsString(e);
				case R.id.isacademia_period_time:
					return fmt.format(new Date(e.getStartTime())) + " - " + fmt.format(new Date(e.getEndTime()));
				default:
					return null;
				}
			}
			public void finalize(Map<String, Object> map, StudyPeriod item) {
//				map.put(MAP_KEY_ISACADEMIASTUDYPERIOD, item);
				map.put(LazyAdapter.NOT_SELECTABLE, "1");
				map.put(LazyAdapter.LINK_CLICKABLE, "1");

			}
		});
		adapter.addSection(formatStringWithDate(R.string.isacademia_schedule_for), new LazyAdapter(this, p.getMap(), 
				R.layout.isacademia_main_period_entry, p.getKeys(), p.getResources()));
		
		if(courses.size() == 0) {
			displayingList = false;
			StandardLayout sl = new StandardLayout(this);
			sl.setText(formatStringWithDate(R.string.isacademia_no_classes_on));
			setContentView(sl);
		} else {
			
			
			if(!displayingList) {
				setContentView(R.layout.isacademia_main_container);
				mList = (ListView) findViewById(R.id.isacademia_main_list);
				displayingList = true;
			}
			mList.setAdapter(adapter);
			
//			mList.setOnItemClickListener(new OnItemClickListener() {
//				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//					Object o = arg0.getItemAtPosition(arg2);
//					if(o instanceof Map<?, ?>) {
//						StudyPeriod item = (StudyPeriod) ((Map<?, ?>) o).get(MAP_KEY_ISACADEMIASTUDYPERIOD);
//						Intent i = new Intent(IsAcademiaMainView.this, IsAcademiaCourseView.class);
//						i.putExtra(IsAcademiaCourseView.EXTRAS_KEY_ISACADEMIACOURSEID, (int) eId);
//						i.putExtra(IsAcademiaCourseView.EXTRAS_KEY_ISACADEMIACOURSETITLE, eTitle);
//						IsAcademiaMainView.this.startActivity(i);
////						trackEvent("ViewCourse", eId + "-" + eTitle);
//					} else {
//						Toast.makeText(getApplicationContext(), o.toString(), Toast.LENGTH_SHORT).show();
//					}
//				}
//			});
			
			if(scrollState != null)
				scrollState.restore(mList);
			
		}
		
				
		
		
		
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		MenuItem pickDateMenu = menu.add(getString(R.string.isacademia_go_to_date));
		pickDateMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				trackEvent("GoToDate", null);
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(currentTime));
				DatePickerDialog dpd = new DatePickerDialog(IsAcademiaMainView.this, new OnDateSetListener() {
					public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
						if(!view.isShown())
							return; // bug in Jely Bean: http://stackoverflow.com/questions/11444238/jelly-bean-datepickerdialog-is-there-a-way-to-cancel
						currentTime = computeCurrentTime(year, monthOfYear + 1, dayOfMonth);
						trackEvent("GoToDateSelected", new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(currentTime)));
						updateDisplay();
					}
				}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
				dpd.show();
				return true;
			}
		});
		return true;
	}
	
	private Long computeCurrentTime(int year, int month, int day) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-M-d'T'HH:mm:ss'Z'", Locale.US);
//			df.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
			String d = year + "-" + month + "-" + day;
			return df.parse(d + "T12:00:00Z").getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void networkErrorHappened() {
		Toast.makeText(getApplicationContext(), getResources().getString(
				R.string.sdk_connection_error_happened), Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void authenticationFailed() {
		Toast.makeText(getApplicationContext(), getResources().getString(
				R.string.sdk_authentication_failed), Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void userCancelledAuthentication() {
		finish();
	}
	
	@Override
	public void isacademiaServersDown() {
		Toast.makeText(getApplicationContext(), getResources().getString(
				R.string.isacademia_error_isacademia_down), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void networkErrorCacheExists() {
		Toast.makeText(getApplicationContext(), getResources().getString(
				R.string.sdk_connection_no_cache_yes), Toast.LENGTH_SHORT).show();
		triggerRefresh(true);
		
	}

	@Override
	public void notLoggedIn() {
		IsAcademiaController.pingAuthPlugin(this);
		
	}

	@Override
	public void authenticationFinished() {
		triggerRefresh(false);
		
	}

}
