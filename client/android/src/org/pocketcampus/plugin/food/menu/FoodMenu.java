/**
 * Campus menu class
 * 
 * @status incomplete
 * @author elodie
 * @license 
 *
 */
package org.pocketcampus.plugin.food.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.pocketcampus.R;
import org.pocketcampus.core.communication.RequestParameters;
import org.pocketcampus.plugin.food.FoodDisplayHandler;
import org.pocketcampus.plugin.food.FoodDisplayHandler.FoodDisplayType;
import org.pocketcampus.plugin.food.FoodPlugin;
import org.pocketcampus.plugin.food.RestaurantListAdapter;
import org.pocketcampus.plugin.food.request.MenusRequest;
import org.pocketcampus.plugin.food.request.RatingsRequest;
import org.pocketcampus.plugin.logging.Tracker;
import org.pocketcampus.shared.plugin.food.Meal;
import org.pocketcampus.shared.plugin.food.Rating;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Adapter;

public class FoodMenu {
	private List<Meal> campusMenu_;
	private FoodPlugin pluginHandler_;
	private Context ctx_;
	private Date validityDate_;
	private final String RESTO_PREFS_NAME = "RestoPrefs";
	private boolean isMenus_;

	/**
	 * Food menu for the corresponding food plugin.
	 * 
	 * @param ownerActivity
	 */
	public FoodMenu(FoodPlugin ownerActivity) {
		pluginHandler_ = ownerActivity;
		ctx_ = ownerActivity.getApplicationContext();
		// Instantiate menuEPFL
		campusMenu_ = new ArrayList<Meal>();
		loadCampusMenu();
	}

	// Get menu to display
	public List<Meal> getCampusMenu() {
		return this.campusMenu_;
	}

	public List<Meal> getCampusMenuPrefered() {
		List<Meal> filteredMenus = filterMenus(this.campusMenu_);
		return filteredMenus;
	}

	private List<Meal> filterMenus(List<Meal> allMeals) {
//		List<String> restaurants = restaurantsFromFile();
		ArrayList<String> restaurants = getRestaurants();
		if(restaurants.isEmpty()){
			Log.d("PREFERENCES", "DAMN");
		}
		ArrayList<String> prefsRestaurants = new ArrayList<String>(); 
		
		SharedPreferences prefs = pluginHandler_.getSharedPreferences(RESTO_PREFS_NAME, 0);
		
		if(!prefs.getAll().isEmpty()){
			Log.d("PREFERENCES", "Prefs wasn't empty");
			for(String r : restaurants){
				Log.d("PREFERENCES", "Ya ce restaurant dans le fichier : " + r);
				if(prefs.getBoolean(r, false)){
					Log.d("PREFERENCES","Il l'a ajout�");
					prefsRestaurants.add(r);
				}
			}
		}else{
			Log.d("PREFERENCES", "Prefs was empty");
			prefsRestaurants = restaurants;
		}
		
		List<Meal> prefMeals = new ArrayList<Meal>();
		if (prefsRestaurants != null) {

			for (String r : prefsRestaurants) {
				Log.d("PREFERENCES", "Resto in the File : " + r);
				for (Meal m : campusMenu_) {
					if (m.getRestaurant_().getName().equals(r)) {
						prefMeals.add(m);
					}
				}
			}
		} else {
			prefMeals = campusMenu_;
		}

		return prefMeals;
	}

	public void setCampusMenu(List<Meal> menus) {
		this.campusMenu_ = menus;
	}

	public void setCampusRatings(HashMap<Integer, Rating> ratings) {
		if (campusMenu_ != null && !campusMenu_.isEmpty()) {
			for (Meal m : campusMenu_) {
				m.setRating(ratings.get(m.hashCode()));
			}
		}
	}

	public Date getValidityDate() {
		return validityDate_;
	}

	public void setValidityDate(Date date) {
		validityDate_ = date;
	}

	public void refreshMenu() {
		Log.d("SERVER", "Refreshing.");
		Tracker.getInstance().trackPageView("food/refreshMenus");
		if (campusMenu_.isEmpty() || !isValidMenu()) {
			Log.d("SERVER", "Reloading menus");
			loadCampusMenu();
		} else {
			// Refresh only ratings.
			Log.d("SERVER", "Reloading ratings");
			loadRatings(true);
		}
	}

