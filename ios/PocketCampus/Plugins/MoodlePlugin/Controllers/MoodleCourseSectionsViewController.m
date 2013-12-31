//
//  CourseSectionsViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 04.12.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "MoodleCourseSectionsViewController.h"

#import "MoodleController.h"

#import "PCTableViewSectionHeader.h"

#import "MoodleResourceViewController.h"

#import "MoodleSplashDetailViewController.h"

#import "PCTableViewCellAdditions.h"

#import "PCCenterMessageCell.h"

#import "PluginSplitViewController.h"

#import "MoodleModelAdditions.h"


static const NSTimeInterval kRefreshValiditySeconds = 604800.0; //1 week

static const CGFloat kCellsHeight = 65.0;

static const UISearchBarStyle kSearchBarDefaultStyle = UISearchBarStyleDefault;
static const UISearchBarStyle kSearchBarActiveStyle = UISearchBarStyleMinimal;

@interface MoodleCourseSectionsViewController ()<UISearchDisplayDelegate>

@property (nonatomic, strong) LGRefreshControl* lgRefreshControl;
@property (nonatomic, strong) UISearchBar* searchBar;
@property (nonatomic, strong) UISearchDisplayController* searchController;
@property (nonatomic, strong) NSOperationQueue* searchQueue;
@property (nonatomic, strong) NSTimer* typingTimer;

@property (nonatomic, strong) MoodleService* moodleService;
@property (nonatomic, strong) NSArray* sections;
@property (nonatomic, strong) NSArray* filteredSections; //for search
@property (nonatomic, strong) NSDictionary* cellForMoodleResource;
@property (nonatomic) int currentWeek;
@property (nonatomic, strong) MoodleCourse* course;
@property (nonatomic, strong) MoodleResource* selectedResource;

@end

@implementation MoodleCourseSectionsViewController

#pragma mark - Init

- (id)initWithCourse:(MoodleCourse*)course;
{
    self = [super initWithStyle:UITableViewStylePlain];
    if (self) {
        self.course = course;
        self.title = self.course.iTitle;
        self.moodleService = [MoodleService sharedInstanceToRetain];
        self.sections = [self.moodleService getFromCacheSectionsListReplyForCourse:self.course].iSections;
        self.searchQueue = [NSOperationQueue new];
        self.searchQueue.maxConcurrentOperationCount = 1;
        [self fillCellsFromSections];
        //[self.moodleService saveSession:[[MoodleSession alloc] initWithMoodleCookie:@"sdfgjskjdfhgjshdfg"]]; //TEST ONLY
    }
    return self;
}

#pragma mark - UIViewController overrides

- (void)viewDidLoad {
    [super viewDidLoad];
    self.lgRefreshControl = [[LGRefreshControl alloc] initWithTableViewController:self refreshedDataIdentifier:[LGRefreshControl dataIdentifierForPluginName:@"moodle" dataName:[NSString stringWithFormat:@"courseSectionsList-%d", self.course.iId]]];
    [self.lgRefreshControl setTarget:self selector:@selector(refresh)];
    
    self.tableView.rowHeight = kCellsHeight;
    self.tableView.allowsMultipleSelection = NO;
    
    self.searchBar = [[UISearchBar alloc] initWithFrame:CGRectMake(0, 0, self.tableView.frame.size.width, 0.0)];
    [self.searchBar sizeToFit];
    //self.searchBar.delegate = self;
    self.searchBar.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    self.searchBar.placeholder = NSLocalizedStringFromTable(@"SearchNoun", @"PocketCampus", nil);
    self.searchBar.searchBarStyle = kSearchBarDefaultStyle;
    
    self.tableView.tableHeaderView = self.searchBar;
    
    self.searchController = [[UISearchDisplayController alloc] initWithSearchBar:self.searchBar contentsController:self];
    self.searchController.searchResultsDelegate = self;
    self.searchController.searchResultsDataSource = self;
    self.searchController.delegate = self;
    self.searchController.searchResultsTableView.rowHeight = kCellsHeight;
    self.searchController.searchResultsTableView.allowsMultipleSelection = NO;
    self.searchController.searchResultsTitle = @"Test";
    
    [self showToggleButtonIfPossible];
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(favoriteMoodleResourcesUpdated:) name:kFavoritesMoodleResourcesUpdatedNotificationName object:self.moodleService];
}

- (void)viewWillAppear:(BOOL)animated {
    [super viewWillAppear:animated];
    [[PCGAITracker sharedTracker] trackScreenWithName:@"/moodle/course"];
    if (!self.sections || [self.lgRefreshControl shouldRefreshDataForValidity:kRefreshValiditySeconds]) {
        [self refresh];
    }
}

- (NSUInteger)supportedInterfaceOrientations //iOS 6
{
    return UIInterfaceOrientationMaskAllButUpsideDown;
    
}

