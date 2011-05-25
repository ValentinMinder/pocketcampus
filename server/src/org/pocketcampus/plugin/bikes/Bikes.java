package org.pocketcampus.plugin.bikes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.pocketcampus.core.plugin.IPlugin;
import org.pocketcampus.core.plugin.PublicMethod;
import org.pocketcampus.provider.mapelements.IMapElementsProvider;
import org.pocketcampus.shared.plugin.authentication.AuthToken;
import org.pocketcampus.shared.plugin.bikes.BikeStation;
import org.pocketcampus.shared.plugin.map.MapElementBean;
import org.pocketcampus.shared.plugin.map.MapLayerBean;

public class Bikes implements IPlugin, IMapElementsProvider {

	
	private ArrayList<BikeStation> bikes_;
	private Date lastRequest_;
	
	private MapLayerBean mlb_;
	private List<MapLayerBean> mlbs_;
	
	private final static long REFRESH_TIME = 5*60*1000;
	
	public Bikes() {
		try {
			bikes_ = new BikeStationParser().parserBikes();
			lastRequest_ = new Date();
		} catch (IOException e) {
			bikes_ = null;
			lastRequest_ = null;
		}

		mlb_ = new MapLayerBean("Velopass", "data/map/map_marker_bike.png", this, 1, 300, true);
		mlbs_ = new ArrayList<MapLayerBean>();
		mlbs_.add(mlb_);
	}

	
	@PublicMethod
	public ArrayList<BikeStation> bikes(HttpServletRequest request) {
		
		Date now = new Date();
		if(bikes_ == null || lastRequest_ == null || (now.getTime()-lastRequest_.getTime()) > REFRESH_TIME) {
			try {
				bikes_ = new BikeStationParser().parserBikes();
				lastRequest_ = now;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return bikes_;
    }
	
	@PublicMethod
	public String getLayerId(HttpServletRequest request) {
		return mlb_.getExternalId();
    }

	@Override
	public List<MapLayerBean> getLayers() {
		return mlbs_;
	}

	@Override
	public List<MapElementBean> getLayerItems(AuthToken token, int layerId) {
		ArrayList<BikeStation> b = bikes(null);
		
		List<MapElementBean> items = new ArrayList<MapElementBean>();
		
		for(BikeStation s : b) {
			StringBuffer description = new StringBuffer();
			description.append("Vélos libres: ");
			description.append(String.valueOf(s.getFreeBikes()));
			description.append("\n");
			
			description.append("Places libres: ");
			description.append(String.valueOf(s.getEmptyRacks()));
			
			items.add(new MapElementBean(s.getName(), description.toString(), s.getGeoLat(), s.getGeoLng(), 0, 1, s.getId(), "org.pocketcampus.plugin.bikes.BikesPlugin"));
		}
		
		return items;
		
	}
	

}
