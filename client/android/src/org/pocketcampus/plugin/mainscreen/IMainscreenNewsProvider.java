package org.pocketcampus.plugin.mainscreen;

import java.util.List;

/**
 * This interface allows the plugins to display some news on the mainscreen
 * 
 * 
 * @author Guillaume Ulrich
 *
 */
public interface IMainscreenNewsProvider {

	public List<MainscreenNews> getNews();
	
}
