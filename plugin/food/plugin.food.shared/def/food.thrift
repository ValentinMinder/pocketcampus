namespace java org.pocketcampus.plugin.food.shared
namespace csharp org.pocketcampus.plugin.food.shared

include "../../../../plugin/map/plugin.map.shared/def/map.thrift"

// OLD SHIT

struct Restaurant {
	1: required i64 restaurantId;
	2: required string name;
}

struct Rating {
	1: required double ratingValue;
	2: required i32 numberOfVotes;
	3: required double sumOfRatings;
}

struct Meal {
	1: required i64 mealId;
	2: required string name;
	3: required string mealDescription;
	4: required Restaurant restaurant;
	5: required Rating rating;
}


// NEW SHIT

enum SubmitStatus {
	ALREADY_VOTED;
	VALID;
	TOO_EARLY;
	ERROR;
}

enum PriceTarget {
    STUDENT = 1,
    PHD_STUDENT = 2,
    STAFF = 3,
    VISITOR = 4,
    ALL = 5
}

enum MealType {
    UNKNOWN = 1,
    FISH = 2,
    MEAT = 3,
    POULTRY = 4,
    VEGETARIAN = 5,
    GREEN_FORK = 6,
    PASTA = 7,
    PIZZA = 8,
    THAI = 9,
    INDIAN = 10,
    LEBANESE = 11
}

enum MealTime {
    LUNCH = 1,
    DINNER = 2
}

typedef i32 timestamp

struct EpflRating {
    1: required double ratingValue;
    2: required i32 voteCount;
}

struct EpflMeal {
	1: required i64 mId;
	2: required string mName;
	3: required string mDescription;
	4: required map<PriceTarget, double> mPrices;
	5: optional double mHalfPortionPrice;
	6: required list<MealType> mTypes;
	7: required EpflRating mRating;
}

struct EpflRestaurant {
    1: required i64 rId;
    2: required string rName;
    3: required list<EpflMeal> rMeals;
    4: optional map.MapItem rLocation;
    5: required EpflRating rRating;
}

struct FoodRequest {
	1: required string deviceLanguage = "fr";
	2: required MealTime mealTime = MealTime.LUNCH;
	3: required timestamp mealDate = -1; // "now"
	4: optional string deviceId;
}

struct FoodResponse {
	1: required list<EpflRestaurant> matchingFood;
}

struct VoteRequest {
	1: required i64 mealId;
	2: required double rating;
	3: required string deviceId;
}

struct VoteResponse {
	1: required SubmitStatus submitStatus;
}


service FoodService {
	list<Meal> getMeals();
	map<i64, Rating> getRatings();
	SubmitStatus setRating(1: i64 mealId, 2: double rating, 3: string deviceId);
	
	FoodResponse getFood(1: FoodRequest foodReq);
	VoteResponse vote(1: VoteRequest voteReq);
}
