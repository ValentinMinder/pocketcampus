//
//  MyEduController.m
//  PocketCampus
//
//  ARC enabled
//

#import "MyEduController.h"

#import "MyEduCourseListViewController.h"

#import "MyEduService.h"

#import "ObjectArchiver.h"

static BOOL initObserversDone = NO;
static NSString* kDeleteSessionAtInitKey = @"DeleteSessionAtInit";

@implementation MyEduController

- (id)initWithMainController:(MainController2 *)mainController_
{
    self = [super init];
    if (self) {
        mainController = mainController_;
        MyEduCourseListViewController* courseListViewController = [[MyEduCourseListViewController alloc] init];
        courseListViewController.title = NSLocalizedStringFromTable(@"MyCourses", @"MyEduPlugin", nil);
        
        UINavigationController* masterNavigationController = [[UINavigationController alloc] initWithRootViewController:courseListViewController];
        UIViewController* detailViewController = [[UIViewController alloc] init]; //detail view controller will be set by PluginSplitViewController that will ask to master view controller
        
        PluginSplitViewController* splitViewController = [[PluginSplitViewController alloc] initWithMasterViewController:masterNavigationController detailViewController:detailViewController];
        splitViewController.delegate = self;
        
        mainSplitViewController = splitViewController;
        mainSplitViewController.pluginIdentifier = [[self class] identifierName];
    }
    return self;
}

+ (void)initObservers {
    @synchronized(self) {
        if (initObserversDone) {
            return;
        }
        [[NSNotificationCenter defaultCenter] addObserverForName:[AuthenticationService logoutNotificationName] object:nil queue:[NSOperationQueue mainQueue] usingBlock:^(NSNotification *notification) {
            NSNumber* delayed = [notification.userInfo objectForKey:[AuthenticationService delayedUserInfoKey]];
            if ([delayed boolValue]) {
                NSLog(@"-> MyEdu received %@ notification delayed", [AuthenticationService logoutNotificationName]);
                [ObjectArchiver saveObject:[NSNumber numberWithBool:YES] forKey:kDeleteSessionAtInitKey andPluginName:@"myedu"];
            } else {
                NSLog(@"-> MyEdu received %@ notification", [AuthenticationService logoutNotificationName]);
                [[MyEduService sharedInstanceToRetain] deleteSession];
            }
        }];
        initObserversDone = YES;
    }
}

- (void)refresh {
    //TODO: refresh infos displayed by plugin if necessary
}

+ (NSString*)localizedName {
    return NSLocalizedStringFromTable(@"PluginName", @"MyEduPlugin", @"");
}

+ (NSString*)identifierName {
    return @"MyEdu";
}

- (void)pluginDidBecomePassive {
    //TODO
}

- (void)pluginWillLoseFocus {
    //TODO
}
- (void)pluginDidRegainActive {
    if ([self.mainSplitViewController.viewControllers[0] respondsToSelector:@selector(refresh)]) {
        [self.mainSplitViewController.viewControllers[0] refresh];
    }
}

#pragma mark UISplitViewControllerDelegate

- (BOOL)splitViewController:(UISplitViewController *)svc shouldHideViewController:(UIViewController *)vc inOrientation:(UIInterfaceOrientation)orientation {
    /*if (orientation == UIInterfaceOrientationMaskPortrait) {
        return YES;
    }*/
    return NO;
}

@end
