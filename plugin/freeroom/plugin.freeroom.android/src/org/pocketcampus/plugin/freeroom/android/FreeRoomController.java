package org.pocketcampus.plugin.freeroom.android;

import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginModel;
import org.pocketcampus.plugin.freeroom.R;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomController;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomView;
import org.pocketcampus.plugin.freeroom.android.req.AutoCompleteRequestASyncTask;
import org.pocketcampus.plugin.freeroom.android.req.CheckWhoIsWorkingRequest;
import org.pocketcampus.plugin.freeroom.android.req.FRRequestASyncTask;
import org.pocketcampus.plugin.freeroom.android.req.ImWorkingRequestASyncTask;
import org.pocketcampus.plugin.freeroom.shared.AutoCompleteReply;
import org.pocketcampus.plugin.freeroom.shared.AutoCompleteRequest;
import org.pocketcampus.plugin.freeroom.shared.FROccupancyReply;
import org.pocketcampus.plugin.freeroom.shared.FRStatusCode;
import org.pocketcampus.plugin.freeroom.shared.FreeRoomService.Client;
import org.pocketcampus.plugin.freeroom.shared.FreeRoomService.Iface;
import org.pocketcampus.plugin.freeroom.shared.ImWorkingReply;
import org.pocketcampus.plugin.freeroom.shared.ImWorkingRequest;
import org.pocketcampus.plugin.freeroom.shared.RegisterUser;
import org.pocketcampus.plugin.freeroom.shared.WhoIsWorkingReply;
import org.pocketcampus.plugin.freeroom.shared.WhoIsWorkingRequest;

import android.util.Log;
import android.widget.Toast;

/**
 * FreeRoomController - Main logic for the FreeRoom Plugin - controller part in
 * MVC scheme.
 * <p>
 * This class issues requests to the FreeRoom PocketCampus server to get the
 * FreeRoom data for the user.
 * <p>
 * This class is organized and ordered as follows: <br>
 * - communs values, start at {@link #onCreate()}<br>
 * - handling general replies, start at
 * {@link #handleReplySuccess(IFreeRoomView, int, String, String, String)} <br>
 * - occupancy requests, start at {@link #sendFRRequest(IFreeRoomView)} <br>
 * - autocomplete request, start at
 * {@link #autoCompleteBuilding(IFreeRoomView, AutoCompleteRequest)}<br>
 * - imworking request (share with server), start at
 * {@link #prepareImWorking(ImWorkingRequest)}<br>
 * - check who is working there, start at
 * {@link #prepareCheckWhoIsWorking(WhoIsWorkingRequest)}<br>
 * - register the user to the beta-release, start at
 * {@link #sendRegisterUser(RegisterUser, IFreeRoomView)}<br>
 * 
 * 
 * @author FreeRoom Project Team (2014/05)
 * @author Julien WEBER <julien.weber@epfl.ch>
 * @author Valentin MINDER <valentin.minder@epfl.ch>
 * 
 */
