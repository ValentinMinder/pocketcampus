package org.pocketcampus.plugin.news.android.iface;

import org.pocketcampus.android.platform.sdk.core.IView;

/**
 * Interface to the public methods of the NewsView
 * 
 * @author Elodie <elodienilane.triponez@epfl.ch>
 * 
 */
public interface INewsView extends IView {

	/**
	 * Called when the list of news has been updated
	 */
	public void newsUpdated();
}