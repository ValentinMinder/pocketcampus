package org.pocketcampus.plugin.transport.android.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.pocketcampus.R;
import org.pocketcampus.plugin.transport.android.utils.DestinationFormatter;
import org.pocketcampus.plugin.transport.shared.TransportConnection;
import org.pocketcampus.plugin.transport.shared.TransportTrip;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * The Dialog of the Transport plugin for the details of a departure. It
 * displays the details of all connections of the trip : departure and arrival
 * time, departure and arrival place, and a logo representing the type of
 * transport to use.
 * 
 * @author Oriane <oriane.rodriguez@epfl.ch>
 * @author Pascal <pascal.scheiben@epfl.ch>
 * @author Florian <florian.laurent@epfl.ch>
 * 
 */
public class TransportTripDetailsDialog extends Dialog {
	private TransportTrip connection_;
	private Context ctx_;

	/**
	 * The constructor sets the main layout and calls the
	 * <code>setDialogContents()</code> method.
	 * 
	 * @param ctxt
	 *            The application context
	 * @param connection
	 *            The TransportTrip for which we create the dialog
	 */
	public TransportTripDetailsDialog(Context ctxt, TransportTrip connection) {
		super(ctxt);
		connection_ = connection;
		ctx_ = ctxt.getApplicationContext();

		// Setups dialog.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.transport_details_dialog);

		setCanceledOnTouchOutside(true);
		setDialogContent();
	}

	/**
	 * Sets the content of the dialog.
	 */
	private void setDialogContent() {
		ArrayList<HashMap<String, String>> connectionParts = new ArrayList<HashMap<String, String>>();

		SimpleDateFormat formatter = new SimpleDateFormat();
		formatter.applyPattern("HH:mm");

		HashMap<String, String> partRow;
		for (TransportConnection part : connection_.parts) {
			partRow = new HashMap<String, String>();
			String departureTime = "";
			String departurePlace = part.departure.name;
			String arrivalTime = "";
			String arrivalPlace = part.arrival.name;

			if (!part.foot) {
				// Part is a Trip
				departureTime = formatter.format(part.getDepartureTime());
				arrivalTime = formatter.format(part.getArrivalTime());
				departurePlace = part.getDeparture().getName();
				Log.wtf("Transport", "in dialog-> dep: " + part.departureTime + " arr: " + part.arrivalTime);

			} else {
				// Part is a Footway
				departureTime = (part).min
						+ " "
						+ ctx_.getResources().getString(
								R.string.transport_walk_in_min);
			}

			partRow.put("departureTime", departureTime);
			partRow.put("departurePlace", departurePlace);

			partRow.put("arrivalTime", arrivalTime);
			partRow.put("arrivalPlace", arrivalPlace);

			connectionParts.add(partRow);
		}

		String[] keys = { "departureTime", "departurePlace", "arrivalTime",
				"arrivalPlace" };

		int[] ids = { R.id.transport_details_dialog_dep_time,
				R.id.transport_details_dialog_dep_place,
				R.id.transport_details_dialog_arr_time,
				R.id.transport_details_dialog_arr_place };

		SimpleAdapter mSchedule = new SimpleAdapter(getContext(),
				connectionParts, R.layout.transport_details_dialog_row, keys,
				ids);

		ListView list = (ListView) findViewById(R.id.transport_details_dialog_list);
		list.setAdapter(mSchedule);

		TextView title = (TextView) findViewById(R.id.transport_title_dialog);
		title.setText(DestinationFormatter.getNiceName(connection_.from) + " "
				+ ctx_.getResources().getString(R.string.transport_to) + " "
				+ DestinationFormatter.getNiceName(connection_.to));
	}
}