package org.pocketcampus.plugin.map;

import java.util.ArrayList;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.tileprovider.MapTileProviderBasic;
import java.util.List;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.TilesOverlay;
import org.pocketcampus.R;
import org.pocketcampus.core.plugin.PluginBase;
import org.pocketcampus.core.plugin.PluginInfo;
import org.pocketcampus.core.plugin.PluginPreference;
import org.pocketcampus.plugin.map.elements.MapElement;
import org.pocketcampus.plugin.map.elements.MapElementsList;
import org.pocketcampus.plugin.map.ui.LayerSelector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * PluginBase class for the Map plugin 
 * 
 * @status WIP
 * 
 * @author Jonas, Johan
 *
 */
public class MapPlugin extends PluginBase {

	private MapView mapView_;
	private MapController mapController_;
	private List<MapElementsList> layers_;
	private List<MapElementsList> selectedLayers_;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.map_main);

		setupActionBar(true);

		setupMapView();
		
		// TODO debugging layers
		layers_ = new ArrayList<MapElementsList>();
		layers_.add(new MapElementsList("Restaurants", -1));
		layers_.add(new MapElementsList("People", 0));
		layers_.add(new MapElementsList("Rooms", 10));
		selectedLayers_ = new ArrayList<MapElementsList>();
	}
	
	/**
	 * The background is provided by the default tile source.
	 * We add a TileOverlay over the background (for example
	 * the map of the epfl campus).
	 */
	private void setupMapView() {

		mapView_ = (MapView) findViewById(R.id.mapview);
        
		mapController_ = mapView_.getController();
		
		mapView_.setMultiTouchControls(true);
		mapView_.setBuiltInZoomControls(true);
		
		
		// Add tiles layer
		ITileSource epflTile = new EpflTileSource();

		MapTileProviderBasic mProvider = new MapTileProviderBasic(getApplicationContext());
        mProvider.setTileSource(epflTile);
        TilesOverlay mTilesOverlay = new TilesOverlay(mProvider, this.getBaseContext());
        mapView_.getOverlays().add(mTilesOverlay);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		//center the view at epfl
		//important to set the zoom before the position (bug of osmdroid)
		mapController_.setZoom(16);
		GeoPoint epflPoint = new GeoPoint(46519732, 6566734);
		mapController_.setCenter(epflPoint);
		setDebugItemizedOverlay();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.map_menu_layers_button:
			layerSelector();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	/**
	 * Launch the dialog that allows to select the different layers
	 */
	private void layerSelector() {
		final LayerSelector l = new LayerSelector(this, layers_, selectedLayers_);
		
		// Show the dialog, using a callback to the the selected layers back
		l.selectLayers(new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				setSelectedLayers(l.getSelectedLayers());
			}
		});
		
	}
	
	/**
	 * Set the selected layers
	 * @param selectedLayers
	 */
	private void setSelectedLayers(ArrayList<MapElementsList> selectedLayers) {
		this.selectedLayers_ = selectedLayers;
		
		// TODO show the layers on the map
		for(MapElementsList l : selectedLayers_) {
			Toast.makeText(this, l.getLayerTitle(), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public PluginInfo getPluginInfo() {
		return new MapInfo();
	}

	@Override
	public PluginPreference getPluginPreference() {
		return null;
	}
	
	//XXX debug
	private void setDebugItemizedOverlay() {
		MapElementsList items = new MapElementsList("Restaurants", -1);
		items.add(new MapElement("Cafétaria INM","blabla",new GeoPoint(46.518600, 6.563316)));
		ItemizedOverlay<OverlayItem> overlays = new ItemizedIconOverlay<OverlayItem>(items, null, new DefaultResourceProxyImpl(getApplicationContext()));
		mapView_.getOverlays().add(overlays);
		
		System.out.println("overlays size " + mapView_.getOverlays().size());
	}

}
