package org.pocketcampus.plugin.map.cache;

import java.util.List;

import org.pocketcampus.plugin.map.elements.MapElementsList;

/**
 * Define an interface that is given to the {@link LayersCache} object when loading preferences   
 * 
 * @status Complete
 * 
 * @author Jonas
 *
 */
public interface ILayersCacheCallback {
	/**
	 * Called when the preferences have been fetched.
	 * @param selected A list of selected layers, contain the current layer objects, can be used directly.
	 */
	void onLayersLoadedFromFile(List<MapElementsList> selected);
}
