package org.pocketcampus.plugin.transport.android;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.pocketcampus.R;
import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.android.platform.sdk.ui.PCSectionedList.PCEntryAdapter;
import org.pocketcampus.android.platform.sdk.ui.PCSectionedList.PCEntryItem;
import org.pocketcampus.android.platform.sdk.ui.PCSectionedList.PCItem;
import org.pocketcampus.android.platform.sdk.ui.PCSectionedList.PCSectionItem;
import org.pocketcampus.android.platform.sdk.ui.dialog.PCDetailsDialog;
import org.pocketcampus.android.platform.sdk.ui.labeler.IRichLabeler;
import org.pocketcampus.android.platform.sdk.ui.layout.StandardTitledLayout;
import org.pocketcampus.plugin.transport.android.iface.ITransportView;
import org.pocketcampus.plugin.transport.android.utils.TransportFormatter;
import org.pocketcampus.plugin.transport.shared.QueryTripsResult;
import org.pocketcampus.plugin.transport.shared.TransportConnection;
import org.pocketcampus.plugin.transport.shared.TransportStation;
import org.pocketcampus.plugin.transport.shared.TransportTrip;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;

/**
 * The Main View of the Transport plugin, first displayed when accessing
 * Transport.
 * 
 * Displays the next departures for the destinations that the user has set as
 * preferred destinations. The preferred destinations are stored in the android
 * shared preferences and displayed each time the user accesses the Transport
 * plugin. He can go to the edit view to delete them more or add more
 * destinations.
 * 
 * @author Oriane <oriane.rodriguez@epfl.ch>
 * @author Pascal <pascal.scheiben@epfl.ch>
 * @author Florian <florian.laurent@epfl.ch>
 * 
 */
public class TransportMainView extends PluginView implements ITransportView {
	/** Main Activity of the plugin */
	private Activity mActivity;
	/* MVC */
	/** The plugin controller */
	private TransportController mController;
	/** The plugin model */
	private TransportModel mModel;
	/* Layout */
	/** The main Layout consisting of two inner layouts and a title */
	private StandardTitledLayout mLayout;
	/** The ListView to display next departures */
	private ListView mListView;
	/* Preferences */
	/** The pointer to access and modify preferences stored on the phone */
	private SharedPreferences mDestPrefs;
	/** Interface to modify values in SharedPreferences object */
	private Editor mDestPrefsEditor;
	/** The name under which the preferences are stored on the phone */
	private static final String DEST_PREFS_NAME = "TransportDestinationsPrefs";

	/** The labeler that says how to display a Location */
	private IRichLabeler<TransportTrip> mConnectionLabeler = new IRichLabeler<TransportTrip>() {
		@Override
		public String getLabel(TransportTrip dest) {
			return "";
		}

		@Override
		public String getTitle(TransportTrip obj) {
			return obj.getTo().getName();
		}

		@Override
		public String getDescription(TransportTrip obj) {
			return stringifier(obj);
		}

		@Override
		public double getValue(TransportTrip obj) {
			return -1;
		}

		@Override
		public Date getDate(TransportTrip obj) {
			return null;
		}

	};

