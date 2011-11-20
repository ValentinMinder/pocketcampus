package org.pocketcampus.plugin.satellite.android.req;

import java.util.List;

import org.pocketcampus.android.platform.sdk.io.Request;
import org.pocketcampus.plugin.satellite.android.SatelliteController;
import org.pocketcampus.plugin.satellite.android.SatelliteModel;
import org.pocketcampus.plugin.satellite.shared.Sandwich;
import org.pocketcampus.plugin.satellite.shared.SatelliteService.Iface;

import android.util.Log;

/**
 * Request to the server to get the list of sandwiches that Satellite proposes
 * 
 * @author Oriane <oriane.rodriguez@epfl.ch>
 * 
 */
public class SandwichRequest extends
		Request<SatelliteController, Iface, Object, List<Sandwich>> {

	/**
	 * Initiate the <code>getSandwiches</code> Request at the server
	 * 
	 * @param client
	 *            the client that communicates with the server
	 * @param param
	 *            the parameters to be sent for the request. Not used.
	 * @return the list of all Sandwiches at Satellite
	 */
	@Override
	protected List<Sandwich> runInBackground(Iface client, Object param)
			throws Exception {
		Log.d("<SandwichRequest>:", "Run");
		return client.getSatSandwiches();
	}

	/**
	 * Update the model with the Sandwiches gotten from the server.
	 * 
	 * @param controller
	 *            the controller that initiated the request, of which we have to
	 *            notify of the result
	 * @param result
	 *            the list of Sandwiches gotten from the server
	 */
	@Override
	protected void onResult(SatelliteController controller, List<Sandwich> result) {
		Log.d("<SandwichRequest>:", "onResult");
		((SatelliteModel) controller.getModel()).setSandwiches(result);
	}

	/**
	 * Notifies the Model that an error has occurred while processing the
	 * request.
	 * 
	 * @param controller
	 *            the controller that initiated the request
	 */
	@Override
	protected void onError(SatelliteController controller, Exception e) {
		Log.d("<SandwichRequest>:", "onError");
		controller.getModel().notifyNetworkError();
		e.printStackTrace();
	}

}