#pragma mark - Notifications listening

- (void)favoriteMoodleResourcesUpdated:(NSNotification*)notif {
    MoodleResource* resource = notif.userInfo[kFavoriteStatusMoodleResourceUpdatedKey];
    if (!resource) {
        return;
    }
    PCTableViewCellAdditions* cell = self.cellForMoodleResource[resource];
    cell.favoriteIndicationVisible = [self.moodleService isFavoriteMoodleResource:resource];
}

#pragma mark - Refresh

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
    if(!self.sections) {
        return;
    }
    self.currentWeek = -1; //-1 means outside semester time, all weeks will be displayed and toggle button hidden
    for (NSInteger i = 0; i < self.sections.count; i++) {
        MoodleSection* iSection = self.sections[i];
        if(iSection.iResources.count != 0 && iSection.iCurrent) {
            self.currentWeek = i;
            break;
        }
    }
}

- (void)showToggleButtonIfPossible {
    int visibleCount = 0;
    for (int i = 1; i < self.sections.count; i++) {
        MoodleSection* secObj = self.sections[i];
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
            
            
            PCTableViewCellAdditions* cell = [[PCTableViewCellAdditions alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:nil];
            cell.textLabel.font = [UIFont preferredFontForTextStyle:UIFontTextStyleBody];
            cell.textLabel.adjustsFontSizeToFitWidth = YES;
            cell.textLabel.text = resource.iName;
            
            cell.accessoryType = [PCUtils isIdiomPad] ? UITableViewCellAccessoryNone : UITableViewCellAccessoryDisclosureIndicator;
            
            cell.detailTextLabel.text = resource.filename;
            cell.detailTextLabel.adjustsFontSizeToFitWidth = YES;
            
            cell.downloadedIndicationVisible = [self.moodleService isMoodleResourceDownloaded:resource];
            cell.favoriteIndicationVisible = [self.moodleService isFavoriteMoodleResource:resource];
            cell.durablySelected = [self.selectedResource isEqualToMoodleResource:resource];
            
            MoodleCourseSectionsViewController* weakSelf __weak = self;
            PCTableViewCellAdditions* cellWeak __weak = cell;
            
            [self.moodleService removeMoodleResourceObserver:self forResource:resource];
            [self.moodleService addMoodleResourceObserver:self forResource:resource eventBlock:^(MoodleResourceEvent event) {
                if (event == MoodleResourceEventDeleted) {
                    cellWeak.durablySelected = NO;
                    cellWeak.downloadedIndicationVisible  = NO;
                    if (weakSelf.splitViewController && [weakSelf.selectedResource isEqual:resource]) { //iPad //resource deleted => hide ResourceViewController
                        [weakSelf.tableView deselectRowAtIndexPath:[weakSelf.tableView indexPathForSelectedRow] animated:YES];
                        [weakSelf.searchController.searchResultsTableView deselectRowAtIndexPath:[weakSelf.searchController.searchResultsTableView indexPathForSelectedRow] animated:YES];
                        weakSelf.selectedResource = nil;
                        MoodleSplashDetailViewController* splashViewController = [[MoodleSplashDetailViewController alloc] init];
                        weakSelf.splitViewController.viewControllers = @[weakSelf.splitViewController.viewControllers[0], [[PCNavigationController alloc] initWithRootViewController:splashViewController]];
                        [NSTimer scheduledTimerWithTimeInterval:0.2 target:weakSelf selector:@selector(showMasterViewController) userInfo:nil repeats:NO];
                    }
                } else if (event == MoodleResourceEventDownloaded) {
                    cellWeak.downloadedIndicationVisible = YES;
                } else {
                    //not supported
                }
                [cell setNeedsLayout];
            }];

            cellsTemp[(id<NSCopying>)resource] = cell; //NSCopying is implemented in Comparison category
            
        }
    }
    
    self.cellForMoodleResource = [cellsTemp copy]; //immutable copy

}

- (NSArray*)filteredSectionsFromPattern:(NSString*)pattern {
    NSPredicate* predicate = [NSPredicate predicateWithFormat:@"SELF.iName contains[cd] %@ OR SELF.filename contains[cd] %@", pattern, pattern];
    NSMutableArray* filteredSections = [NSMutableArray arrayWithCapacity:self.sections.count];
    for (MoodleSection* moodleSection in self.sections) {
        MoodleSection* moodleSectionCopy = [moodleSection copy]; //conforms to NSCopying in Additions category
        moodleSectionCopy.iResources = [moodleSection.iResources filteredArrayUsingPredicate:predicate];
        [filteredSections addObject:moodleSectionCopy];
    }
    return filteredSections;
}