public class FreeRoomController extends PluginController implements
		IFreeRoomController {

	/**
	 * This name must match given in the Server.java file in
	 * plugin.launcher.server. It's used to route the request to the right
	 * server implementation.
	 */
	private String mPluginName = "freeroom";

	/**
	 * Stores reference to the Model associated with this plugin.
	 */
	private FreeRoomModel mModel;

	/**
	 * HTTP Clients used to communicate with the PocketCampus server. Use thrift
	 * to transport the data.
	 */
	private Iface mClient;

	@Override
	public void onCreate() {
		mModel = new FreeRoomModel(getApplicationContext());
		mClient = (Iface) getClient(new Client.Factory(), mPluginName);

	}

	@Override
	public PluginModel getModel() {
		return mModel;
	}

	// HANDLING GENERAL RESPONSES.

	public void handleReplySuccess(IFreeRoomView caller, FRStatusCode status,
			String statusComment, String callingClass, String requestClass) {
		Log.v(callingClass, "Server replied successfully to a " + requestClass
				+ "!");
	}

	public void handleReplyError(IFreeRoomView caller, FRStatusCode status,
			String statusComment, String callingClass) {
		Log.e(callingClass, "the server response was not successful. Message: "
				+ statusComment);
		if (status == FRStatusCode.HTTP_BAD_REQUEST) {
			Log.e(callingClass,
					"server complains about a bad request from the client");
			caller.freeRoomServerBadRequest();
		} else if (status == FRStatusCode.HTTP_INTERNAL_ERROR) {
			Log.e(callingClass, "server had an internal error");
			caller.freeRoomServersInternalError();
		} else {
			Log.e(callingClass, "server sent another UNKNOWN status" + status
					+ "/" + statusComment);
			caller.freeRoomServersUnknownError();
		}
	}

	// OCCUPANCY REQUEST
	/**
	 * Sends the occupancy request stored in the model to the server.
	 * 
	 * @param view
	 *            the caller view
	 */
	public void sendFRRequest(IFreeRoomView view) {
		new FRRequestASyncTask(view).start(this, mClient,
				mModel.getFRRequestDetails());
	}

	/**
	 * Sets the FRReply results received from the server in the model.
	 * 
	 * @param result
	 *            FRReply results received from the server
	 */
	public void setOccupancyResults(FROccupancyReply result) {
		mModel.setOverAllTreatedPeriod(result.getOverallTreatedPeriod());
		mModel.setOccupancyResults(result.getOccupancyOfRooms());
	}

	// AUTOCOMPLETE

	public void autoCompleteBuilding(IFreeRoomView view,
			AutoCompleteRequest request) {
		mModel.autoCompleteLaunch();
		new AutoCompleteRequestASyncTask(view).start(this, mClient, request);
	}

	public void setAutoCompleteResults(AutoCompleteReply result) {
		mModel.setAutoComplete(result.getListRoom());
	}

	// IMWORKING - SHARE WITH SERVER

	private ImWorkingRequest imWorkingRequest;

	public void prepareImWorking(ImWorkingRequest request) {
		imWorkingRequest = request;
	}

	public void ImWorking(IFreeRoomView view) {
		if (imWorkingRequest != null) {
			new ImWorkingRequestASyncTask(view).start(this, mClient,
					imWorkingRequest);
			imWorkingRequest = null;
		} else {
			Log.e(this.getClass().toString(),
					"request not defined in controller!");
		}
	}

	// IM WORKING - REPLY

	/**
	 * Tells the user the <code>ImWorkingRequest</code> he submitted was
	 * accepted and registered by the server. (200 OK)
	 * 
	 * <p>
	 * The user will never be blocked to send other request and reuse the
	 * buttons. The server will handle these cases and reply with a
	 * conflict/update.
	 * 
	 * @param reply
	 *            the reply from the server
	 */
	public void validateImWorking(ImWorkingReply reply) {
		Log.v("controller-imWorking-ok200",
				"Your working indication was succcessfully submitted");
		if (mModel.isOnlyServer()) {
			Toast.makeText(
					this,
					getString(R.string.freeroom_share_server_basis)
							+ " "
							+ getString(
									R.string.freeroom_share_server_submitted)
									.toUpperCase(), Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Tells the user the <code>ImWorkingRequest</code> he submitted was
	 * accepted and registered by the server, and updated correctly his previous
	 * indication. (299 updated)
	 * 
	 * <p>
	 * The user will never be blocked to send other request and reuse the
	 * buttons. The server will handle these cases and reply with a
	 * conflict/update.
	 * 
	 * @param reply
	 *            the reply from the server
	 */
	public void updateImWorking(ImWorkingReply reply) {
		Log.v("controller-imWorking-updated299",
				"Your working indication was succcessfully updated");
		if (mModel.isOnlyServer()) {
			Toast.makeText(
					this,
					getString(R.string.freeroom_share_server_basis)
							+ " "
							+ getString(R.string.freeroom_share_server_updated)
									.toUpperCase(), Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * "Tells the user" (only in the log actually) that the period he wanted to
	 * submit was already used. Should be called when the server replies with a
	 * conflict status (409).
	 * 
	 * @param reply
	 *            the reply from the server
	 */
	public void conflictImWorking(ImWorkingReply reply) {
		Log.v("controller-imWorking-conflict409",
				"You already submitted something for this period of time, "
						+ "you request was denied by the server "
						+ "(conflict)");
		if (mModel.isOnlyServer()) {
			Toast.makeText(this,
					getString(R.string.freeroom_share_server_conflict),
					Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * "Tells the user" that the message was rejected because of a bad word.
	 * 
	 * @param reply
	 *            the reply from the server
	 */
	public void badWordsImWorking(ImWorkingReply reply) {
		Log.v("controller-imWorking-predCondFailed",
				"User submitted a bad word!");
		if (mModel.isOnlyServer()) {
			Toast.makeText(this,
					getString(R.string.freeroom_share_server_bad_words),
					Toast.LENGTH_LONG).show();
		}
	}

	// WHO IS WORKING REQUEST

	/**
	 * Stores the prepared request for future sending to the server.
	 */
	private WhoIsWorkingRequest whoIsWorkingRequest = null;

	/**
	 * Stores a <code>WhoIsWorkingRequest</code> for future use.
	 * 
	 * This is should be used before changing activity, and you can call the
	 * corresponding method (same name without "prepare").
	 * 
	 * @param request
	 *            the <code>WhoIsWorkingRequest</code> to store.
	 */
	public void prepareCheckWhoIsWorking(WhoIsWorkingRequest request) {
		this.whoIsWorkingRequest = request;
	}

	/**
	 * Sends the ALREADY prepared <code>WhoIsWorkingRequest</code> to the
	 * server.
	 * 
	 * @param view
	 *            the holder <code>IFreeRoomView</code> calling.
	 */
	public void checkWhoIsWorking(IFreeRoomView view) {
		if (whoIsWorkingRequest != null) {
			new CheckWhoIsWorkingRequest(view).start(this, mClient,
					whoIsWorkingRequest);
			whoIsWorkingRequest = null;
		} else {
			Log.e(this.getClass().toString(),
					"request not defined in controller!");
		}
	}

	/**
	 * Sets the <code>WhoIsWorkingReply</code> results received from the server
	 * in the model.
	 * 
	 * @param result
	 *            the <code>WhoIsWorkingReply</code> from the server.
	 */
	public void setWhoIsWorkingReply(WhoIsWorkingReply result) {
		mModel.setListMessageFrequency(result.getMessages());
	}

}