//
//  RestaurantsListViewController.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 08.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "FoodService.h"

#import "food.h"

#import "MenusListViewController.h"

@interface RestaurantsListViewController : UIViewController<UITableViewDelegate, FoodServiceDelegate> {
    IBOutlet UITableView* tableView;
    IBOutlet UIActivityIndicatorView* centerActivityIndicator;
    IBOutlet UILabel* centerMessageLabel;
    FoodService* foodService;
    NSArray* meals; //Array of Meal as returned by FoodService
    NSArray* restaurants; //Array of Restaurant for which menus are available
    NSDictionary* restaurantsAndMeals; //key : restaurant name, value : NSArray of corresponding meals
}

@end
