//
//  ShareFavoriteItemsViewController.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 18.05.13.
//  Copyright (c) 2013 EPFL. All rights reserved.
//

#import <UIKit/UIKit.h>

#import "EventsService.h"

@interface EventsShareFavoriteItemsViewController : UITableViewController<EventsServiceDelegate>

- (id)initWithRelatedEventPool:(EventPool*)eventPool;

@property (nonatomic, strong) EventPool* relatedEventPool;

@property (nonatomic, strong) NSString* prefilledEmail;

@end