- (void)search {
    [self.searchQueue addOperationWithBlock:^{
        NSArray* filteredSections = [self filteredSectionsFromPattern:self.searchBar.text];
        [[NSOperationQueue mainQueue] addOperationWithBlock:^{
            self.filteredSections = filteredSections;
            [self.searchController.searchResultsTableView reloadData];
        }];
    }];
}

#pragma mark - UISearchBarDisplayDelegate

- (BOOL)searchDisplayController:(UISearchDisplayController *)controller shouldReloadTableForSearchString:(NSString *)searchString {
    [self.typingTimer invalidate];
    [self.searchQueue cancelAllOperations];
    if (searchString.length == 0) {
        self.filteredSections = nil;
        return YES;
    } else {
        //perform search in background
        typeof(self) weakSelf __weak = self;
        self.typingTimer = [NSTimer scheduledTimerWithTimeInterval:self.filteredSections.count ? 0.2 : 0.0 block:^{ //interval: so that first search is not delayed (would display "No results" otherwise)
            [self.searchQueue addOperationWithBlock:^{
                NSArray* filteredSections = [self filteredSectionsFromPattern:searchString];
                [[NSOperationQueue mainQueue] addOperationWithBlock:^{
                    weakSelf.filteredSections = filteredSections;
                    [weakSelf.searchController.searchResultsTableView reloadData];
                }];
            }];
        } repeats:NO];
        self.typingTimer.tolerance = 0.05;
        return NO;
    }
}

- (void)searchDisplayController:(UISearchDisplayController *)controller willHideSearchResultsTableView:(UITableView *)tableView {
    [self.typingTimer invalidate];
    [self.searchQueue cancelAllOperations];
    [self fillCellsFromSections];
    [self.tableView reloadData];
}

- (void)searchDisplayControllerWillBeginSearch:(UISearchDisplayController *)controller {
    self.searchBar.searchBarStyle = kSearchBarActiveStyle;
    [self.moodleService cancelOperationsForDelegate:self];
    [self.lgRefreshControl endRefreshing];
}

- (void)searchDisplayControllerWillEndSearch:(UISearchDisplayController *)controller {
    self.searchBar.searchBarStyle = kSearchBarDefaultStyle;
}

#pragma mark - MoodleServiceDelegate

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

- (void)serviceConnectionToServerFailed {
    [PCUtils showConnectionToServerTimedOutAlert];
    [self.lgRefreshControl endRefreshingWithDelay:2.0 indicateErrorWithMessage:NSLocalizedStringFromTable(@"ConnectionToServerTimedOutShort", @"PocketCampus", nil)];
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    MoodleSection* section;
    if (tableView == self.tableView) {
        if (!self.sections.count) {
            return;
        }
        section = self.sections[indexPath.section];
    } else if (tableView == self.searchController.searchResultsTableView) {
        if (!self.filteredSections.count) {
            return;
        }
        section = self.filteredSections[indexPath.section];
        [self.searchController.searchBar resignFirstResponder];
    }
    
    MoodleResource* resource = section.iResources[indexPath.row];
    
    if (self.splitViewController && [resource isEqualToMoodleResource:self.selectedResource]) {
        return;
    }
    MoodleResourceViewController* detailViewController = [[MoodleResourceViewController alloc] initWithMoodleResource:resource];

    if (self.splitViewController) { // iPad
        if (self.selectedResource) {
            PCTableViewCellAdditions* prevCell = self.cellForMoodleResource[self.selectedResource];
            prevCell.durablySelected = NO;
        }
        self.selectedResource = resource;
        
        PCTableViewCellAdditions* newCell = self.cellForMoodleResource[resource];
        newCell.durablySelected = YES;
        
        PCNavigationController* detailNavController = [[PCNavigationController alloc] initWithRootViewController:detailViewController]; //to have nav bar
        self.splitViewController.viewControllers = @[self.splitViewController.viewControllers[0], detailNavController];
    } else { // iPhone
        [self.navigationController pushViewController:detailViewController animated:YES];
    }
}

- (UITableViewCellEditingStyle)tableView:(UITableView *)tableView editingStyleForRowAtIndexPath:(NSIndexPath *)indexPath {
    //if (tableView == self.tableView) {
        PCTableViewCellAdditions* cell = (PCTableViewCellAdditions*)[self.tableView cellForRowAtIndexPath:indexPath];
        if (cell.isDownloadedIndicationVisible) {
            return UITableViewCellEditingStyleDelete;
        }
    //}
    return UITableViewCellEditingStyleNone;
}

- (void)tableView:(UITableView *)tableView willBeginEditingRowAtIndexPath:(NSIndexPath *)indexPath {
    //nothing to do, just prevent table view to enter editing mode (would show delete control in other cells which we don't want)
    //see http://stackoverflow.com/questions/6437916/how-to-avoid-swipe-to-delete-calling-setediting-at-the-uitableviewcell
}

