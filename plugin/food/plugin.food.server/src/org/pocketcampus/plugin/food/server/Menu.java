package org.pocketcampus.plugin.food.server;

import org.joda.time.LocalDate;
import org.pocketcampus.plugin.food.shared.FoodResponse;
import org.pocketcampus.plugin.food.shared.MealTime;

import com.google.gson.JsonParseException;

/**
 * Fetches the EPFL menu.
 * 
 * @author Solal Pirelli <solal.pirelli@epfl.ch>
 */
public interface Menu {
	FoodResponse get(MealTime time, LocalDate date) throws JsonParseException;
}