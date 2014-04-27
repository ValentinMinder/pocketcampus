package org.pocketcampus.plugin.freeroom.android.views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.tracker.Tracker;
import org.pocketcampus.android.platform.sdk.ui.element.InputBarElement;
import org.pocketcampus.android.platform.sdk.ui.element.OnKeyPressedListener;
import org.pocketcampus.android.platform.sdk.ui.layout.StandardTitledLayout;
import org.pocketcampus.android.platform.sdk.ui.list.LabeledListViewElement;
import org.pocketcampus.plugin.freeroom.R;
import org.pocketcampus.plugin.freeroom.android.FreeRoomAbstractView;
import org.pocketcampus.plugin.freeroom.android.FreeRoomController;
import org.pocketcampus.plugin.freeroom.android.FreeRoomManageFavoritesView;
import org.pocketcampus.plugin.freeroom.android.FreeRoomModel;
import org.pocketcampus.plugin.freeroom.android.adapter.ActualOccupationArrayAdapter;
import org.pocketcampus.plugin.freeroom.android.adapter.ExpandableListViewAdapter;
import org.pocketcampus.plugin.freeroom.android.adapter.FRRoomSuggestionArrayAdapter;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomView;
import org.pocketcampus.plugin.freeroom.android.utils.FRRequestDetails;
import org.pocketcampus.plugin.freeroom.android.utils.SetArrayList;
import org.pocketcampus.plugin.freeroom.shared.ActualOccupation;
import org.pocketcampus.plugin.freeroom.shared.AutoCompleteRequest;
import org.pocketcampus.plugin.freeroom.shared.FRPeriod;
import org.pocketcampus.plugin.freeroom.shared.FRRequest;
import org.pocketcampus.plugin.freeroom.shared.FRRoom;
import org.pocketcampus.plugin.freeroom.shared.FRRoomType;
import org.pocketcampus.plugin.freeroom.shared.ImWorkingRequest;
import org.pocketcampus.plugin.freeroom.shared.Occupancy;
import org.pocketcampus.plugin.freeroom.shared.WorkingOccupancy;
import org.pocketcampus.plugin.freeroom.shared.utils.FRTimes;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.markupartist.android.widget.ActionBar.Action;

/**
 * <code>FreeRoomHomeView</code> is the main <code>View</code>, it's the entry
 * of the plugin. It displays the availabilities for the search given, and for
 * your favorites NOW at the start.
 * <p>
 * All others views are supposed to be popup windows, therefore it's always
 * visible.
 * 
 * @author FreeRoom Project Team (2014/05)
 * @author Julien WEBER <julien.weber@epfl.ch>
 * @author Valentin MINDER <valentin.minder@epfl.ch>
 */
