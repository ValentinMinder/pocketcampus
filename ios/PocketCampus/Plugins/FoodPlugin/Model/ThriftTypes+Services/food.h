/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */

#import <Foundation/Foundation.h>

#import <TProtocol.h>
#import <TApplicationException.h>
#import <TProtocolUtil.h>
#import <TProcessor.h>

#import "map.h"

enum SubmitStatus {
  SubmitStatus_ALREADY_VOTED = 0,
  SubmitStatus_VALID = 1,
  SubmitStatus_TOO_EARLY = 2,
  SubmitStatus_ERROR = 3,
  SubmitStatus_MEAL_IN_DISTANT_PAST = 4,
  SubmitStatus_MEAL_IN_FUTURE = 5
};

enum PriceTarget {
  PriceTarget_STUDENT = 1,
  PriceTarget_PHD_STUDENT = 2,
  PriceTarget_STAFF = 3,
  PriceTarget_VISITOR = 4,
  PriceTarget_ALL = 5
};

enum MealType {
  MealType_UNKNOWN = 1,
  MealType_FISH = 2,
  MealType_MEAT = 3,
  MealType_POULTRY = 4,
  MealType_VEGETARIAN = 5,
  MealType_GREEN_FORK = 6,
  MealType_PASTA = 7,
  MealType_PIZZA = 8,
  MealType_THAI = 9,
  MealType_INDIAN = 10,
  MealType_LEBANESE = 11
};

enum MealTime {
  MealTime_LUNCH = 1,
  MealTime_DINNER = 2
};

enum FoodStatusCode {
  FoodStatusCode_OK = 200,
  FoodStatusCode_NETWORK_ERROR = 404
};

@interface Restaurant : NSObject <NSCoding> {
  int64_t __restaurantId;
  NSString * __name;

  BOOL __restaurantId_isset;
  BOOL __name_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=restaurantId, setter=setRestaurantId:) int64_t restaurantId;
@property (nonatomic, retain, getter=name, setter=setName:) NSString * name;
#endif

- (id) initWithRestaurantId: (int64_t) restaurantId name: (NSString *) name;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) restaurantId;
- (void) setRestaurantId: (int64_t) restaurantId;
- (BOOL) restaurantIdIsSet;

- (NSString *) name;
- (void) setName: (NSString *) name;
- (BOOL) nameIsSet;

@end

@interface Rating : NSObject <NSCoding> {
  double __ratingValue;
  int32_t __numberOfVotes;
  double __sumOfRatings;

  BOOL __ratingValue_isset;
  BOOL __numberOfVotes_isset;
  BOOL __sumOfRatings_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=ratingValue, setter=setRatingValue:) double ratingValue;
@property (nonatomic, getter=numberOfVotes, setter=setNumberOfVotes:) int32_t numberOfVotes;
@property (nonatomic, getter=sumOfRatings, setter=setSumOfRatings:) double sumOfRatings;
#endif

- (id) initWithRatingValue: (double) ratingValue numberOfVotes: (int32_t) numberOfVotes sumOfRatings: (double) sumOfRatings;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (double) ratingValue;
- (void) setRatingValue: (double) ratingValue;
- (BOOL) ratingValueIsSet;

- (int32_t) numberOfVotes;
- (void) setNumberOfVotes: (int32_t) numberOfVotes;
- (BOOL) numberOfVotesIsSet;

- (double) sumOfRatings;
- (void) setSumOfRatings: (double) sumOfRatings;
- (BOOL) sumOfRatingsIsSet;

@end

@interface Meal : NSObject <NSCoding> {
  int64_t __mealId;
  NSString * __name;
  NSString * __mealDescription;
  Restaurant * __restaurant;
  Rating * __rating;

  BOOL __mealId_isset;
  BOOL __name_isset;
  BOOL __mealDescription_isset;
  BOOL __restaurant_isset;
  BOOL __rating_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=mealId, setter=setMealId:) int64_t mealId;
@property (nonatomic, retain, getter=name, setter=setName:) NSString * name;
@property (nonatomic, retain, getter=mealDescription, setter=setMealDescription:) NSString * mealDescription;
@property (nonatomic, retain, getter=restaurant, setter=setRestaurant:) Restaurant * restaurant;
@property (nonatomic, retain, getter=rating, setter=setRating:) Rating * rating;
#endif

- (id) initWithMealId: (int64_t) mealId name: (NSString *) name mealDescription: (NSString *) mealDescription restaurant: (Restaurant *) restaurant rating: (Rating *) rating;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) mealId;
- (void) setMealId: (int64_t) mealId;
- (BOOL) mealIdIsSet;

- (NSString *) name;
- (void) setName: (NSString *) name;
- (BOOL) nameIsSet;

- (NSString *) mealDescription;
- (void) setMealDescription: (NSString *) mealDescription;
- (BOOL) mealDescriptionIsSet;

- (Restaurant *) restaurant;
- (void) setRestaurant: (Restaurant *) restaurant;
- (BOOL) restaurantIsSet;

- (Rating *) rating;
- (void) setRating: (Rating *) rating;
- (BOOL) ratingIsSet;

@end