	/**
	 * Defines what the main controller is for this view.
	 */
	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return TransportController.class;
	}

	/**
	 * On display. Called when first displaying the view. Retrieve the model and
	 * the controller and
	 */
	@Override
	protected void onDisplay(Bundle savedInstanceState,
			PluginController controller) {
		mActivity = this;
		mController = (TransportController) controller;
		mModel = (TransportModel) mController.getModel();

		mDestPrefs = getSharedPreferences(DEST_PREFS_NAME, 0);
		mDestPrefsEditor = mDestPrefs.edit();

		// Set up the main layout and the list view
		setUpLayout();
		setUpListView();

		// Set up the action bar with a button
		setUpActionBar();

		// Set up destinations that will be displayed
		mModel.freeConnections();
		setUpDestinations();

	}

	/**
	 * Called when this view is accessed after already having been initialized
	 * before. Refreshes the next departures.
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		mModel.freeConnections();
		// Set up the main layout and the list view
		setUpLayout();
		setUpListView();

		// Set up the action bar with a button
		setUpActionBar();
		setUpDestinations();
	}

	/**
	 * Main Transport Options menu contains access to the preferred destinations
	 * and the settings
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.transport_menu, menu);
		return true;
	}

	/**
	 * Decides what happens when the options menu is opened and an option is
	 * chosen (which view to display).
	 */
	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.transport_destinations) {
			Intent i = new Intent(this, TransportEditView.class);
			startActivity(i);
		}
		// else if (id == R.id.transport_settings) { Log.d("TRANSPORT",
		// "Settings");}

		return true;
	}

	private void setUpLayout() {
		// Main layout
		mLayout = new StandardTitledLayout(this);
		mLayout.setTitle(getResources().getString(
				R.string.transport_plugin_name));
		mLayout.hideTitle();

		setContentView(mLayout);
	}

	private void setUpListView() {
		// Creates the list view and sets its click listener
		mListView = new ListView(this);
		mListView.setId(1234);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				String txt = ((PCEntryItem) ((ListView) arg0)
						.getItemAtPosition(arg2)).id;
				if (txt != null) {
					detailsDialog(txt);
				}

			}
		});
		// Adds it to the layout
		mLayout.addFillerView(mListView);
	}

	/**
	 * Retrieves the action bar and adds a button to it, which will, when
	 * clicked, open the edit view of the transport plugin.
	 */
	private void setUpActionBar() {
		Intent intent = new Intent(getApplicationContext(),
				TransportEditView.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		ActionBar a = getActionBar();
		if (a != null) {
			a.addAction(new ActionBar.IntentAction(getApplicationContext(),
					intent, R.drawable.transport_action_bar_edit), 0);
			RefreshAction refresh = new RefreshAction();
			a.addAction(refresh, 1);
		}
	}

	/**
	 * Set up which destinations have to be displayed. First checks if there are
	 * destinations in the shared preferences. If yes, asks for next departures,
	 * and if not, opens the add view of the transport plugin to let the user
	 * add a destination.
	 */
	private void setUpDestinations() {
		Map<String, Integer> prefs = (Map<String, Integer>) mDestPrefs.getAll();
		// If no destinations set, display a message
		if (prefs == null || prefs.isEmpty()) {
			mLayout.removeFillerView();
			mLayout.setText(getResources().getString(
					R.string.transport_no_destinations_message));
		} else {
			mLayout.hideText();
			Set<String> set = prefs.keySet();
			List<String> list = new ArrayList<String>();

			for (String s : set) {
				list.add(s);
			}
			// Binds the names with actual Location objects
			mController.getLocationsFromNames(list);
		}
	}

	/**
	 * Asks the server for connections in order to display the list of preferred
	 * destinations along with the next departures to go there.
	 */
	private void displayDestinations() {
		// Gets the user's preferred destinations from the model
		HashMap<String, List<TransportTrip>> locations = mModel
				.getPreferredDestinations();

		if (locations != null && !locations.isEmpty()) {
			for (String loc : locations.keySet()) {
				mController.nextDeparturesFromEPFL(loc);
			}
			setItemsToDisplay(locations);
		}

	}

	/**
	 * Called by the model when the data for the resulted connections has been
	 * updated.
	 */
	@Override
	public void connectionsUpdated(QueryTripsResult result) {
		// Log.d("TRANSPORT", "Connection Updated (view)");
		HashMap<String, List<TransportTrip>> mDisplayedLocations = mModel
				.getPreferredDestinations();

		setItemsToDisplay(mDisplayedLocations);

	}

	/**
	 * Called by the model when the list of preferred destinations has been
	 * updated and refreshes the view.
	 */
	@Override
	public void destinationsUpdated() {
		// Log.d("TRANSPORT", "Destinations updated (view)");
		displayDestinations();
	}

	/**
	 * Called by the model when the locations from the destinations names have
	 * been updated and displays the next departures.
	 */
	@Override
	public void locationsFromNamesUpdated(List<TransportStation> result) {
		// Log.d("TRANSPORT", "Locations from Names updated (view)");
		displayDestinations();
	}

	/**
	 * Displays a toast when an error happens upon contacting the server
	 */
	@Override
	public void networkErrorHappened() {
		Toast toast = Toast.makeText(getApplicationContext(), getResources()
				.getString(R.string.transport_network_error),
				Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * Called when connections are received from the server. Creates the items
	 * to be displayed (Destination name with time until departure) and update
	 * the shared preferences. (This is not done before to make sure we store
	 * the correct location name in the preferences).
	 */
	private void setItemsToDisplay(
			HashMap<String, List<TransportTrip>> mDisplayedLocations) {
		Set<String> set = mDisplayedLocations.keySet();
		ArrayList<PCItem> items = new ArrayList<PCItem>();

		for (String l : set) {
			if (!mDisplayedLocations.get(l).isEmpty()) {
				items.add(new PCSectionItem(l));
				int i = 0;

				for (TransportTrip c : mDisplayedLocations.get(l)) {
					if (i < 3) {
						Date dep = new Date();
						dep.setTime(c.getDepartureTime());
						Date now = new Date();
						if (dep.after(now)) {

							i++;
							Log.d("TRANSPORT", "Dep was after now. " + i);

							// Updates the shared preferences
							mDestPrefsEditor.putInt(c.getTo().getName(), c
									.getTo().getId());
							mDestPrefsEditor.commit();

							String logo = "";
							for (TransportConnection p : c.parts) {
								if (!p.foot) {
									logo = p.line.getName();
									break;
								}
							}

							logo = TransportFormatter.getNiceName(logo);
							PCEntryItem entry = new PCEntryItem(
									timeString(c.getDepartureTime()), logo,
									c.id);

							items.add(entry);
						}
					}
				}
			}
		}

		PCEntryAdapter adapter = new PCEntryAdapter(this, items);

		mListView.setAdapter(adapter);
		mListView.invalidate();
	}

	/**
	 * Creates a detailed dialog for a particular trip.
	 * 
	 * @param connection
	 */
	private void detailsDialog(String connection) {
		// Create the Builder for the Trip dialog
		PCDetailsDialog.Builder b = new PCDetailsDialog.Builder(mActivity);
		b.setCanceledOnTouchOutside(true);

		// Set different values for the dialog
		b.setTitle(connection);

		PCDetailsDialog dialog = b.create();
//		dialog.show();
	}

	/**
	 * Takes the time before next departures in milliseconds and transforms it
	 * to a text in the form : "In x hour(s), y minute(s)."
	 * 
	 * @param milliseconds
	 *            the time until the next departure.
	 * @return s the string representing the time left until the departure.
	 */
	private String timeString(long milliseconds) {
		String s = getResources().getString(R.string.transport_in);

		Date now = new Date();
		Date then = new Date();
		then.setTime(milliseconds);

		long diff = then.getTime() - now.getTime();
		Date timeTillDeparture = new Date();
		timeTillDeparture.setTime(diff);

		diff = diff / 1000; // seconds
		int minutes = (int) diff / 60; // minutes
		int hours = (int) diff / 3660; // hours

		if (hours > 0) {
			if (hours == 1) {
				s = s.concat(" " + hours + " "
						+ getResources().getString(R.string.transport_hour)
						+ ",");
			} else {
				s = s.concat(" " + hours + " "
						+ getResources().getString(R.string.transport_hours)
						+ ",");
			}
		}

		while (minutes > 60) {
			minutes = minutes - 60;
		}

		if (minutes > 0) {
			if (minutes == 1) {
				s = s.concat(" " + minutes + " "
						+ getResources().getString(R.string.transport_minute));
			} else {
				s = s.concat(" " + minutes + " "
						+ getResources().getString(R.string.transport_minutes));
			}
		}

		if (hours == 0 && minutes == 0) {
			s = getResources().getString(R.string.transport_departure_now);
		}

		return s;
	}

	/**
	 * Returns a text of the form : "HH:MM", which represents a
	 * <code>Connection</code> departure time.
	 * 
	 * @param c
	 *            The <code>Connection</code> we want the text for.
	 * @return r The text representation of the <code>Connection</code>
	 *         departure time.
	 */
	private String stringifier(TransportTrip c) {
		final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm");
		String r = getResources().getString(R.string.transport_departure_at)
				+ " " + FORMAT.format(c.getDepartureTime());

		return r;
	}

	/**
	 * Returns a text representation of a <code>Connection</code> object. It
	 * will display a list of parts of the trip.
	 * 
	 * @param c
	 *            The <code>Connection</code> we want the text representation
	 *            for.
	 * @return r The text representation of the <code>Connection</code> object.
	 */
	private String stringifierDetails(TransportTrip c) {
		final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm");
		String r = getResources().getString(R.string.transport_departure_at)
				+ " " + FORMAT.format(c.getDepartureTime()) + ", "
				+ getResources().getString(R.string.transport_arrival_at)
				+ ": " + FORMAT.format(c.getArrivalTime());

		r += "\n" + c.getFrom();
		for (TransportConnection p : c.getParts()) {
			r += " -> " + p.getArrival();
		}

		return r;
	}

	/**
	 * Not used in this view
	 */
	@Override
	public void autoCompletedDestinationsUpdated() {
	}

	/**
	 * Refreshes the next departures when clicking on the action bar refresh
	 * button.
	 * 
	 * @author Oriane <oriane.rodriguez@epfl.ch>
	 * 
	 */
	private class RefreshAction implements Action {

		RefreshAction() {
		}

		@Override
		public int getDrawable() {
			return R.drawable.transport_action_bar_refresh;
		}

		@Override
		public void performAction(View view) {
			displayDestinations();
		}
	}
}
