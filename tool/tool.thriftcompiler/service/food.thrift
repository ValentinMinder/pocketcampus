namespace java org.pocketcampus.plugin.food.shared

include "../include/common.thrift"

typedef i32 int

struct Restaurant {
	1: required common.Id id;
	2: required string name;
	3: optional common.Location location;
}

enum RatingValue {
	STAR_0_0;
	STAR_0_5;
	STAR_1_0;
	STAR_1_5;
	STAR_2_0;
	STAR_2_5;
	STAR_3_0;
	STAR_3_5;
	STAR_4_0;
	STAR_4_5;
	STAR_5_0;
}

struct Rating {
	1: required RatingValue value;
	2: required int nbVotes;
	3: required double totalRating;
}

struct Meal {
	1: required common.Id id;
	2: required string name;
	3: required string description;
	4: required Restaurant restaurant;
	5: required Rating rating;
	6: optional double price;
}

struct Sandwich {
	1: required common.Id id;
	2: required Restaurant restaurant;
	3: required string name;
}

service FoodService {
	list<Meal> getMeals();
	list<Restaurant> getRestaurants();
	Rating getRating(1: Meal meal);
	map<int, Rating> getRatings();
	void setRating(1: Rating rating);
}