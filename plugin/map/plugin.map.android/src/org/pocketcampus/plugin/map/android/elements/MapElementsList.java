package org.pocketcampus.plugin.map.android.elements;

import java.util.ArrayList;

import org.pocketcampus.plugin.map.android.shared.MapLayerBean;

public class MapElementsList extends ArrayList<MapElement> {

	private static final long serialVersionUID = 1054957477020550085L;

	/**
	 * The title of the layer, for example restaurant, parking, etc.
	 */
	private String layerTitle_;
	private int cacheTimeInSeconds_;
	private String layerId_;
	private String iconUrl_;
	private boolean isDisplayable_;
	
	public MapElementsList(String title, int cache) {
		layerTitle_ = title;
		cacheTimeInSeconds_ = cache;
	}
	
	public MapElementsList(MapLayerBean mlb) {
		layerTitle_ = mlb.getName();
		cacheTimeInSeconds_ = mlb.getCacheInSeconds();
		layerId_ = mlb.getExternalId();
		iconUrl_ = mlb.getDrawableUrl();
		isDisplayable_ = mlb.isDisplayable();
	}
	
	public MapElement getItemFromId(int id) {
		for(MapElement me : this) {
			if(me.getItemId() == id) {
				return me;
			}
		}
		
		return null;
	}
		
	public String getLayerId() {
		return layerId_;
	}
	
	public String getLayerTitle() {
		return layerTitle_;
	}

	public void setLayerTitle(String layerTitle) {
		this.layerTitle_ = layerTitle;
	}

	public int getCacheTimeInSeconds() {
		return cacheTimeInSeconds_;
	}

	/**
	 * Set the time in seconds the elements can be cached.
	 * 0 means no cache at all.
	 * -1 means never refresh automatically
	 * 
	 * @param cacheTimeInSeconds Cache time
	 */
	public void setCacheTimeInSeconds(int cacheTimeInSeconds) {
		this.cacheTimeInSeconds_ = cacheTimeInSeconds;
	}
		
	public String getIconUrl() {
		return iconUrl_;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl_ = iconUrl;
	}

	public boolean isDisplayable() {
		return isDisplayable_;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + ((layerId_ == null) ? 0 : layerId_.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		MapElementsList other = (MapElementsList) obj;
		if (layerId_ == null) {
			if (other.layerId_ != null)
				return false;
		} else if (!layerId_.equals(other.layerId_))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MapElementsList:<" + this.layerTitle_ + ">";
	}

}