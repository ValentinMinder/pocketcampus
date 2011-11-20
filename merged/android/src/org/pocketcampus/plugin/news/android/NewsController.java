package org.pocketcampus.plugin.news.android;

import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginModel;
import org.pocketcampus.plugin.news.android.iface.INewsController;
import org.pocketcampus.plugin.news.android.req.FeedsRequest;
import org.pocketcampus.plugin.news.android.req.NewsItemsRequest;
import org.pocketcampus.plugin.news.shared.NewsService.Client;
import org.pocketcampus.plugin.news.shared.NewsService.Iface;

import android.util.Log;

/**
 * Controller for the news plugin. Takes care of interactions between the model
 * and the view and gets information from the server.
 * 
 * @author Elodie (elodienilane.triponez@epfl.ch)
 */
public class NewsController extends PluginController implements INewsController {

	/** The plugin's model. */
	private NewsModel mModel;

	/** Interface to the plugin's server client */
	private Iface mClient;

	/** The name of the plugin */
	private String mPluginName = "news";

	/**
	 * Initializes the plugin with a model and a client.
	 */
	@Override
	public void onCreate() {
		// Initializing the model is part of the controller's job...
		mModel = new NewsModel();

		// ...as well as initializing the client.
		// The "client" is the connection we use to access the service.
		mClient = (Iface) getClient(new Client.Factory(), mPluginName);
	}

	/**
	 * Returns the model for which this controller works.
	 */
	@Override
	public PluginModel getModel() {
		return mModel;
	}

	/**
	 * Initiates a request to the server to get the news items.
	 */
	@Override
	public void getNewsItems() {
		new NewsItemsRequest().start(this, mClient, (Object) null);
	}

	/**
	 * Initiates a request to the server to get the news Feeds.
	 */
	@Override
	public void getFeeds() {
		Log.d("NEWS", "Sending feeds request");
		new FeedsRequest().start(this,
				(Iface) getClient(new Client.Factory(), mPluginName),
				(Object) null);
	}
}