@interface EpflRating : NSObject <NSCoding> {
  double __ratingValue;
  int32_t __voteCount;

  BOOL __ratingValue_isset;
  BOOL __voteCount_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=ratingValue, setter=setRatingValue:) double ratingValue;
@property (nonatomic, getter=voteCount, setter=setVoteCount:) int32_t voteCount;
#endif

- (id) initWithRatingValue: (double) ratingValue voteCount: (int32_t) voteCount;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (double) ratingValue;
- (void) setRatingValue: (double) ratingValue;
- (BOOL) ratingValueIsSet;

- (int32_t) voteCount;
- (void) setVoteCount: (int32_t) voteCount;
- (BOOL) voteCountIsSet;

@end

@interface EpflMeal : NSObject <NSCoding> {
  int64_t __mId;
  NSString * __mName;
  NSString * __mDescription;
  NSDictionary * __mPrices;
  double __mHalfPortionPrice;
  NSArray * __mTypes;
  EpflRating * __mRating;

  BOOL __mId_isset;
  BOOL __mName_isset;
  BOOL __mDescription_isset;
  BOOL __mPrices_isset;
  BOOL __mHalfPortionPrice_isset;
  BOOL __mTypes_isset;
  BOOL __mRating_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=mId, setter=setMId:) int64_t mId;
@property (nonatomic, retain, getter=mName, setter=setMName:) NSString * mName;
@property (nonatomic, retain, getter=mDescription, setter=setMDescription:) NSString * mDescription;
@property (nonatomic, retain, getter=mPrices, setter=setMPrices:) NSDictionary * mPrices;
@property (nonatomic, getter=mHalfPortionPrice, setter=setMHalfPortionPrice:) double mHalfPortionPrice;
@property (nonatomic, retain, getter=mTypes, setter=setMTypes:) NSArray * mTypes;
@property (nonatomic, retain, getter=mRating, setter=setMRating:) EpflRating * mRating;
#endif

- (id) initWithMId: (int64_t) mId mName: (NSString *) mName mDescription: (NSString *) mDescription mPrices: (NSDictionary *) mPrices mHalfPortionPrice: (double) mHalfPortionPrice mTypes: (NSArray *) mTypes mRating: (EpflRating *) mRating;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) mId;
- (void) setMId: (int64_t) mId;
- (BOOL) mIdIsSet;

- (NSString *) mName;
- (void) setMName: (NSString *) mName;
- (BOOL) mNameIsSet;

- (NSString *) mDescription;
- (void) setMDescription: (NSString *) mDescription;
- (BOOL) mDescriptionIsSet;

- (NSDictionary *) mPrices;
- (void) setMPrices: (NSDictionary *) mPrices;
- (BOOL) mPricesIsSet;

- (double) mHalfPortionPrice;
- (void) setMHalfPortionPrice: (double) mHalfPortionPrice;
- (BOOL) mHalfPortionPriceIsSet;

- (NSArray *) mTypes;
- (void) setMTypes: (NSArray *) mTypes;
- (BOOL) mTypesIsSet;

- (EpflRating *) mRating;
- (void) setMRating: (EpflRating *) mRating;
- (BOOL) mRatingIsSet;

@end

@interface EpflRestaurant : NSObject <NSCoding> {
  int64_t __rId;
  NSString * __rName;
  NSArray * __rMeals;
  MapItem * __rLocation;
  EpflRating * __rRating;
  NSString * __rPictureUrl;

  BOOL __rId_isset;
  BOOL __rName_isset;
  BOOL __rMeals_isset;
  BOOL __rLocation_isset;
  BOOL __rRating_isset;
  BOOL __rPictureUrl_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=rId, setter=setRId:) int64_t rId;
@property (nonatomic, retain, getter=rName, setter=setRName:) NSString * rName;
@property (nonatomic, retain, getter=rMeals, setter=setRMeals:) NSArray * rMeals;
@property (nonatomic, retain, getter=rLocation, setter=setRLocation:) MapItem * rLocation;
@property (nonatomic, retain, getter=rRating, setter=setRRating:) EpflRating * rRating;
@property (nonatomic, retain, getter=rPictureUrl, setter=setRPictureUrl:) NSString * rPictureUrl;
#endif

- (id) initWithRId: (int64_t) rId rName: (NSString *) rName rMeals: (NSArray *) rMeals rLocation: (MapItem *) rLocation rRating: (EpflRating *) rRating rPictureUrl: (NSString *) rPictureUrl;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) rId;
- (void) setRId: (int64_t) rId;
- (BOOL) rIdIsSet;

- (NSString *) rName;
- (void) setRName: (NSString *) rName;
- (BOOL) rNameIsSet;

- (NSArray *) rMeals;
- (void) setRMeals: (NSArray *) rMeals;
- (BOOL) rMealsIsSet;

- (MapItem *) rLocation;
- (void) setRLocation: (MapItem *) rLocation;
- (BOOL) rLocationIsSet;

- (EpflRating *) rRating;
- (void) setRRating: (EpflRating *) rRating;
- (BOOL) rRatingIsSet;

