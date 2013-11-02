//
//  CourseSectionsViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 04.12.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "MoodleCourseSectionsViewController.h"

#import "MoodleController.h"

#import "PCUtils.h"

#import "PCValues.h"

#import "PCTableViewSectionHeader.h"

#import "MoodleResourceViewController.h"

#import "MoodleSplashDetailViewController.h"

#import "PCTableViewCellAdditions.h"

#import "PCCenterMessageCell.h"

#import "PluginSplitViewController.h"



static const NSTimeInterval kRefreshValiditySeconds = 604800.0; //1 week

@interface MoodleCourseSectionsViewController ()

@property (nonatomic, strong) MoodleService* moodleService;
@property (nonatomic, strong) NSArray* sections;
@property (nonatomic, strong) NSDictionary* cellForMoodleResource;
@property (nonatomic) int currentWeek;
@property (nonatomic, strong) MoodleCourse* course;
@property (nonatomic, strong) LGRefreshControl* lgRefreshControl;
@property (nonatomic, strong) MoodleResource* selectedResource;

@end

@implementation MoodleCourseSectionsViewController

- (id)initWithCourse:(MoodleCourse*)course;
{
    self = [super initWithStyle:UITableViewStylePlain];
    if (self) {
        self.course = course;
        self.title = self.course.iTitle;
        self.moodleService = [MoodleService sharedInstanceToRetain];
        self.sections = [self.moodleService getFromCacheSectionsListReplyForCourse:self.course].iSections;
        [self fillCellsFromSections];
        
        //[self.moodleService saveSession:[[MoodleSession alloc] initWithMoodleCookie:@"sdfgjskjdfhgjshdfg"]]; //TEST ONLY
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.lgRefreshControl = [[LGRefreshControl alloc] initWithTableViewController:self refreshedDataIdentifier:[LGRefreshControl dataIdentifierForPluginName:@"moodle" dataName:[NSString stringWithFormat:@"courseSectionsList-%d", self.course.iId]]];
    [self.lgRefreshControl setTarget:self selector:@selector(refresh)];
    self.tableView.rowHeight = 65.0;
    self.tableView.allowsMultipleSelection = NO;
    [self showToggleButtonIfPossible];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [[PCGAITracker sharedTracker] trackScreenWithName:@"/moodle/course"];
    if (!self.sections || [self.lgRefreshControl shouldRefreshDataForValidity:kRefreshValiditySeconds]) {
        [self refresh];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSUInteger)supportedInterfaceOrientations //iOS 6
{
    return UIInterfaceOrientationMaskAllButUpsideDown;
    
}

#pragma mark - refresh control

- (void)refresh {
    [self.moodleService cancelOperationsForDelegate:self]; //cancel before retrying
    [self.lgRefreshControl startRefreshingWithMessage:NSLocalizedStringFromTable(@"LoadingCourse", @"MoodlePlugin", nil)];
    [self startGetCourseSectionsRequest];
}

- (void)startGetCourseSectionsRequest {
    VoidBlock successBlock = ^{
        [self.moodleService getCourseSections:[self.moodleService createMoodleRequestWithCourseId:self.course.iId] withDelegate:self];
    };
    if ([self.moodleService lastSession]) {
        successBlock();
    } else {
        NSLog(@"-> No saved session, loggin in...");
        [[MoodleController sharedInstanceToRetain] addLoginObserver:self successBlock:successBlock userCancelledBlock:^{
            [self.lgRefreshControl endRefreshing];
        } failureBlock:^{
            [self error];
        }];
    }
}


#pragma mark - Utils and toggle week button

- (void)computeCurrentWeek {
    if(self.sections == nil)
        return;
    self.currentWeek = -1; //-1 means outside semester time, all weeks will be displayed and toggle button hidden
    for (NSInteger i = 0; i < self.sections.count; i++) {
        MoodleSection* iSection = [self.sections objectAtIndex:i];
        if(iSection.iResources.count != 0 && iSection.iCurrent) {
            self.currentWeek = i;
            break;
        }
    }
}

- (void)showToggleButtonIfPossible {
    int visibleCount = 0;
    for (int i = 1; i < self.sections.count; i++) {
        MoodleSection* secObj = [self.sections objectAtIndex:i];
        visibleCount += secObj.iResources.count;
    }
    if(visibleCount > 0) {
        [self computeCurrentWeek];
        [self showToggleButton];
    }
}

- (void)showToggleButton {
    UIBarButtonItem *anotherButton = nil;
    if (self.currentWeek > 0) {
        anotherButton = [[UIBarButtonItem alloc] initWithTitle:NSLocalizedStringFromTable(@"MoodleAllWeeks", @"MoodlePlugin", nil) style:UIBarButtonItemStyleBordered target:self action:@selector(toggleShowAll:)];
    } else if (self.currentWeek == 0) {
        anotherButton = [[UIBarButtonItem alloc] initWithTitle:NSLocalizedStringFromTable(@"MoodleCurrentWeek", @"MoodlePlugin", nil) style:UIBarButtonItemStyleBordered target:self action:@selector(toggleShowAll:)];
    }
    [self.navigationItem setRightBarButtonItem:anotherButton animated:NO];
}

- (void)toggleShowAll:(id)sender {
    if (self.currentWeek > 0) {
        self.currentWeek = 0;
    } else {
        [self computeCurrentWeek];
    }
    [self showToggleButton];
    NSIndexPath* selectedIndexPath = nil;
    if (self.selectedResource && self.cellForMoodleResource[self.selectedResource]) { //second condition should always be true if first is true
        selectedIndexPath = [self.tableView indexPathForCell:self.cellForMoodleResource[self.selectedResource]];;
    }
    [self.tableView reloadData];
    if (selectedIndexPath) {
        [self.tableView scrollToRowAtIndexPath:selectedIndexPath atScrollPosition:UITableViewScrollPositionMiddle animated:NO];
    }
}

- (void)showMasterViewController {
    [(PluginSplitViewController*)self.splitViewController setMasterViewControllerHidden:NO animated:YES];
}

- (void)fillCellsFromSections {
    if (!self.sections) {
        return;
    }
    
    NSMutableDictionary* cellsTemp = [NSMutableDictionary dictionaryWithCapacity:self.sections.count*5]; //just estimation for pre-memory allocation
    
    for (MoodleSection* section in self.sections) {
        for (MoodleResource* resource in section.iResources) {
            
            
            PCTableViewCellAdditions* newCell = [[PCTableViewCellAdditions alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:nil];
            newCell.textLabel.font = [UIFont preferredFontForTextStyle:UIFontTextStyleBody];
            newCell.textLabel.adjustsFontSizeToFitWidth = YES;
            newCell.textLabel.text = resource.iName;
            
            newCell.accessoryType = [PCUtils isIdiomPad] ? UITableViewCellAccessoryNone : UITableViewCellAccessoryDisclosureIndicator;
            
            NSArray* pathComponents = [resource.iUrl pathComponents];
            newCell.detailTextLabel.text = [pathComponents objectAtIndex:pathComponents.count-1];
            newCell.detailTextLabel.adjustsFontSizeToFitWidth = YES;
            if ([self.moodleService isMoodleResourceDownloaded:resource]) {
                newCell.downloadedIndicationVisible = YES;
            }
            
            if ([self.selectedResource isEqual:resource]) {
                newCell.durablySelected = YES;
            }
            
            MoodleCourseSectionsViewController* controller __weak = self;
            PCTableViewCellAdditions* cellWeak __weak = newCell;
            
            [self.moodleService removeMoodleResourceObserver:self forResource:resource];
            [self.moodleService addMoodleResourceObserver:self forResource:resource eventBlock:^(MoodleResourceEvent event) {
                if (event == MoodleResourceEventDeleted) {
                    cellWeak.durablySelected = NO;
                    cellWeak.downloadedIndicationVisible  = NO;
                    if (controller.splitViewController && [controller.selectedResource isEqual:resource]) { //iPad //resource deleted => hide ResourceViewController
                        [controller.tableView deselectRowAtIndexPath:[controller.tableView indexPathForSelectedRow] animated:YES];
                        controller.selectedResource = nil;
                        MoodleSplashDetailViewController* splashViewController = [[MoodleSplashDetailViewController alloc] init];
                        controller.splitViewController.viewControllers = @[controller.splitViewController.viewControllers[0], [[PCNavigationController alloc] initWithRootViewController:splashViewController]];
                        [NSTimer scheduledTimerWithTimeInterval:0.2 target:controller selector:@selector(showMasterViewController) userInfo:nil repeats:NO];
                    }
                } else if (event == MoodleResourceEventDownloaded) {
                    cellWeak.downloadedIndicationVisible = YES;
                } else {
                    //not supported
                }
                [newCell setNeedsLayout];
            }];

            cellsTemp[(id<NSCopying>)resource] = newCell; //NSCopying is implemented in Comparison category
            
        }
    }
    
    self.cellForMoodleResource = [cellsTemp copy]; //immutable copy

}

#pragma MoodleServiceDelegate

- (void)getCourseSections:(MoodleRequest *)aMoodleRequest didReturn:(SectionsListReply *)sectionsListReply {
    switch (sectionsListReply.iStatus) {
        case 200:
            self.sections = sectionsListReply.iSections;
            [self.moodleService saveToCacheSectionsListReply:sectionsListReply forCourse:self.course];
            [self showToggleButtonIfPossible];
            [self fillCellsFromSections];
            [self.tableView reloadData];
            [self.lgRefreshControl endRefreshing];
            [self.lgRefreshControl markRefreshSuccessful];
            break;
        case 407:
            [self.moodleService deleteSession];
            [self startGetCourseSectionsRequest];
            break;
        case 405:
            [self error];
            break;
        case 404:
        {
            [self.lgRefreshControl endRefreshing];
            UIAlertView* alert = [[UIAlertView alloc] initWithTitle:NSLocalizedStringFromTable(@"Error", @"PocketCampus", nil) message:NSLocalizedStringFromTable(@"MoodleDown", @"MoodlePlugin", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
            [alert show];
        }
        default:
            [self getCourseSectionsFailed:aMoodleRequest];
            break;
    }
}

- (void)getCourseSectionsFailed:(MoodleRequest *)aMoodleRequest {
    [self error];
}


- (void)error {
    [PCUtils showServerErrorAlert];
    [self.lgRefreshControl endRefreshingWithDelay:2.0 indicateErrorWithMessage:NSLocalizedStringFromTable(@"ServerErrorShort", @"PocketCampus", nil)];
}

- (void)serviceConnectionToServerTimedOut {
    [PCUtils showConnectionToServerTimedOutAlert];
    [self.lgRefreshControl endRefreshingWithDelay:2.0 indicateErrorWithMessage:NSLocalizedStringFromTable(@"ConnectionToServerTimedOutShort", @"PocketCampus", nil)];
}

#pragma mark - UITableViewDelegate


- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (!self.sections.count) {
        return;
    }
    MoodleSection* section = [self.sections objectAtIndex:indexPath.section];
    MoodleResource* resource = [section.iResources objectAtIndex:indexPath.row];
    if (self.splitViewController && [resource isEqual:self.selectedResource]) {
        return;
    }
    MoodleResourceViewController* detailViewController = [[MoodleResourceViewController alloc] initWithMoodleResource:resource];

    if (self.splitViewController) { /* iPad */
        
        PCTableViewCellAdditions* prevCell = self.cellForMoodleResource[self.selectedResource];
        prevCell.durablySelected = NO;
        self.selectedResource = resource;
        
        PCTableViewCellAdditions* newCell = self.cellForMoodleResource[resource];
        newCell.durablySelected = YES;
        
        //[self.tableView deselectRowAtIndexPath:indexPath animated:YES];
        
        PCNavigationController* detailNavController = [[PCNavigationController alloc] initWithRootViewController:detailViewController]; //to have nav bar
        self.splitViewController.viewControllers = @[self.splitViewController.viewControllers[0], detailNavController];
    } else { /* iPhone */
        [self.navigationController pushViewController:detailViewController animated:YES];
    }
}

- (UITableViewCellEditingStyle)tableView:(UITableView *)tableView_ editingStyleForRowAtIndexPath:(NSIndexPath *)indexPath {
    PCTableViewCellAdditions* cell = (PCTableViewCellAdditions*)[self.tableView cellForRowAtIndexPath:indexPath];
    if (cell.isDownloadedIndicationVisible) {
        return UITableViewCellEditingStyleDelete;
    }
    return UITableViewCellEditingStyleNone;
}

- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section {
    if (self.sections == nil || self.sections.count == 0) {
        return 0.0;
    }
    if (![self showSection:section]) {
        return 0.0;
    }
    MoodleSection* secObj = [self.sections objectAtIndex:section];
    if (secObj.iResources.count == 0) {
        return 0.0;
    }
    return [PCTableViewSectionHeader preferredHeight];
}

- (UIView *)tableView:(UITableView *)tableView viewForHeaderInSection:(NSInteger)section
{
    if (self.sections == nil || self.sections.count == 0 || ![self showSection:section]) {
        return nil;
    }
    
    MoodleSection* secObj = [self.sections objectAtIndex:section];
    if (secObj.iResources.count == 0) {
        return nil;
    }
    
    /*NSDateFormatter* dateFormatter = [[NSDateFormatter alloc] init];
     [dateFormatter setTimeZone:[NSTimeZone systemTimeZone]];
     [dateFormatter setLocale:[NSLocale systemLocale]];
     [dateFormatter setDateFormat:@"dd/MM"];
     //NSLog(@"%lld", secObj.iStartDate);
     NSString* startDate = [dateFormatter stringFromDate:[NSDate dateWithTimeIntervalSince1970:secObj.iStartDate]];*/
    
    /* startDate and endDate are not filled by server yet */
    
    NSString* title = [NSString stringWithFormat:@"%@ %d", NSLocalizedStringFromTable(@"MoodleWeek", @"MoodlePlugin", nil), section];
    
    return [[PCTableViewSectionHeader alloc] initWithSectionTitle:title tableView:tableView];
}


#pragma mark - UITableViewDataSource

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        MoodleSection* section = [self.sections objectAtIndex:indexPath.section];
        MoodleResource* resource = [section.iResources objectAtIndex:indexPath.row];
        if ([self.moodleService deleteDownloadedMoodleResource:resource]) {
            [self.tableView setEditing:NO animated:YES];
        } else {
            [[[UIAlertView alloc] initWithTitle:NSLocalizedStringFromTable(@"Error", @"PocketCampus", nil) message:NSLocalizedStringFromTable(@"ImpossibleDeleteFile", @"MoodlePlugin", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil] show];
            return;
        }
    }
}

- (UITableViewCell *)tableView:(UITableView *)tableView_ cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (self.sections && [self.sections count] == 0) {
        if (indexPath.row == 1) {
            return [[PCCenterMessageCell alloc] initWithMessage:NSLocalizedStringFromTable(@"MoodleEmptyCourse", @"MoodlePlugin", nil)];
        } else {
            UITableViewCell* cell =[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:nil];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
            return cell;
        }
    }
    
    MoodleSection* section = self.sections[indexPath.section];
    MoodleResource* resource = section.iResources[indexPath.row];
    PCTableViewCellAdditions* cell = self.cellForMoodleResource[resource];
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    if (!self.sections) {
        return 0;
    }
    if (self.sections && self.sections.count == 0) {
        return 2; //first empty cell, second cell says no content
    }
    if(![self showSection:section]) {
        return 0;
    }
    MoodleSection* secObj = self.sections[section];
    return secObj.iResources.count;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    if (!self.sections) {
        return 0;
    }
    if (self.sections && self.sections.count == 0) {
        return 1; //empty course message
    }
    return self.sections.count;
}

#pragma mark - showSections

- (BOOL)showSection:(NSInteger) section {
    if (section == 0) {
        return NO;
    }
    if (self.currentWeek <= 0) {
        return YES;
    }
    return (self.currentWeek == section);
}

#pragma mark - dealloc

- (void)dealloc
{
    [self.moodleService removeMoodleResourceObserver:self];
    [self.moodleService cancelOperationsForDelegate:self];
}

@end
