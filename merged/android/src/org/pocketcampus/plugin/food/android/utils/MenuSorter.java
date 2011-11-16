package org.pocketcampus.plugin.food.android.utils;

/**
 * Sorts menus
 * 
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.pocketcampus.plugin.food.shared.Meal;
import org.pocketcampus.plugin.food.shared.Sandwich;

public class MenuSorter {

	public MenuSorter() {
	}

	/**
	 * sorts the meals by Rating (best rates first)
	 * 
	 * @param the
	 *            collection of meals for the day
	 * 
	 * @return the sorted list of meals
	 **/
	public Vector<Meal> sortByRatings(List<Meal> menus) {
		if (menus == null) {
			throw new IllegalArgumentException(
					"The meals list cannot be null !");
		}

		Collections.sort(menus, new RatingComparator());
		Collections.reverse(menus);

		Vector<Meal> mealsVector = new Vector<Meal>();

		for (Meal meal : menus) {
			mealsVector.add(meal);
		}

		return mealsVector;
	}

	/**
	 * sorts the meals by Restaurant (Alphabetical order)
	 * 
	 * @param the
	 *            collection of meals for the day
	 * 
	 * @return the sorted list of meals
	 **/
	public HashMap<String, Vector<Meal>> sortByRestaurant(Collection<Meal> meals) {

		if (meals == null) {
			throw new IllegalArgumentException(
					"The meals list cannot be null !");
		}

		HashMap<String, Vector<Meal>> map = new HashMap<String, Vector<Meal>>();

		for (Meal meal : meals) {
			String resto = meal.getRestaurant().getName();

			if (!meal.getMealDescription().matches("\\s+")) {
				if (map.containsKey(resto)) {
					map.get(resto).add(meal);
				} else {
					Vector<Meal> vector = new Vector<Meal>();
					vector.add(meal);
					map.put(resto, vector);
				}
			} else {
				System.out.println("SortingMeals: Skip empty Description: "
						+ meal.getMealDescription() + " - Name: "
						+ meal.getName() + " Resto: " + meal.getRestaurant());
			}
		}
		Set<String> menus = map.keySet();

		// Sort menus alphabetically
		for (String resto : menus) {
			Collections.sort(map.get(resto), new Comparator<Meal>() {
				public int compare(Meal one, Meal other) {
					return one.getName().compareTo(other.getName());
				}
			});
		}

		return map;
	}
	
	public HashMap<String, Vector<Sandwich>> sortByCafeterias(Collection<Sandwich> sandwiches) {
		
		if (sandwiches == null) {
			throw new IllegalArgumentException(
					"The meals list cannot be null !");
		}

		HashMap<String, Vector<Sandwich>> map = new HashMap<String, Vector<Sandwich>>();
		
		for (Sandwich sandwich : sandwiches) {
			String resto = sandwich.getRestaurant().getName();

			if (!sandwich.getName().matches("\\s+")) {
				if (map.containsKey(resto)) {
					map.get(resto).add(sandwich);
				} else {
					Vector<Sandwich> vector = new Vector<Sandwich>();
					vector.add(sandwich);
					map.put(resto, vector);
				}
			} else {
				System.out.println("SortingSanwiches: Skip empty - Name: "
						+ sandwich.getName() + " Resto: " + sandwich.getRestaurant().getName());
			}
		}
		Set<String> restos = map.keySet();

		// Sort menus alphabetically
		for (String resto : restos) {
			Collections.sort(map.get(resto), new Comparator<Sandwich>() {
				public int compare(Sandwich one, Sandwich other) {
					return one.getName().compareTo(other.getName());
				}
			});
		}
		
		return map;
		
	}

	/**
	 * Compares meals using their rating, in order to sort them.
	 * 
	 */
	private class RatingComparator implements Comparator<Meal> {

		public int compare(Meal thisMeal, Meal otherMeal) {
			if (thisMeal.getRating() == null) {
				String thisMealString = "" + thisMeal;
				throw new IllegalArgumentException(thisMealString);
			}
			double d0 = thisMeal.getRating().getRatingValue();
			double d1 = otherMeal.getRating().getRatingValue();
			if (d0 != d1) {
				return (d0 < d1 ? -1 : 1);
			} else {
				int n0 = thisMeal.getRating().getNbVotes();
				int n1 = thisMeal.getRating().getNbVotes();
				return (n0 < n1 ? -1 : 1);
			}
		}
	}
}