//
//  CamiproViewController.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 17.05.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "CamiproService.h"

#import "AuthenticationController.h"

#import "authentication.h"

@interface CamiproViewController : UIViewController<UITableViewDataSource, UITableViewDelegate, AuthenticationCallbackDelegate, CamiproServiceDelegate> {
    UITableView* tableView;
    UIActivityIndicatorView* centerActivityIndicator;
    UILabel* centerMessageLabel;
    UIToolbar* toolbar;
    AuthenticationController* authController;
    CamiproService* camiproService;
    BalanceAndTransactions* balanceAndTransactions;
}

@property (nonatomic, assign) IBOutlet UITableView* tableView;
@property (nonatomic, assign) IBOutlet UIActivityIndicatorView* centerActivityIndicator;
@property (nonatomic, assign) IBOutlet UILabel* centerMessageLabel;
@property (nonatomic, assign) IBOutlet UIToolbar* toolbar;
@end