	public boolean isValidMenu() {
		Calendar cal = Calendar.getInstance();
		Calendar validity = Calendar.getInstance();
		validity.setTime(validityDate_);
		if (cal.get(Calendar.DAY_OF_MONTH) == validity
				.get(Calendar.DAY_OF_MONTH)) {
			if (cal.get(Calendar.MONTH) == validity.get(Calendar.MONTH)) {
				if (cal.get(Calendar.YEAR) == validity.get(Calendar.YEAR)) {
					if (getMinutes(validity.getTime(), cal.getTime()) < 10) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private long getMinutes(Date then, Date now) {
		long diff = now.getTime() - then.getTime();

		long diffMinutes = diff / (60 * 1000);

		System.out.println(diffMinutes);
		return diffMinutes;
	}

	public boolean isEmpty() {
		return campusMenu_.isEmpty();
	}

	// Load ratings from server
	public void loadRatings(final boolean isRefreshWholeMenu) {
		pluginHandler_.menuRefreshing();

		class RealRatingsRequest extends RatingsRequest {

			@Override
			public void onCancelled() {
				Log.d("SERVER", "Task cancelled (FoodMenu)");
			}

			@Override
			public void updateRatings(
					HashMap<Integer, Rating> campusMenuRatingsList) {
				isMenus_ = false;
				
				if (campusMenuRatingsList != null) {
					setCampusRatings(campusMenuRatingsList);
				} else {
					Log.d("SERVER", "null ratings");
				}
				if (isRefreshWholeMenu) {
					pluginHandler_.menuRefreshed(true, isMenus_);
				} else {
					FoodDisplayHandler fdh = pluginHandler_
							.getFoodDisplayHandler();
					if (fdh.getCurrentDisplayType() == FoodDisplayType.Restaurants) {
						Adapter adapt = fdh.getListAdapter().getExpandableList(
								pluginHandler_
										.getString(R.string.food_restaurants));
						if (adapt != null) {
							if (adapt instanceof RestaurantListAdapter) {
								for (Meal m : getCampusMenu()) {
									((RestaurantListAdapter) adapt).repaint(m);
								}
							}
						}
					} else if (fdh.getCurrentDisplayType() == FoodDisplayType.Ratings) {
						pluginHandler_.menuRefreshed(true, isMenus_);
					}
					pluginHandler_.refreshed();
				}
			}
		}
		Log.d("SERVER", "Requesting ratings (FoodMenu)");
		FoodPlugin.getFoodRequestHandler().execute(new RealRatingsRequest(),
				"getRatings", (RequestParameters) null);
	}

	// Load menu from server
	private void loadCampusMenu() {
		pluginHandler_.menuRefreshing();
		isMenus_ = true;
		
		class RealMenusRequest extends MenusRequest {

			@Override
			public void onCancelled() {
				Log.d("SERVER", "Task cancelled (FoodMenu)");
				pluginHandler_.menuRefreshed(false, isMenus_);
			}

			@Override
			public void updateMenus(List<Meal> campusMenuList) {
				if (campusMenuList != null) {
					if (campusMenuList.isEmpty()) {
					} else {
						setCampusMenu(campusMenuList);
						Date currentDate = new Date();
						setValidityDate(currentDate);
						writeToFile(currentDate);
					}
				} else {
					Log.d("SERVER", "null menu");
					List<Meal> fromCache = restoreFromFile();
					if (fromCache != null) {
						setCampusMenu(fromCache);
					}
				}
				pluginHandler_.menuRefreshed(true, isMenus_);
			}

		}

		Log.d("SERVER", "Requesting menus (FoodMenu)");
		FoodPlugin.getFoodRequestHandler().execute(new RealMenusRequest(),
				"getMenus", (RequestParameters) null);
	}

	public void writeToFile(Date currentDate) {
		String filename = "MenusCache";
		File menuFile = new File(ctx_.getCacheDir(), filename);

		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		// cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);

		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(menuFile);
			out = new ObjectOutputStream(fos);
			out.writeObject(cal.getTime());
			out.writeObject(campusMenu_);
			out.close();
		} catch (IOException ex) {
			Log.d("SERVER", "Writing IO Exception");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Meal> restoreFromFile() {
		String filename = "MenusCache";
		List<Meal> menu = null;
		File toGet = new File(ctx_.getCacheDir(), filename);
		FileInputStream fis = null;
		ObjectInputStream in = null;
		Date date = null;
		try {
			fis = new FileInputStream(toGet);
			in = new ObjectInputStream(fis);
			date = (Date) in.readObject();
			Log.d("Date", date.toString());
			setValidityDate(date);

			menu = (List<Meal>) in.readObject();

			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (ClassCastException ex) {
			ex.printStackTrace();
		}

		return menu;
	}

//	@SuppressWarnings("unchecked")
//	public List<String> restaurantsFromFile() {
//		String filename = "RestaurantsPref";
//		List<String> restos = null;
//		File toGet = new File(ctx_.getDir("preferences", 0), filename);
//		FileInputStream fis = null;
//		ObjectInputStream in = null;
//
//		try {
//			fis = new FileInputStream(toGet);
//			in = new ObjectInputStream(fis);
//
//			restos = (List<String>) in.readObject();
//
//			in.close();
//		} catch (IOException ex) {
//		} catch (ClassNotFoundException ex) {
//		} catch (ClassCastException cce) {
//		}
//
//		return restos;
//	}
	
	private ArrayList<String> getRestaurants() {
		ArrayList<String> list = new ArrayList<String>();

		try {
			InputStream instream = this.getClass().getResourceAsStream(
					"restaurants_names.txt");

			if (instream != null) {
				
				InputStreamReader inputreader = new InputStreamReader(instream);
				BufferedReader input = new BufferedReader(inputreader);

				try {
					String line = null; // not declared within while loop

					while ((line = input.readLine()) != null) {
						list.add(line);
					}
				} finally {
					input.close();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return list;
	}

}