- (NSString *) rPictureUrl;
- (void) setRPictureUrl: (NSString *) rPictureUrl;
- (BOOL) rPictureUrlIsSet;

@end

@interface FoodRequest : NSObject <NSCoding> {
  NSString * __deviceLanguage;
  int __mealTime;
  int64_t __mealDate;
  NSString * __deviceId;
  NSString * __userGaspar;

  BOOL __deviceLanguage_isset;
  BOOL __mealTime_isset;
  BOOL __mealDate_isset;
  BOOL __deviceId_isset;
  BOOL __userGaspar_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=deviceLanguage, setter=setDeviceLanguage:) NSString * deviceLanguage;
@property (nonatomic, getter=mealTime, setter=setMealTime:) int mealTime;
@property (nonatomic, getter=mealDate, setter=setMealDate:) int64_t mealDate;
@property (nonatomic, retain, getter=deviceId, setter=setDeviceId:) NSString * deviceId;
@property (nonatomic, retain, getter=userGaspar, setter=setUserGaspar:) NSString * userGaspar;
#endif

- (id) initWithDeviceLanguage: (NSString *) deviceLanguage mealTime: (int) mealTime mealDate: (int64_t) mealDate deviceId: (NSString *) deviceId userGaspar: (NSString *) userGaspar;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) deviceLanguage;
- (void) setDeviceLanguage: (NSString *) deviceLanguage;
- (BOOL) deviceLanguageIsSet;

- (int) mealTime;
- (void) setMealTime: (int) mealTime;
- (BOOL) mealTimeIsSet;

- (int64_t) mealDate;
- (void) setMealDate: (int64_t) mealDate;
- (BOOL) mealDateIsSet;

- (NSString *) deviceId;
- (void) setDeviceId: (NSString *) deviceId;
- (BOOL) deviceIdIsSet;

- (NSString *) userGaspar;
- (void) setUserGaspar: (NSString *) userGaspar;
- (BOOL) userGasparIsSet;

@end

@interface FoodResponse : NSObject <NSCoding> {
  NSArray * __menu;
  int __userStatus;
  NSDictionary * __mealTypePictureUrls;
  int __statusCode;

  BOOL __menu_isset;
  BOOL __userStatus_isset;
  BOOL __mealTypePictureUrls_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=menu, setter=setMenu:) NSArray * menu;
@property (nonatomic, getter=userStatus, setter=setUserStatus:) int userStatus;
@property (nonatomic, retain, getter=mealTypePictureUrls, setter=setMealTypePictureUrls:) NSDictionary * mealTypePictureUrls;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) initWithMenu: (NSArray *) menu userStatus: (int) userStatus mealTypePictureUrls: (NSDictionary *) mealTypePictureUrls statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSArray *) menu;
- (void) setMenu: (NSArray *) menu;
- (BOOL) menuIsSet;

- (int) userStatus;
- (void) setUserStatus: (int) userStatus;
- (BOOL) userStatusIsSet;

- (NSDictionary *) mealTypePictureUrls;
- (void) setMealTypePictureUrls: (NSDictionary *) mealTypePictureUrls;
- (BOOL) mealTypePictureUrlsIsSet;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

@end

@interface VoteRequest : NSObject <NSCoding> {
  int64_t __mealId;
  double __rating;
  NSString * __deviceId;

  BOOL __mealId_isset;
  BOOL __rating_isset;
  BOOL __deviceId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=mealId, setter=setMealId:) int64_t mealId;
@property (nonatomic, getter=rating, setter=setRating:) double rating;
@property (nonatomic, retain, getter=deviceId, setter=setDeviceId:) NSString * deviceId;
#endif

- (id) initWithMealId: (int64_t) mealId rating: (double) rating deviceId: (NSString *) deviceId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) mealId;
- (void) setMealId: (int64_t) mealId;
- (BOOL) mealIdIsSet;

- (double) rating;
- (void) setRating: (double) rating;
- (BOOL) ratingIsSet;

- (NSString *) deviceId;
- (void) setDeviceId: (NSString *) deviceId;
- (BOOL) deviceIdIsSet;

@end

@interface VoteResponse : NSObject <NSCoding> {
  int __submitStatus;

  BOOL __submitStatus_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=submitStatus, setter=setSubmitStatus:) int submitStatus;
#endif

- (id) initWithSubmitStatus: (int) submitStatus;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int) submitStatus;
- (void) setSubmitStatus: (int) submitStatus;
- (BOOL) submitStatusIsSet;

@end

@protocol FoodService <NSObject>
- (NSArray *) getMeals;  // throws TException
- (NSDictionary *) getRatings;  // throws TException
- (int) setRating: (int64_t) mealId : (double) rating : (NSString *) deviceId;  // throws TException
- (FoodResponse *) getFood: (FoodRequest *) foodReq;  // throws TException
- (VoteResponse *) vote: (VoteRequest *) voteReq;  // throws TException
@end

@interface FoodServiceClient : NSObject <FoodService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface FoodServiceProcessor : NSObject <TProcessor> {
  id <FoodService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithFoodService: (id <FoodService>) service;
- (id<FoodService>) service;
@end

@interface foodConstants : NSObject {
}
@end
