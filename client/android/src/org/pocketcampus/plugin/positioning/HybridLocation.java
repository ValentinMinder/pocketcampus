package org.pocketcampus.plugin.positioning;

import java.util.ArrayList;
import java.util.List;

import org.pocketcampus.provider.positioning.IPositionProvider;
import org.pocketcampus.plugin.positioning.GpsLocation;
import org.pocketcampus.plugin.positioning.WifiLocation;
import org.pocketcampus.shared.plugin.map.CoordinateConverter;
import org.pocketcampus.shared.plugin.map.Position;

import android.content.Context;
import android.location.Location;
import android.util.Log;

public class HybridLocation implements IPositionProvider{
	
	private GpsLocation gpsLocation_;
	private GsmNetworkPosition gsmLocation_;
	private WifiLocation wifiLocation_;
	private Context ctx_;
	private float accuracy_;
	
	public HybridLocation(Context _ctx){
		this.ctx_ = _ctx;
		this.gpsLocation_ = new GpsLocation(ctx_);
		this.gsmLocation_ = new GsmNetworkPosition(ctx_);
		this.wifiLocation_ = new WifiLocation(ctx_);
		this.accuracy_ = getAccuracy();
	}

	
	
	
	private float getAccuracy() {
		int numberOfAP = wifiLocation_.getnumberOfAP();
		int good = wifiLocation_.getSignificantAP();
		int accuracy = 35;
		if(good > 1){
			accuracy = 8;
		}else if (good==1){
			accuracy = 10;
		}else if((numberOfAP > 10)&&(good==0)){
			accuracy = 20;
		}else if((numberOfAP > 4)&&(good==0)){
			accuracy = 25;
		}
			
		return accuracy;
	}




	public Location getGsmPosition() {
		return this.gsmLocation_.getLocation();
	}
	
	
	public Location getGpsPosition(){
		return this.gpsLocation_.getLocation();
	}
	
	public Position getWifiLocation(){
		return wifiLocation_.getWifiLocationPerCoefficient();
		// return wifiLocation_.getWifiLocationPerTaylorSerieGlobal();
	}
	
	
	
	public Position getCombinedLocation(){
		Position centroid = wifiLocation_.getWifiLocationPerCoefficient();
		Position taylor = wifiLocation_.getWifiLocationPerTaylorSerieGlobal();
		Position result = centroid;
		if(taylor!=null && !Double.isNaN(taylor.getLatitude()) && !Double.isNaN(taylor.getLongitude())){
			if(Math.pow((centroid.getLatitude()-taylor.getLatitude()),2)+Math.pow((centroid.getLongitude()-taylor.getLongitude()), 2)<20)
				result = new Position((centroid.getLatitude()+taylor.getLatitude())/2,(centroid.getLongitude()+taylor.getLongitude())/2,0.0);
		        //result = taylor ;
		       }
		return result;
		
	}
	
	/**
	 * Returns the best location (i.e. the location with the best accuracy)
	 * @param locations a list of locations
	 * @return the best position
	 */
	private Location bestLocation(List<Location> locations) {
		float bestAccuracy = Float.MAX_VALUE;
		Location best = null;
		
		for(Location loc : locations) {
			if(loc != null) {
				if(loc.hasAccuracy() && loc.getAccuracy() != 0.0 && loc.getAccuracy() < bestAccuracy) {
					bestAccuracy = loc.getAccuracy();
					best = loc;
				} else if(best == null) {
					best = loc;
				}
			}
		}
		
		return best;
	}


	@Override
	public Location getPosition() {
		Location gsm, gps, wifi = null;
		
		//Convert the wifi position into a location with latitude/longitude
		Position w = null;
		try {
			w = getCombinedLocation();
		} catch(Exception e) {
			Log.e("HybridLocation", "Error wifi location: " + e.toString());
		}
		if(w != null && !Double.isNaN(w.getLatitude()) && !Double.isNaN(w.getLongitude())) {
			w = CoordinateConverter.convertCH1903ToLatLong(w.getLatitude(), w.getLongitude(), w.getAltitude());
			wifi = new Location("WifiLocation");
			wifi.setLatitude(w.getLatitude());
			wifi.setLongitude(w.getLongitude());
			wifi.setAltitude(w.getAltitude());
			wifi.setAccuracy(accuracy_);
		}
		
		gsm = getGsmPosition();
		gps = getGpsPosition();
		
		List<Location> l = new ArrayList<Location>(3);
		l.add(wifi);
		l.add(gsm);
		l.add(gps);
		
		return bestLocation(l);
	}

	@Override
	public boolean userInCampus() {
		if(wifiLocation_.getAccessPoints().size()==0)
		return false;
		else return true;
	}
	
	@Override
	public void startListening() {
		gsmLocation_.startListening();
		gpsLocation_.startListening();
	}
	
	@Override
	public void stopListening() {
		gsmLocation_.stopListening();
		gpsLocation_.stopListening();
	}
}



