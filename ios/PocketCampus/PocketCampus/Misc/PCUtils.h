//
//  PCUtils.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 04.07.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PCUtils : NSObject

+ (BOOL)isRetinaDevice;
+ (BOOL)is4inchDevice;
+ (BOOL)isIdiomPad;
+ (BOOL)isOSVersionSmallerThan:(float)version;
+ (float)OSVersion;
+ (NSString*)uniqueDeviceIdentifier;
+ (NSString*)appVersion;
+ (NSString*)userLanguageCode;
+ (NSString*)lastUpdateNowString;
+ (UIEdgeInsets)edgeInsetsForViewController:(UIViewController*)viewController;
+ (void)reloadTableView:(UITableView*)tableView withFadingDuration:(NSTimeInterval)duration;
+ (void)printFrame:(CGRect)frame;
+ (NSString*)stringFromFileSize:(unsigned long long)size;
+ (BOOL)double:(double)d1 isEqualToDouble:(double)d2 epsilon:(double)epsilon;

+ (UILabel*)addCenteredLabelInView:(UIView*)view withMessage:(NSString*)message;
+ (void)removeCenteredLabelInView:(UIView*)view;

+ (void)showServerErrorAlert;
+ (void)showConnectionToServerTimedOutAlert;

+ (NSDictionary*)urlStringParameters:(NSString*)urlString;

/*
 * Returns [[Reachability reachabilityForInternetConnection] isReachable], i.e. whether internet is reachable
 */
+ (BOOL)hasDeviceInternetConnection;
+ (BOOL)hasAppAccessToLocation;

+ (void)throwExceptionIfObject:(id)object notKindOfClass:(Class)class;




@end
