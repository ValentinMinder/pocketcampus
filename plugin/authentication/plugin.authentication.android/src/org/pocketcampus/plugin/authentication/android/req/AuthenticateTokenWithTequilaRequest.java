package org.pocketcampus.plugin.authentication.android.req;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.pocketcampus.android.platform.sdk.io.Request;
import org.pocketcampus.plugin.authentication.android.AuthenticationController;
import org.pocketcampus.plugin.authentication.android.AuthenticationController.TokenCookieComplex;
import org.pocketcampus.plugin.authentication.android.AuthenticationModel;

/**
 * AuthenticateTokenWithTequilaRequest
 * 
 * This class sends an HttpRequest to the Tequila server directly
 * in order to authenticate the token the we got for a specific service.
 * This class connects to Tequila over a secure HTTPS connection.
 * 
 * @author Amer <amer.chamseddine@epfl.ch>
 *
 */
public class AuthenticateTokenWithTequilaRequest extends Request<AuthenticationController, DefaultHttpClient, TokenCookieComplex, Boolean> {
	
	@Override
	protected Boolean runInBackground(DefaultHttpClient client, TokenCookieComplex param) throws Exception {
		HttpGet get = new HttpGet(String.format(AuthenticationController.tequilaAuthTokenUrl, param.token.getITequilaKey()));
		get.addHeader("Cookie", AuthenticationController.tequilaCookieName + "=" + param.cookie);
		HttpResponse resp = client.execute(get);
		return (resp.getFirstHeader("Location") != null);
	}

	@Override
	protected void onResult(AuthenticationController controller, Boolean result) {
		AuthenticationModel am = ((AuthenticationModel) controller.getModel());
		if(result) {
			am.setAuthenticatedToken(am.getTequilaKey().getITequilaKey());
		} else {
			am.getListenersToNotify().notifyCookieTimedOut();
		}
	}
	
	@Override
	protected void onError(AuthenticationController controller, Exception e) {
		controller.getModel().notifyNetworkError();
		e.printStackTrace();
	}
	
}