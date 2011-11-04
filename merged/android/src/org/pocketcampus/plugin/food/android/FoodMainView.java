package org.pocketcampus.plugin.food.android;

import java.util.ArrayList;
import java.util.List;

import org.pocketcampus.R;
import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.android.platform.sdk.ui.element.ListViewElement;
import org.pocketcampus.android.platform.sdk.ui.layout.StandardLayout;
import org.pocketcampus.plugin.food.android.iface.IFoodModel;
import org.pocketcampus.plugin.food.android.iface.IFoodView;
import org.pocketcampus.plugin.food.android.utils.SuggestionsListSection;
import org.pocketcampus.plugin.food.shared.Meal;
import org.pocketcampus.plugin.food.shared.Restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class FoodMainView extends PluginView implements IFoodView {
	/*MVC*/
	private FoodController mController;
	private IFoodModel mModel;

	/*Layout*/
	private StandardLayout mLayout;
	
	/*Constants*/
	private final int SUGGESTIONS_REQUEST_CODE = 1;

	/**
	 * Defines what the main controller is for this view. This is optional, some
	 * view may not need a controller (see for example the dashboard).
	 * 
	 * This is only a shortcut for what is done in
	 * <code>getOtherController()</code> below: if you know you'll need a
	 * controller before doing anything else in this view, you can define it as
	 * you're main controller so you know it'll be ready as soon as
	 * <code>onDisplay()</code> is called.
	 */
	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return FoodController.class;
	}

	/**
	 * Called once the view is connected to the controller. If you don't
	 * implement <code>getMainControllerClass()</code> then the controller given
	 * here will simply be <code>null</code>.
	 */
	@Override
	protected void onDisplay(Bundle savedInstanceState,
			PluginController controller) {
		// Get and cast the controller and model
		mController = (FoodController) controller;
		mModel = (FoodModel) controller.getModel();

		// The StandardLayout is a RelativeLayout with a TextView in its center.
		mLayout = new StandardLayout(this);
		
		// The ActionBar is added automatically when you call setContentView
		setContentView(mLayout);

		// We need to force the display before asking the controller for the
		// data,
		// as the controller may take some time to get it.
		displayData();
	}

	/**
	 * Displays the data
	 * For now testing with Restaurants
	 */
	private void displayData() {
		mLayout.setText("No menus");
//		mController.getRestaurantsList();
		mController.getMeals();
	}

	@Override
	public void networkErrorHappened() {
		Toast toast = Toast.makeText(getApplicationContext(), "Network error!",
				Toast.LENGTH_SHORT);
		toast.show();
	}

	/**
	 * Main Food Options menu contains access to Sandwiches, Suggestions and
	 * Settings
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.food_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		if (item.getItemId() == R.id.food_by_resto) {
			
		} else if (item.getItemId() == R.id.food_by_sandwiches) {
			
		} else if (item.getItemId() == R.id.food_by_suggestions) {
			Intent suggestions = new Intent(getApplicationContext(), FoodSuggestionsView.class);
			ArrayList<Meal> meals = (ArrayList<Meal>)mModel.getMeals();
			
			if(meals == null)
				Log.d("SUGGESTIONS", "Pas de meals envoyés");
			else
				Log.d("SUGGESTIONS", "Extras : " + meals.size());
			
			suggestions.putExtra("org.pocketcampus.suggestions.meals", meals);
			startActivityForResult(suggestions, SUGGESTIONS_REQUEST_CODE);
		} else if (item.getItemId() == R.id.food_by_settings) {
			
		}

		return true;
	}
	
	public void restaurantsUpdated() {
		List<Restaurant> mRestaurantList = mModel.getRestaurantsList();
		List<String> mRestaurantStringList = new ArrayList<String>();
		
		for(Restaurant r : mRestaurantList) {
			mRestaurantStringList.add(r.name);
			Log.d("RESTAURANT", "Restaurant : " + r.name);
		}
		
		ListViewElement l = new ListViewElement(this, mRestaurantStringList);
		
		mLayout.removeAllViews();
		mLayout.addView(l);
	}

	@Override
	public void menusUpdated() {
		// Update meals
		List<Meal> mMealList = mModel.getMeals();
		
		for(Meal m : mMealList) {
			Log.d("MEAL", "MEAL : " + m);
		}
		
		// ListViewElement l = new ListViewElement(this, l);
		//
		// mLayout.removeAllViews();
		// mLayout.addView(l);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case SUGGESTIONS_REQUEST_CODE: // Result from the Suggestions class
			Log.d("SUGGESTIONS", "OnActivityResult");
			
			if (resultCode == Activity.RESULT_OK) {
				Bundle extras = data.getExtras();
				if (extras != null) {
					
					@SuppressWarnings("unchecked")
					ArrayList<Meal> list = (ArrayList<Meal>) extras.getSerializable("org.pocketcampus.suggestions.meals");
					Log.d("SUGGESTIONS", "Meals in return : " + list.size());
					
				} else {
					Log.d("SUGGESTIONS", "No extras !");
				}
			} else {
				Log.d("SUGGESTIONS", "RESULT_PAS_OK !");
			}
			break;
		}
	}
}