package org.pocketcampus.plugin.satellite.android;

import org.pocketcampus.R;
import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.android.platform.sdk.ui.element.ImageTextView;
import org.pocketcampus.android.platform.sdk.ui.labeler.IFeedViewLabeler;
import org.pocketcampus.android.platform.sdk.ui.labeler.ILabeler;
import org.pocketcampus.android.platform.sdk.ui.layout.StandardTitledDoubleLayout;
import org.pocketcampus.android.platform.sdk.utils.LoaderImageView;
import org.pocketcampus.plugin.satellite.android.display.AffluenceImageView;
import org.pocketcampus.plugin.satellite.android.iface.ISatelliteMainView;
import org.pocketcampus.plugin.satellite.shared.Affluence;
import org.pocketcampus.plugin.satellite.shared.Beer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * The Main View of the Satellite plugin, first displayed when accessing
 * Satellite.
 * 
 * Displays the beer of the month and the affluence at Satellite.
 * 
 * @author Oriane <oriane.rodriguez@epfl.ch>
 * 
 */
public class SatelliteMainView extends PluginView implements ISatelliteMainView {
	/** The Plugin Model */
	private SatelliteModel mModel;

	/** The Plugin Controller */
	private SatelliteController mController;

	/** A Standard Titled Layout */
	private StandardTitledDoubleLayout mLayout;

	/**
	 * Defines what the main controller is for this view.
	 */
	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return SatelliteController.class;
	}

	/**
	 * Called once the view is connected to the controller. If you don't
	 * implement <code>getMainControllerClass()</code> then the controller given
	 * here will simply be <code>null</code>.
	 */
	@Override
	protected void onDisplay(Bundle savedInstanceState,
			PluginController controller) {
		mController = (SatelliteController) controller;
		mModel = (SatelliteModel) mController.getModel();

		mLayout = new StandardTitledDoubleLayout(this);
		mLayout.setTitle(getResources().getString(
				R.string.satellite_menu_main_page));

		setContentView(mLayout);

		showMainPage();
	}

	/**
	 * Called when this view is accessed after already having been initialized
	 * before
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
	}

	public void showMainPage() {
		mController.getAffluence();
		mController.getBeerOfMonth();
	}

	public void showBeers() {
		mController.getAllBeers();
	}

	/**
	 * Main Satellite Options menu contains access to Beers, Events, Sandwiches
	 * and back to Main Page
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.satellite_menu, menu);
		return true;
	}

	/**
	 * Decides what happens when the options menu is opened and an option is
	 * chosen (what view to display)
	 */
	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		/*
		 * if (item.getItemId() == R.id.satellite_main_page) {
		 * mLayout.removeFillerView(); mLayout.hideText();
		 * mLayout.setTitle(getResources
		 * ().getString(R.string.satellite_menu_main_page)); showMainPage(); }
		 * else if (item.getItemId() == R.id.satellite_beers) {
		 * mLayout.removeFillerView(); mLayout.hideText();
		 * mLayout.setTitle(getResources
		 * ().getString(R.string.satellite_menu_beers)); showBeers(); } else
		 */if (item.getItemId() == R.id.satellite_events) {
			Log.d("SATELLITE", "Starting Events Activity");
			Intent events = new Intent(this, SatelliteEventsView.class);
			startActivity(events);
		} else if (item.getItemId() == R.id.satellite_sandwiches) {
			Log.d("SATELLITE", "Starting Sandwiches Activity");
			Intent sandwiches = new Intent(this, SatelliteSandwichesView.class);
			startActivity(sandwiches);
		}
		return true;
	}

	@Override
	public void beerUpdated() {
		Log.d("SATELLITE", "Beer updated (View)");
		Beer beer = mModel.getBeerOfMonth();
		if (beer != null) {
			ImageTextView t = new ImageTextView(beer, getApplicationContext(), mBeerLabeler, 0);
			mLayout.addSecondLayoutFillerView(t);
		}
	}

	@Override
	public void affluenceUpdated() {
		Log.d("SATELLITE", "Affluence updated (View)");

		Affluence a = mModel.getAffluence();

		if (a != null) {
			AffluenceImageView view = new AffluenceImageView(a, this, mAffluenceLabeler);
			mLayout.addFirstLayoutFillerView(view);
		}
	}

	/**
	 * Displays a toast when an error happens upon contacting the server
	 */
	@Override
	public void networkErrorHappened() {
		Toast toast = Toast
				.makeText(getApplicationContext(),
						getString(R.string.satellite_network_error),
						Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * The labeler for the affluence, to tell how it has to be displayed in a generic view
	 */
	ILabeler<Affluence> mAffluenceLabeler = new ILabeler<Affluence>() {

		@Override
		public String getLabel(Affluence obj) {
			return obj.name();
		}
		
	};
	
	/**
	 * The labeler for a Beer, to tell how it has to be displayed in a generic
	 * view.
	 */
	IFeedViewLabeler<Beer> mBeerLabeler = new IFeedViewLabeler<Beer>() {

		@Override
		public String getTitle(Beer beer) {
			return beer.getName();
		}

		@Override
		public String getDescription(Beer beer) {
			return beer.getDescription();
		}

		@Override
		public LinearLayout getPictureLayout(Beer beer) {
			return new LoaderImageView(getApplicationContext(), beer.getPictureUrl());
		}

	};

	@Override
	public void sandwichesUpdated() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void eventsUpdated() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	@Override
//	public void beersUpdated() {
//		Log.d("SATELLITE", "Beers updated (View)");
//
//		List<Beer> beers = mModel.getAllBeers();
//
//		if (beers != null && !beers.isEmpty()) {
//
//			RichLabeledListViewElement l = new RichLabeledListViewElement(this,
//					beers, mBeerLabeler);
//
//			mLayout.addFillerView(l);
//		}
//
//	}

}