public class FreeRoomHomeView extends FreeRoomAbstractView implements
		IFreeRoomView {

	/**
	 * FreeRoom controller in MVC scheme.
	 */
	private FreeRoomController mController;
	/**
	 * FreeRoom model in MVC scheme.
	 */
	private FreeRoomModel mModel;

	/**
	 * Titled layout that holds the title and the main layout.
	 */
	private StandardTitledLayout titleLayout;
	/**
	 * Main layout that hold all UI components.
	 */
	private LinearLayout mainLayout;

	/**
	 * TextView to display a short message about what is currently displayed.
	 * It's also the anchor to all the popup windows.
	 */
	private TextView mTextView;
	/**
	 * ExpandableListView to display the results of occupancies building by
	 * building.
	 */
	private ExpandableListView mExpListView;

	/**
	 * Adapter for the results (to display the occupancies).
	 */
	private ExpandableListViewAdapter<Occupancy> mExpListAdapter;

	/**
	 * View that holds the INFO popup content.
	 */
	private View popupInfoView;
	/**
	 * Window that holds the INFO popup. Note: popup window can be closed by:
	 * the closing button (red cross), back button, or clicking outside the
	 * popup.
	 */
	private PopupWindow popupInfoWindow;

	/**
	 * View that holds the SEARCH popup content.
	 */
	private View popupSearchView;
	/**
	 * Window that holds the SEARCH popup. Note: popup window can be closed by:
	 * the closing button (red cross), back button, or clicking outside the
	 * popup.
	 */
	private PopupWindow popupSearchWindow;

	/**
	 * Action to perform a customized search.
	 */
	private Action search = new Action() {
		public void performAction(View view) {
			popupSearchWindow.showAsDropDown(mTextView, 0, 0);
			refreshPopupSearch();
		}

		public int getDrawable() {
			return R.drawable.magnify2x06;
		}
	};

	/**
	 * Action to edit the user's favorites.
	 */
	private Action editFavorites = new Action() {
		public void performAction(View view) {
			// TODO: popup instead of new activity
			Toast.makeText(getApplicationContext(), "favorites",
					Toast.LENGTH_SHORT).show();
			Intent i = new Intent(FreeRoomHomeView.this,
					FreeRoomManageFavoritesView.class);
			FreeRoomHomeView.this.startActivity(i);
		}

		public int getDrawable() {
			return R.drawable.pencil2x187;
		}
	};

	/**
	 * Action to refresh the view (it sends the same stored request again).
	 * <p>
	 * TODO: useful? useless ? delete !
	 */
	private Action refresh = new Action() {
		public void performAction(View view) {
			refresh();
		}

		public int getDrawable() {
			return R.drawable.refresh2x01;
		}
	};

	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return FreeRoomController.class;
	}

	@Override
	protected void onDisplay(Bundle savedInstanceState,
			PluginController controller) {
		// Tracker
		Tracker.getInstance().trackPageView("freeroom");

		// Get and cast the controller and model
		mController = (FreeRoomController) controller;
		mModel = (FreeRoomModel) controller.getModel();

		// Setup the layout
		titleLayout = new StandardTitledLayout(this);
		mainLayout = new LinearLayout(this);
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		// The ActionBar is added automatically when you call setContentView
		setContentView(titleLayout);
		titleLayout.setTitle(getString(R.string.freeroom_title_main_title));

		mExpListView = new ExpandableListView(getApplicationContext());
		mTextView = new TextView(getApplicationContext());
		mainLayout.addView(mTextView);
		setTextSummary(getString(R.string.freeroom_home_init_please_wait));
		mainLayout.addView(mExpListView);
		initializeView();

		titleLayout.addFillerView(mainLayout);

		initDefaultRequest();
		refresh();
	}

	/**
	 * This is called when the Activity is resumed.
	 * 
	 * If the user presses back on the Authentication window, This Activity is
	 * resumed but we do not have the freeroomCookie. In this case we close the
	 * Activity.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		/*
		 * if(mModel != null && mModel.getFreeRoomCookie() == null) { // Resumed
		 * and lot logged in? go back finish(); }
		 */

		if (mController != null) {
			mController.sendFRRequest(this);
		}
	}

	@Override
	public void initializeView() {
		mExpListAdapter = new ExpandableListViewAdapter<Occupancy>(
				getApplicationContext(), mModel.getOccupancyResults(),
				mController, this);
		mExpListView.setAdapter(mExpListAdapter);
		addActionToActionBar(refresh);
		addActionToActionBar(editFavorites);
		addActionToActionBar(search);
		initPopupInfoRoom();
		initPopupSearch();
	}

	/**
	 * Inits the popup to diplay the information about a room.
	 */
	private void initPopupInfoRoom() {
		// construct the popup
		// it MUST fill the parent in height, such that weight works in xml for
		// heights. Otherwise, some elements may not be displayed anymore
		LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		popupInfoView = layoutInflater.inflate(
				R.layout.freeroom_layout_popup_info, null);
		popupInfoWindow = new PopupWindow(popupInfoView,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, true);

		// allows outside clicks to close the popup
		popupInfoWindow.setOutsideTouchable(true);
		popupInfoWindow.setBackgroundDrawable(new BitmapDrawable());

		TextView tv = (TextView) popupInfoView
				.findViewById(R.id.freeroom_layout_popup_info_name);
		tv.setText("room");

		ImageView img = (ImageView) popupInfoView
				.findViewById(R.id.freeroom_layout_popup_info_close);
		img.setOnClickListener(new ImageView.OnClickListener() {

			@Override
			public void onClick(View v) {
				popupInfoWindow.dismiss();
			}
		});
	}

	/**
	 * Inits the popup to diplay the information about a room.
	 */
	private void initPopupSearch() {
		// construct the popup
		// it MUST fill the parent in height, such that weight works in xml for
		// heights. Otherwise, some elements may not be displayed anymore
		LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		popupSearchView = layoutInflater.inflate(
				R.layout.freeroom_layout_popup_search, null);
		popupSearchWindow = new PopupWindow(popupSearchView,
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, true);

		// allows outside clicks to close the popup
		popupSearchWindow.setOutsideTouchable(true);
		popupSearchWindow.setBackgroundDrawable(new BitmapDrawable());

		Button tv = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_go);
		tv.setText("Go!!");

		ImageView img = (ImageView) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_close);
		img.setOnClickListener(new ImageView.OnClickListener() {

			@Override
			public void onClick(View v) {
				popupSearchWindow.dismiss();
			}
		});

		initSearch();
	}

	/**
	 * Overrides the legacy <code>onKeyDown</code> method in order to close the
	 * popupWindow if one was opened.
	 * 
	 * @param keyCode
	 * @param event
	 * @return
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		// Override back button
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			boolean flag = false;
			if (popupInfoWindow.isShowing()) {
				popupInfoWindow.dismiss();
				flag = true;
			}
			if (popupSearchWindow.isShowing()) {
				popupSearchWindow.dismiss();
				flag = true;
			}
			if (flag) {
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void anyError() {
		setTextSummary(getString(R.string.freeroom_home_error_sorry));
	}

	/**
	 * Sets the summary text box to the specified text.
	 * 
	 * @param text
	 *            the new summary to be displayed.
	 */
	private void setTextSummary(String text) {
		mTextView.setText(text);
	}

	/**
	 * Constructs the default request (check all the favorites for the next
	 * valid period) and sets it in the model for future use. You may call
	 * <code>refresh</code> in order to send it to the server.
	 */
	private void initDefaultRequest() {
		mModel.setFRRequestDetails(validRequest());
	}

	private FRRequestDetails validRequest() {
		Set<String> set = mModel.getAllRoomMapFavorites().keySet();
		ArrayList<String> array = new ArrayList<String>(set.size());
		array.addAll(set);
		FRRequestDetails details = new FRRequestDetails(
				FRTimes.getNextValidPeriod(), false, array, false, true, false,
				new SetArrayList<FRRoom>());
		return details;
	}

	/**
	 * Asks the controller to send again the request which was already set in
	 * the model.
	 */
	private void refresh() {
		setTextSummary(getString(R.string.freeroom_home_please_wait));
		mController.sendFRRequest(this);
	}

	@Override
	public void freeRoomResultsUpdated() {
		// we do nothing here
	}

	@Override
	public void occupancyResultUpdated() {
		// we do nothing here
	}

	@Override
	public void occupancyResultsUpdated() {
		StringBuilder build = new StringBuilder(50);
		if (mModel.getOccupancyResults().isEmpty()) {
			build.append(getString(R.string.freeroom_home_error_no_results));
		} else {
			FRRequest request = mModel.getFRRequestDetails();

			if (request.isOnlyFreeRooms()) {
				build.append(getString(R.string.freeroom_home_info_free_rooms));
			} else {
				build.append(getString(R.string.freeroom_home_info_rooms));
			}
			FRPeriod period = request.getPeriod();
			build.append(generateTimeSummary(period));
		}

		setTextSummary(build.toString());
		mExpListAdapter.notifyDataSetChanged();
		mExpListAdapter.updateCollapse(mExpListView);
	}

	/**
	 * Generates a string summary of a given period of time.
	 * <p>
	 * eg: "Wednesday Apr 24 from 9am to 12pm"
	 * 
	 * @param period
	 *            the period of time
	 * @return a string summary of a given period of time.
	 */
	private String generateTimeSummary(FRPeriod period) {
		StringBuilder build = new StringBuilder(100);
		Date endDate = new Date(period.getTimeStampEnd());
		Date startDate = new Date(period.getTimeStampStart());
		SimpleDateFormat day_month = new SimpleDateFormat(
				getString(R.string.freeroom_pattern_day_format));
		SimpleDateFormat hour_min = new SimpleDateFormat(
				getString(R.string.freeroom_pattern_hour_format));

		build.append(" ");
		// TODO: if date is today, use "today" instead of specifying date
		build.append(getString(R.string.freeroom_check_occupancy_result_onthe));
		build.append(" ");
		build.append(day_month.format(startDate));
		build.append(" ");
		build.append(getString(R.string.freeroom_check_occupancy_result_from));
		build.append(" ");
		build.append(hour_min.format(startDate));
		build.append(" ");
		build.append(getString(R.string.freeroom_check_occupancy_result_to));
		build.append(" ");
		build.append(hour_min.format(endDate));
		return build.toString();
	}

	/**
	 * Put a onClickListener on an imageView in order to share the location and
	 * time when clicking share, if available.
	 * 
	 * @param shareImageView
	 *            the view on which to put the listener
	 * @param homeView
	 *            reference to the home view
	 * @param mOccupancy
	 *            the holder of data for location and time
	 */
	public void setShareClickListener(ImageView shareImageView,
			final FreeRoomHomeView homeView, final Occupancy mOccupancy) {

		if (!mOccupancy.isIsAtLeastOccupiedOnce()
				&& mOccupancy.isIsAtLeastFreeOnce()) {
			shareImageView.setClickable(true);
			shareImageView.setImageResource(R.drawable.share);
			shareImageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// share
					List<ActualOccupation> list = mOccupancy.getOccupancy();
					long tss = list.get(0).getPeriod().getTimeStampStart();
					long tse = list.get(list.size() - 1).getPeriod()
							.getTimeStampEnd();
					FRPeriod mPeriod = new FRPeriod(tss, tse, false);
					homeView.share(mPeriod, mOccupancy.getRoom());
				}
			});
		} else {
			shareImageView.setClickable(false);
			shareImageView.setImageResource(R.drawable.share_disabled);
		}
	}

	/**
	 * Display the popup that provides more info about the occupation of the
	 * selected room.
	 */
	public void displayPopupInfo() {
		final Occupancy mOccupancy = mModel.getDisplayedOccupancy();
		if (mOccupancy != null) {
			TextView tv = (TextView) popupInfoView
					.findViewById(R.id.freeroom_layout_popup_info_name);
			final FRRoom mRoom = mOccupancy.getRoom();
			String text = mRoom.getDoorCode();
			if (mRoom.isSetDoorCodeAlias()) {
				// alias is displayed IN PLACE of the official name
				// the official name can be found in bottom of popup
				text = mRoom.getDoorCodeAlias();
			}
			tv.setText(text);

			ImageView iv = (ImageView) popupInfoView
					.findViewById(R.id.freeroom_layout_popup_info_share);
			setShareClickListener(iv, this, mOccupancy);

			ListView roomOccupancyListView = (ListView) popupInfoView
					.findViewById(R.id.freeroom_layout_popup_info_roomOccupancy);
			roomOccupancyListView
					.setAdapter(new ActualOccupationArrayAdapter<ActualOccupation>(
							getApplicationContext(), mOccupancy.getOccupancy(),
							mController, this));

			TextView detailsTextView = (TextView) popupInfoView
					.findViewById(R.id.freeroom_layout_popup_info_details);
			detailsTextView.setText(getInfoFRRoom(mOccupancy.getRoom()));
			popupInfoWindow.showAsDropDown(mTextView, 0, 0);
		}
	}

	private void refreshPopupSearch() {
		final FRRequestDetails request = mModel.getFRRequestDetails();
		if (request != null) {
			refreshPopupSearch(request);
		}
	}

	private void refreshPopupSearch(final FRRequestDetails request) {
		resetTimes(request.getPeriod());
		anyButton.setChecked(request.isAny());
		specButton.setChecked(!request.isAny());
		favButton.setChecked(request.isFav());
		userDefButton.setChecked(request.isUser());
		freeButton.setChecked(request.isOnlyFreeRooms());
		searchButton.setEnabled(auditSubmit() == 0);
	}

	/**
	 * Construct the Intent to share the location and time with friends. The
	 * same information is shared with the server at the same time
	 * 
	 * @param mPeriod
	 *            time period
	 * @param mRoom
	 *            location
	 */
	public void share(FRPeriod mPeriod, FRRoom mRoom) {
		WorkingOccupancy work = new WorkingOccupancy(mPeriod, mRoom);
		ImWorkingRequest request = new ImWorkingRequest(work,
				mModel.getAnonymID());
		mController.prepareImWorking(request);
		mController.ImWorking(this);

		// TODO: in case of "now" request (nextPeriodValid is now), just put
		// "i am, now, " instead of
		// time
		StringBuilder textBuilder = new StringBuilder(100);
		textBuilder.append(getString(R.string.freeroom_share_iwillbe) + " ");
		textBuilder.append(getString(R.string.freeroom_share_in_room) + " ");
		if (mRoom.isSetDoorCodeAlias()) {
			textBuilder.append(mRoom.getDoorCodeAlias() + " ("
					+ mRoom.getDoorCode() + ") ");
		} else {
			textBuilder.append(mRoom.getDoorCode() + " ");
		}
		// TODO: which period to use ?
		// in case of specified in request, we should use the personalized
		// period
		textBuilder.append(generateTimeSummary(mPeriod) + ". ");
		textBuilder.append(getString(R.string.freeroom_share_please_come));

		System.out.println(textBuilder.toString());
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, textBuilder.toString()
				+ " (This was sent thru pocketcampus .org)");
		sendIntent.setType("text/plain");
		startActivity(Intent.createChooser(sendIntent,
				getString(R.string.freeroom_share_title)));
	}

	/**
	 * Converts a FRRoom to a String of only major properties, in order to
	 * display them. It includes name (with alias), type, capacity, surface and
	 * UID.
	 * <p>
	 * TODO: this method may be changed
	 * 
	 * @param mFrRoom
	 * @return
	 */
	private String getInfoFRRoom(FRRoom mFrRoom) {
		StringBuilder builder = new StringBuilder(50);
		if (mFrRoom.isSetDoorCode()) {
			if (mFrRoom.isSetDoorCodeAlias()) {
				builder.append(mFrRoom.getDoorCode() + " (alias: "
						+ mFrRoom.getDoorCodeAlias() + ")");
			} else {
				builder.append(mFrRoom.getDoorCode());
			}
		}
		if (mFrRoom.isSetTypeFR() || mFrRoom.isSetTypeEN()) {
			builder.append(" / " + getString(R.string.freeroom_popup_info_type)
					+ ": ");
			if (mFrRoom.isSetTypeFR()) {
				builder.append(mFrRoom.getTypeFR());
			}
			if (mFrRoom.isSetTypeFR() && mFrRoom.isSetTypeEN()) {
				builder.append(" / ");
			}
			if (mFrRoom.isSetTypeFR()) {
				builder.append(mFrRoom.getTypeEN());
			}
		}
		if (mFrRoom.isSetCapacity()) {
			builder.append(" / "
					+ getString(R.string.freeroom_popup_info_capacity) + ": "
					+ mFrRoom.getCapacity() + " "
					+ getString(R.string.freeroom_popup_info_places));
		}
		if (mFrRoom.isSetSurface()) {
			builder.append(" / "
					+ getString(R.string.freeroom_popup_info_surface) + ": "
					+ mFrRoom.getSurface() + " "
					+ getString(R.string.freeroom_popup_info_sqm));
		}
		// TODO: for production, remove UID (it's useful for debugging for the
		// moment)
		if (mFrRoom.isSetUid()) {
			// uniq UID must be 1201XXUID, with XX filled with 0 such that
			// it has 10 digit
			// the prefix "1201" indiquates that it's a EPFL room (not a phone,
			// a computer)
			String communUID = "1201";
			String roomUID = mFrRoom.getUid();
			for (int i = roomUID.length() + 1; i <= 6; i++) {
				communUID += "0";
			}
			communUID += roomUID;
			builder.append(" / "
					+ getString(R.string.freeroom_popup_info_uniqID) + ": "
					+ communUID);
		}
		return builder.toString();
	}

	// ** REUSED FROM SCRATCH FROM FreeRoomSearchView ** //
	private SetArrayList<FRRoom> selectedRooms;

	private ListView mAutoCompleteSuggestionListView;
	private List<FRRoom> mAutoCompleteSuggestionArrayListFRRoom;

	/** The input bar to make the search */
	private InputBarElement mAutoCompleteSuggestionInputBarElement;
	/** Adapter for the <code>mListView</code> */
	private FRRoomSuggestionArrayAdapter<FRRoom> mAdapter;

	private DatePickerDialog mDatePickerDialog;
	private TimePickerDialog mTimePickerStartDialog;
	private TimePickerDialog mTimePickerEndDialog;

	private Button showDatePicker;
	private Button showStartTimePicker;
	private Button showEndTimePicker;

	private ToggleButton specButton;
	private ToggleButton anyButton;
	private ToggleButton favButton;
	private ToggleButton userDefButton;
	/**
	 * TRUE: "only free rooms" FALSE: "allow non-free rooms"
	 */
	private ToggleButton freeButton;

	private Button searchButton;
	private Button resetButton;
	private Button addHourButton;

	private TextView mSummarySelectedRoomsTextView;

	private int yearSelected = -1;
	private int monthSelected = -1;
	private int dayOfMonthSelected = -1;
	private int startHourSelected = -1;
	private int startMinSelected = -1;
	private int endHourSelected = -1;
	private int endMinSelected = -1;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat timeFormat;

	private void initSearch() {

		selectedRooms = new SetArrayList<FRRoom>();
		formatters();

		// createSuggestionsList();
		// addAllFavsToAutoComplete();
		selectedRooms = new SetArrayList<FRRoom>();
		mAutoCompleteSuggestionArrayListFRRoom = new ArrayList<FRRoom>(10);
		resetTimes();

		UIConstructPickers();

		UIConstructButton();

		// UIConstructInputBar();

		reset();
	}

	private void formatters() {
		dateFormat = new SimpleDateFormat(
				getString(R.string.freeroom_pattern_day_format));
		timeFormat = new SimpleDateFormat(
				getString(R.string.freeroom_pattern_hour_format));
	}

	private void UIConstructPickers() {
		// First allow the user to select a date
		showDatePicker = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_date);
		mDatePickerDialog = new DatePickerDialog(this,
				new DatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int nYear,
							int nMonthOfYear, int nDayOfMonth) {
						yearSelected = nYear;
						monthSelected = nMonthOfYear;
						dayOfMonthSelected = nDayOfMonth;
						updateShowDatePicker();
						searchButton.setEnabled(auditSubmit() == 0);

					}
				}, yearSelected, monthSelected, dayOfMonthSelected);

		showDatePicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDatePickerDialog.show();
			}
		});

		// Then the starting time of the period
		showStartTimePicker = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_hour_start);
		mTimePickerStartDialog = new TimePickerDialog(this,
				new OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int nHourOfDay,
							int nMinute) {
						startHourSelected = nHourOfDay;
						startMinSelected = nMinute;
						updateShowStartTimePicker();
						searchButton.setEnabled(auditSubmit() == 0);

					}
				}, startHourSelected, startMinSelected, true);

		showStartTimePicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mTimePickerStartDialog.show();

			}
		});

		// Then the ending time of the period
		showEndTimePicker = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_hour_end);
		mTimePickerEndDialog = new TimePickerDialog(this,
				new OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int nHourOfDay,
							int nMinute) {
						endHourSelected = nHourOfDay;
						endMinSelected = nMinute;
						updateShowEndTimePicker();
						searchButton.setEnabled(auditSubmit() == 0);

					}
				}, endHourSelected, endMinSelected, true);

		showEndTimePicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mTimePickerEndDialog.show();

			}
		});
	}

	private void resetUserDefined() {
		// TODO: add/remove
		// mGlobalSubLayout.removeView(mAutoCompleteSuggestionInputBarElement);
		// mGlobalSubLayout.removeView(mSummarySelectedRoomsTextView);
		userDefButton.setChecked(false);
	}

	private void UIConstructButton() {
		specButton = (ToggleButton) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_spec);
		specButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				specButton.setChecked(true);
				anyButton.setChecked(false);
				anyButton.setEnabled(true);
				specButton.setChecked(true);

				// TODO: is this great ? this guarantees that searhc is always
				// available, but requires two steps to remove the fav (ass
				// user-def, remove fav)
				favButton.setChecked(true);
				// TODO: open the suggestion as well
				userDefButton.setChecked(true);

				searchButton.setEnabled(auditSubmit() == 0);
			}
		});

		anyButton = (ToggleButton) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_any);
		anyButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				specButton.setChecked(false);
				// TODO
				// resetUserDefined();

				favButton.setChecked(false);
				userDefButton.setChecked(false);
				freeButton.setChecked(true);
				anyButton.setChecked(true);
				searchButton.setEnabled(auditSubmit() == 0);
			}
		});

		favButton = (ToggleButton) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_fav);
		favButton.setEnabled(true);
		favButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!userDefButton.isChecked()) {
					favButton.setChecked(true);
				}
				anyButton.setChecked(false);
				specButton.setChecked(true);
				searchButton.setEnabled(auditSubmit() == 0);
			}
		});

		userDefButton = (ToggleButton) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_user);
		// TODO: inputbar doesnt work
		userDefButton.setEnabled(false);
		userDefButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (userDefButton.isChecked()) {
					anyButton.setChecked(false);
					specButton.setChecked(true);

					// TODO: add/remove
					// mGlobalSubLayout.addView(mSummarySelectedRoomsTextView);
					// mGlobalSubLayout
					// .addView(mAutoCompleteSuggestionInputBarElement);
				} else if (!favButton.isChecked()) {
					userDefButton.setChecked(true);
					anyButton.setChecked(false);
					specButton.setChecked(true);
				} else {
					resetUserDefined();
				}
				searchButton.setEnabled(auditSubmit() == 0);
			}
		});

		freeButton = (ToggleButton) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_non_free);
		freeButton.setEnabled(true);
		freeButton.setFocusable(true);
		freeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!freeButton.isChecked()) {
					anyButton.setChecked(false);
					specButton.setChecked(true);
				}
				searchButton.setEnabled(auditSubmit() == 0);
			}
		});

		searchButton = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_go);
		searchButton.setEnabled(false);
		searchButton.setText(R.string.freeroom_searchbutton);
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				prepareSearchQuery();
			}
		});

		resetButton = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_reset);
		resetButton.setEnabled(true);
		resetButton.setText(R.string.freeroom_resetbutton);
		resetButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				reset();
				// addAllFavsToAutoComplete();
				// we reset the input bar...
				// TODO
				// mAutoCompleteSuggestionInputBarElement.setInputText("");
			}
		});

		addHourButton = (Button) popupSearchView
				.findViewById(R.id.freeroom_layout_popup_search_hour_end_plus);
		addHourButton.setEnabled(true);
		addHourButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (endHourSelected <= 18) {
					endHourSelected += 1;
					updateShowEndTimePicker();
					mTimePickerEndDialog.updateTime(endHourSelected,
							endMinSelected);
				}
				if (endHourSelected >= 19) {
					addHourButton.setEnabled(false);
				}
			}
		});
	}

	// TODO: the InputBar is not used so far
	private void UIConstructInputBar() {
		final IFreeRoomView view = this;

		mAutoCompleteSuggestionInputBarElement = new InputBarElement(
				this,
				null,
				getString(R.string.freeroom_check_occupancy_search_inputbarhint));
		mAutoCompleteSuggestionInputBarElement
				.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

		mAutoCompleteSuggestionInputBarElement
				.setOnEditorActionListener(new OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView v, int actionId,
							KeyEvent event) {
						if (actionId == EditorInfo.IME_ACTION_SEARCH) {
							String query = mAutoCompleteSuggestionInputBarElement
									.getInputText();
							Log.v(this.getClass().toString(),
									"we do nothing here... with query: "
											+ query);
						}

						return true;
					}
				});
		mAutoCompleteSuggestionInputBarElement
				.setOnButtonClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String query = mAutoCompleteSuggestionInputBarElement
								.getInputText();
						if (query.length() >= 2) {
							AutoCompleteRequest request = new AutoCompleteRequest(
									query);
							mController.autoCompleteBuilding(view, request);
						}
					}
				});

		mAdapter = new FRRoomSuggestionArrayAdapter<FRRoom>(
				getApplicationContext(),
				mAutoCompleteSuggestionArrayListFRRoom, mModel);

		mAutoCompleteSuggestionInputBarElement
				.setOnKeyPressedListener(new OnKeyPressedListener() {
					@Override
					public void onKeyPressed(String text) {
						mAutoCompleteSuggestionListView.setAdapter(mAdapter);

						if (mAutoCompleteSuggestionInputBarElement
								.getInputText().length() == 0) {
							mAutoCompleteSuggestionInputBarElement
									.setButtonText(null);
							mAutoCompleteSuggestionListView.invalidate();
							addAllFavsToAutoComplete();
						} else {
							mAutoCompleteSuggestionInputBarElement
									.setButtonText("");
							if (text.length() >= 2) {
								AutoCompleteRequest request = new AutoCompleteRequest(
										text);
								mController.autoCompleteBuilding(view, request);
							}
						}
					}
				});
	}

	private void addAllFavsToAutoComplete() {
		Map<String, String> map = mModel.getAllRoomMapFavorites();

		mAutoCompleteSuggestionArrayListFRRoom.clear();

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String uid = iter.next();
			String doorCode = map.get(uid);
			FRRoom room = new FRRoom(doorCode, uid);
			if (!selectedRooms.contains(room)) {
				mAutoCompleteSuggestionArrayListFRRoom.add(room);
			}
		}

		mAdapter.notifyDataSetChanged();
	}

	/**
	 * Initialize the autocomplete suggestion list
	 */
	private void createSuggestionsList() {
		mAutoCompleteSuggestionListView = new LabeledListViewElement(this);
		mAutoCompleteSuggestionInputBarElement
				.addView(mAutoCompleteSuggestionListView);

		mAutoCompleteSuggestionListView
				.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int pos, long id) {

						FRRoom room = mAutoCompleteSuggestionArrayListFRRoom
								.get(pos);
						addRoomToCheck(room);
						searchButton.setEnabled(auditSubmit() == 0);
						// refresh the autocomplete, such that selected rooms
						// are not displayed
						if (mAutoCompleteSuggestionInputBarElement
								.getInputText().length() == 0) {
							addAllFavsToAutoComplete();
						} else {
							autoCompletedUpdated();
						}

						// WE DONT REMOVE the text in the input bar
						// INTENTIONNALLY: user may want to select multiple
						// rooms in the same building
					}
				});
		mAutoCompleteSuggestionListView.setAdapter(mAdapter);
	}

	private void addRoomToCheck(FRRoom room) {
		// we only add if it already contains the room
		if (!selectedRooms.contains(room)) {
			selectedRooms.add(room);
			mSummarySelectedRoomsTextView
					.setText(getSummaryTextFromCollection(selectedRooms));

		} else {
			Log.e(this.getClass().toString(),
					"room cannot be added: already added");
		}
	}

	private String getSummaryTextFromCollection(Collection<FRRoom> collec) {
		Iterator<FRRoom> iter = collec.iterator();
		StringBuffer buffer = new StringBuffer(collec.size() * 5);
		FRRoom room = null;
		buffer.append(getString(R.string.freeroom_check_occupancy_search_text_selected_rooms)
				+ " ");
		boolean empty = true;
		while (iter.hasNext()) {
			empty = false;
			room = iter.next();
			buffer.append(room.getDoorCode() + ", ");
		}
		buffer.setLength(buffer.length() - 2);
		String result = "";
		if (empty) {
			result = getString(R.string.freeroom_check_occupancy_search_text_no_selected_rooms);
		} else {
			result = buffer.toString();
		}
		return result;
	}

	/**
	 * Reset the year, month, day, hour_start, minute_start, hour_end,
	 * minute_end to their initial values. DONT forget to update the date/time
	 * pickers afterwards.
	 */
	private void resetTimes() {
		FRPeriod mFrPeriod = FRTimes.getNextValidPeriod();
		resetTimes(mFrPeriod);
	}

	private void resetTimes(FRPeriod mFrPeriod) {
		Calendar mCalendar = Calendar.getInstance();
		mCalendar.setTimeInMillis(mFrPeriod.getTimeStampStart());
		yearSelected = mCalendar.get(Calendar.YEAR);
		monthSelected = mCalendar.get(Calendar.MONTH);
		dayOfMonthSelected = mCalendar.get(Calendar.DAY_OF_MONTH);
		startHourSelected = mCalendar.get(Calendar.HOUR_OF_DAY);
		startMinSelected = mCalendar.get(Calendar.MINUTE);
		mCalendar.setTimeInMillis(mFrPeriod.getTimeStampEnd());
		endHourSelected = mCalendar.get(Calendar.HOUR_OF_DAY);
		endMinSelected = mCalendar.get(Calendar.MINUTE);
	}

	private void updateDateTimePickers() {
		// reset the time pickers
		mDatePickerDialog.updateDate(yearSelected, monthSelected,
				dayOfMonthSelected);
		mTimePickerStartDialog.updateTime(startHourSelected, startMinSelected);
		mTimePickerEndDialog.updateTime(endHourSelected, endMinSelected);
	}

	private void reset() {
		searchButton.setEnabled(false);

		// // reset the list of selected rooms
		selectedRooms.clear();
		// mSummarySelectedRoomsTextView
		// .setText(getString(R.string.freeroom_check_occupancy_search_text_no_selected_rooms));
		//
		// mAutoCompleteSuggestionArrayListFRRoom.clear();

		resetTimes();
		updateDateTimePickers();

		anyButton.setChecked(true);
		specButton.setChecked(false);
		favButton.setChecked(false);
		userDefButton.setChecked(false);
		// resetUserDefined(); TODO
		freeButton.setChecked(true);
		//
		searchButton.setEnabled(auditSubmit() == 0);
		// show the buttons
		updatePickersButtons();
	}

	private void updatePickersButtons() {
		updateShowDatePicker();
		updateShowStartTimePicker();
		updateShowEndTimePicker();
	}

	private void updateShowDatePicker() {
		showDatePicker.setText(dateFormat.format(new Date(prepareFRFrPeriod()
				.getTimeStampStart())));
	}

	private void updateShowStartTimePicker() {
		showStartTimePicker
				.setText(getString(R.string.freeroom_check_occupancy_search_start)
						+ " : "
						+ timeFormat.format(new Date(prepareFRFrPeriod()
								.getTimeStampStart())));
	}

	private void updateShowEndTimePicker() {
		showEndTimePicker
				.setText(getString(R.string.freeroom_check_occupancy_search_end)
						+ " : "
						+ timeFormat.format(new Date(prepareFRFrPeriod()
								.getTimeStampEnd())));
		if (endHourSelected >= FRTimes.LAST_HOUR_CHECK
				|| (endHourSelected == FRTimes.LAST_HOUR_CHECK - 1 && endMinSelected != 0)) {
			addHourButton.setEnabled(false);
		} else {
			addHourButton.setEnabled(true);
		}
	}

	/**
	 * Construct the <code>FRPeriod</code> object asscociated with the current
	 * selected times.
	 * 
	 * @return
	 */
	private FRPeriod prepareFRFrPeriod() {
		Calendar start = Calendar.getInstance();
		start.set(yearSelected, monthSelected, dayOfMonthSelected,
				startHourSelected, startMinSelected, 0);
		start.set(Calendar.MILLISECOND, 0);

		Calendar end = Calendar.getInstance();
		end.set(yearSelected, monthSelected, dayOfMonthSelected,
				endHourSelected, endMinSelected, 0);
		end.set(Calendar.MILLISECOND, 0);

		// constructs the request
		return new FRPeriod(start.getTimeInMillis(), end.getTimeInMillis(),
				false);
	}

	/**
	 * Prepare the actual query to send and set it in the controller
	 */
	private void prepareSearchQuery() {
		FRPeriod period = prepareFRFrPeriod();

		List<String> mUIDList = new ArrayList<String>(selectedRooms.size());

		if (favButton.isChecked()) {
			mUIDList.addAll(mModel.getAllRoomMapFavorites().keySet());
		}
		if (userDefButton.isChecked()) {
			Iterator<FRRoom> iter = selectedRooms.iterator();
			while (iter.hasNext()) {
				FRRoom room = iter.next();
				mUIDList.add(room.getUid());
			}
		}

		boolean any = anyButton.isChecked();
		boolean fav = favButton.isChecked();
		boolean user = userDefButton.isChecked();
		FRRequestDetails details = new FRRequestDetails(period,
				freeButton.isChecked(), mUIDList, any, fav, user, selectedRooms);
		mModel.setFRRequestDetails(details);
		mController.sendFRRequest(this);
		popupSearchWindow.dismiss();

	}

	/**
	 * Check that the times set are valid, according to the shared definition.
	 * 
	 * @return 0 if times are valids, positive integer otherwise
	 */
	private int auditTimes() {
		// NOT EVEN SET, we don't bother checking
		if (yearSelected == -1 || monthSelected == -1
				|| dayOfMonthSelected == -1) {
			return 1;
		}
		if (startHourSelected == -1 || endHourSelected == -1
				|| startMinSelected == -1 || endMinSelected == -1) {
			return 1;
		}

		// IF SET, we use the shared method checking the prepared period

		String errors = FRTimes.validCalendarsString(prepareFRFrPeriod());
		if (errors.equals("")) {
			return 0;
		}

		Toast.makeText(
				getApplicationContext(),
				"Please review the time, should be between Mo-Fr 8am-7pm.\n"
						+ "The end should also be after the start, and at least 5 minutes.",
				Toast.LENGTH_LONG).show();
		Toast.makeText(getApplicationContext(),
				"Errors remaining: \n" + errors, Toast.LENGTH_LONG).show();
		return 1;
	}

	/**
	 * This method check if the client is allowed to submit a request to the
	 * server.
	 * 
	 * @return 0 if there is no error and the client can send the request,
	 *         something else otherwise.
	 */
	private int auditSubmit() {
		if (selectedRooms == null
				|| (!anyButton.isChecked() && !favButton.isChecked()
						&& userDefButton.isChecked() && selectedRooms.isEmpty())) {
			return 1;
		}

		if (anyButton.isChecked()
				&& (favButton.isChecked() || userDefButton.isChecked())) {
			return 1;
		}
		if (!anyButton.isChecked() && !favButton.isChecked()
				&& !userDefButton.isChecked()) {
			return 1;
		}
		// we dont allow query all the room, including non-free
		if (anyButton.isChecked() && !freeButton.isChecked()) {
			return 1;
		}
		return auditTimes();
	}

	@Override
	public void autoCompletedUpdated() {
		mAdapter.notifyDataSetInvalidated();
		mAutoCompleteSuggestionArrayListFRRoom.clear();

		// TODO: adapt to use the new version of autocomplete mapped by building
		Iterator<List<FRRoom>> iter = mModel.getAutoComplete().values()
				.iterator();
		System.out.println(mModel.getAutoComplete().values().size());
		while (iter.hasNext()) {
			List<FRRoom> list = iter.next();
			System.out.println(list.size());
			Iterator<FRRoom> iterroom = list.iterator();
			while (iterroom.hasNext()) {
				FRRoom room = iterroom.next();
				System.out.println(room);
				// rooms that are already selected are not displayed...
				if (!selectedRooms.contains(room)) {
					mAutoCompleteSuggestionArrayListFRRoom.add(room);
				}
			}
		}

		mAdapter.notifyDataSetChanged();
	}
}