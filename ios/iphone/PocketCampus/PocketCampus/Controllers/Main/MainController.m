//
//  MainController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 02.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "MainController.h"
#import "PCValues.h"
#import "HomeViewController.h"
#import "PluginController.h"

#import <objc/message.h>

@implementation MainController

@synthesize pluginsList, activePluginController;

- (id)initWithWindow:(UIWindow *)window_
{
    self = [super init];
    if (self) {
        window = window_;
        homeViewController = nil;
        activePluginController = nil;
        [self initPluginsList];
        [self initPluginObservers];
        [self initNavigationControllerAndPushHome];
    }
    return self;
}

- (void)initPluginsList {
    NSDictionary* plist = [NSDictionary dictionaryWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"Plugins" ofType:@"plist"]];
    NSArray* pluginsFromPlist = [plist objectForKey:@"Plugins"];
    NSMutableArray* pluginsTempArray = [NSMutableArray arrayWithCapacity:pluginsFromPlist.count];
    for (NSDictionary* pluginDic in pluginsFromPlist) {
        NSString* identifierName = [pluginDic objectForKey:@"identifierName"];
        if ([[pluginDic objectForKey:@"enabled"] boolValue]) {
            NSLog(@"-> Detected enabled plugin : %@", identifierName);
            [pluginsTempArray addObject:identifierName];
        }
    }
    
    /* sorting plugins alphabetically on plugin name. Should be on localized name, but cannot access it here */
    /*[pluginsTempArray sortWithOptions:0 usingComparator:^NSComparisonResult(id obj1, id obj2) {
        NSString* name1 = (NSString*)obj1;
        NSString* name2 = (NSString*)obj2;
        return [name1 compare:name2];
    }];*/
    
    pluginsList = [[NSArray arrayWithArray:pluginsTempArray] retain]; //creates a non-mutable copy of the dictionary
    
}

- (void)initPluginObservers {
    for (int i = 0; i<pluginsList.count; i++) {
        Class pluginClass = NSClassFromString([self pluginControllerNameForIndex:i]);
        if (class_getClassMethod(pluginClass, @selector(initObservers))) {
            NSLog(@"-> Found PluginController with observers : %@", pluginClass);
            [pluginClass initObservers];
        }
    }
}

- (NSString*)pluginControllerNameForIdentifier:(NSString*)identifier {
    return [NSString stringWithFormat:@"%@Controller", identifier];
}

- (NSString*)pluginControllerNameForIndex:(NSUInteger)index {
    return [self pluginControllerNameForIdentifier:[pluginsList objectAtIndex:index]];
}

- (void)initNavigationControllerAndPushHome {
    UIViewController* splashController = [[UIViewController alloc] initWithNibName:@"SplashView" bundle:nil];
    homeViewController = [[HomeViewController alloc] initWithMainController:self];
    navController = [[UINavigationController alloc] initWithRootViewController:homeViewController];
    navController.delegate = self;
    navController.navigationBar.tintColor = [PCValues pocketCampusRed];
    [window addSubview:navController.view];
    [window addSubview:splashController.view];
    
    /* Splashscreen animation */
    [UIView animateWithDuration:0.4 animations:^{
        splashController.view.alpha = 0.0;
        splashController.view.frame = CGRectMake(-20.0, -20.0, 360.0, 520.0);;
    } completion:^(BOOL finished) {
        [splashController.view removeFromSuperview];
        [splashController autorelease];
    }];
}

- (void)refreshDisplayedPlugin {
    if ([activePluginController respondsToSelector:@selector(refresh)]) {
        [activePluginController performSelector:@selector(refresh)];
    }
}

/* UINavigationControllerDelegate delegation */

- (void)navigationController:(UINavigationController *)navigationController didShowViewController:(UIViewController *)viewController animated:(BOOL)animated {
    if (viewController == homeViewController) {
        [activePluginController release];
        activePluginController = nil;
    }
}

- (void)dealloc
{
    [homeViewController release];
    [navController release];
    [pluginsList release];
    [super dealloc];
}

@end
