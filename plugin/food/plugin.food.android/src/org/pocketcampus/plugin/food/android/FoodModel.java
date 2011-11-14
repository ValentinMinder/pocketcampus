package org.pocketcampus.plugin.food.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.pocketcampus.android.platform.sdk.core.IView;
import org.pocketcampus.android.platform.sdk.core.PluginModel;
import org.pocketcampus.plugin.food.android.iface.IFoodModel;
import org.pocketcampus.plugin.food.android.iface.IFoodView;
import org.pocketcampus.plugin.food.android.utils.MealTag;
import org.pocketcampus.plugin.food.android.utils.MenuSorter;
import org.pocketcampus.plugin.food.shared.Meal;
import org.pocketcampus.plugin.food.shared.Restaurant;
import org.pocketcampus.plugin.food.shared.Sandwich;
import org.pocketcampus.plugin.food.shared.SubmitStatus;

public class FoodModel extends PluginModel implements IFoodModel {
	IFoodView mListeners = (IFoodView) getListeners();
	private List<Restaurant> mRestaurantsList;
	private List<Meal> mMeals;
	private List<Sandwich> mSandwiches;
	
	// private HashMap<Meal, Rating> mCampusMeals;
	private MenuSorter mSorter;

	@Override
	protected Class<? extends IView> getViewInterface() {
		return IFoodView.class;
	}

	/**
	 * Sets the list of all Restaurants proposing menus
	 * */
	@Override
	public void setRestaurantsList(List<Restaurant> list) {
		if (mListeners != null) {
			this.mRestaurantsList = list;
			// Notifiy the view
			this.mListeners.restaurantsUpdated();
		}
	}

	/**
	 * Gets the list of all Restaurants proposing menus
	 */
	@Override
	public List<Restaurant> getRestaurantsList() {
		return this.mRestaurantsList;
	}

	@Override
	public void setMeals(List<Meal> list) {
		this.mMeals = list;
		// Notify the view
		this.mListeners.menusUpdated();
	}

	@Override
	public List<Meal> getMeals() {
		return this.mMeals;
	}

	@Override
	public HashMap<String, Vector<Meal>> getMealsByRestaurants(){
		if(mSorter == null){
			mSorter = new MenuSorter();
		}
		return mSorter.sortByRestaurant(mMeals);
	}

	/**
	 * get the list of all meal tags
	 * */
	@Override
	public List<MealTag> getMealTags() {
		List<MealTag> tags = new ArrayList<MealTag>();
		MealTag[] arrayTags = MealTag.values();

		for (int i = 0; i < arrayTags.length; i++) {
			tags.add(arrayTags[i]);
		}

		return tags;
	}

	/**
	 * set the Rating for a particular Meal
	 * */
	@Override
	public void setRating(SubmitStatus status) {
		// Toast suivant le status
	}

	@Override
	public void setSandwiches(List<Sandwich> list) {
		mSandwiches = list;
	}

	@Override
	public HashMap<String, Vector<Sandwich>> getSandwichesByRestaurants() {
		if (mSorter == null) {
			mSorter = new MenuSorter();
		}
		return mSorter.sortByCafeterias(mSandwiches);
	}

}