- (void)tableView:(UITableView *)tableView didEndEditingRowAtIndexPath:(NSIndexPath *)indexPath {
    //see tableView:willBeginEditingRowAtIndexPath:
    [[tableView cellForRowAtIndexPath:indexPath] setEditing:NO];
}

- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section {
    if (tableView == self.tableView) {
        if (!self.sections.count) {
            return 0.0;
        }
        if (![self showSection:section]) {
            return 0.0;
        }
        MoodleSection* secObj = self.sections[section];
        if (secObj.iResources.count == 0) {
            return 0.0;
        }
    } else if (tableView == self.searchController.searchResultsTableView) {
        if (!self.filteredSections.count) {
            return 0.0;
        }
        if (![self showSection:section]) {
            return 0.0;
        }
        MoodleSection* secObj = self.filteredSections[section];
        if (secObj.iResources.count == 0) {
            return 0.0;
        }
    } else {
        //should not happen
    }
    return [PCTableViewSectionHeader preferredHeight];
}

- (UIView *)tableView:(UITableView *)tableView viewForHeaderInSection:(NSInteger)section {
    if (tableView == self.tableView) {
        if (!self.sections.count || ![self showSection:section]) {
            return nil;
        }
        MoodleSection* secObj = self.sections[section];
        if (secObj.iResources.count == 0) {
            return nil;
        }
    }
    if (tableView == self.searchController.searchResultsTableView) {
        if (!self.filteredSections.count || ![self showSection:section]) {
            return nil;
        }
        MoodleSection* secObj = self.filteredSections[section];
        if (secObj.iResources.count == 0) {
            return nil;
        }
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
    return nil;
}

#pragma mark - UITableViewDataSource

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        MoodleSection* section = tableView == self.tableView ? self.sections[indexPath.section] : self.filteredSections[indexPath.section];
        MoodleResource* resource = section.iResources[indexPath.row];
        if ([self.moodleService deleteDownloadedMoodleResource:resource]) {
            [tableView setEditing:NO animated:YES];
        } else {
            [[[UIAlertView alloc] initWithTitle:NSLocalizedStringFromTable(@"Error", @"PocketCampus", nil) message:NSLocalizedStringFromTable(@"ImpossibleDeleteFile", @"MoodlePlugin", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil] show];
            return;
        }
    }
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (tableView == self.tableView && self.sections && self.sections.count == 0) {
        if (indexPath.row == 1) {
            return [[PCCenterMessageCell alloc] initWithMessage:NSLocalizedStringFromTable(@"MoodleEmptyCourse", @"MoodlePlugin", nil)];
        } else {
            UITableViewCell* cell =[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:nil];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
            return cell;
        }
    }
    
    if (tableView == self.searchController.searchResultsTableView) {
        //UISearchDisplayController takes care itself to show a "No result" message when
        //filteredSections is empty
    }
    
    MoodleSection* section = tableView == self.tableView ? self.sections[indexPath.section] : self.filteredSections[indexPath.section];
    MoodleResource* resource = section.iResources[indexPath.row];
    PCTableViewCellAdditions* cell = self.cellForMoodleResource[resource];
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    if (tableView == self.tableView) {
        if (!self.sections) {
            return 0;
        }
        if (self.sections.count == 0) {
            return 2; //first empty cell, second cell says no content
        }
        if(![self showSection:section]) {
            return 0;
        }
        MoodleSection* secObj = self.sections[section];
        return secObj.iResources.count;
    }
    if (tableView == self.searchController.searchResultsTableView) {
        if (!self.filteredSections) {
            return 0;
        }
        if(![self showSection:section]) {
            return 0;
        }
        MoodleSection* secObj = self.filteredSections[section];
        return secObj.iResources.count;
    }
    return 0;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    if (tableView == self.tableView) {
        if (!self.sections) {
            return 0;
        }
        if (self.sections.count == 0) {
            return 1; //empty course message
        }
        return self.sections.count;
    }
    if (tableView == self.searchController.searchResultsTableView) {
        return self.filteredSections.count;
    }
    return 0;
}

#pragma mark - showSections

- (BOOL)showSection:(NSInteger)section {
    if (section == 0) {
        return NO;
    }
    if (self.currentWeek <= 0) {
        return YES;
    }
    return (self.currentWeek == section);
}

#pragma mark - Dealloc

- (void)dealloc
{
    [self.moodleService removeMoodleResourceObserver:self];
    [self.moodleService cancelOperationsForDelegate:self];
    [self.searchQueue cancelAllOperations];
    [self.typingTimer invalidate];
    @try {
        [[NSNotificationCenter defaultCenter] removeObserver:self];
    }
    @catch (NSException *exception) {}
}

@end
