//
//  PCValues.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 10.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PCValues : NSObject

/*
 * Call at application launch to set default apparence for all upcoming instances of elements
 * modified in the method.
 */
+ (void)applyAppearenceProxy;

+ (UIImage*)imageForFavoriteNavBarButtonLandscapePhone:(BOOL)landscapePhone glow:(BOOL)glow;

+ (UIColor*)pocketCampusRed;
+ (UIColor*)backgroundColor1;
+ (UIColor*)textColor1;
+ (UIColor*)textColorLocationBlue;
+ (CGSize)shadowOffset1;
+ (UIColor*)shadowColor1;
+ (CGFloat)totalSubviewsHeight:(UIView*)view;


+ (CGFloat)tableViewSectionHeaderHeight __attribute__((deprecated));

@end
