//
//  MyEduCourseListViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 24.10.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "MyEduCourseListViewController.h"

#import "ObjectArchiver.h"

#import "PCUtils.h"

#import "PCRefreshControl.h"

#import "PCCenterMessageCell.h"

#import "MyEduSectionListViewController.h"

#import "MyEduCourseInfoViewController.h"

@interface MyEduCourseListViewController ()

@property (nonatomic, strong) MyEduService* myEduService;
@property (nonatomic, strong) NSArray* subscribedCourses;
@property (nonatomic, strong) AuthenticationController* authController;
@property (nonatomic, strong) MyEduTequilaToken* tequilaToken;
@property (nonatomic, strong) PCRefreshControl* pcRefreshControl;

@end

static NSString* kMyEduCourseListCell = @"MyEduCourseListCell";

@implementation MyEduCourseListViewController

- (id)init
{
    self = [super initWithNibName:@"MyEduCourseListView" bundle:nil];
    if (self) {
        // Custom initialization
        self.myEduService = [MyEduService sharedInstanceToRetain];
        self.authController = [[AuthenticationController alloc] init];
        self.subscribedCourses = [self.myEduService getFromCacheSubscribedCoursesListForRequest:[self.myEduService createMyEduRequest]].iSubscribedCourses;
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    /*UIView* backgroundView = [[UIView alloc] init];
    backgroundView.backgroundColor = [UIColor whiteColor];
    self.tableView.backgroundView = backgroundView;
    self.tableView.backgroundColor = [UIColor clearColor];*/
    self.pcRefreshControl = [[PCRefreshControl alloc] initWithTableViewController:self];
    [self.pcRefreshControl setTarget:self selector:@selector(refresh)];
}

- (void)viewDidAppear:(BOOL)animated {
    if (!self.subscribedCourses) {
        [self refresh];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - refresh control

- (void)refresh {
    [self.myEduService cancelOperationsForDelegate:self]; //cancel before retrying
    [self.pcRefreshControl startRefreshingWithMessage:NSLocalizedStringFromTable(@"DownloadingCourseList", @"MyEduPlugin", nil)];
    [self startGetSubscribedCoursesListRequest];
}

- (void)login {
    [self.myEduService getTequilaTokenForMyEduWithDelegate:self];
}

- (void)startGetSubscribedCoursesListRequest {
    if ([self.myEduService lastSession]) {
        [self.myEduService getSubscribedCoursesListForRequest:[[MyEduRequest alloc] initWithIMyEduSession:[self.myEduService lastSession] iLanguage:[PCUtils userLanguageCode]] delegate:self];
    } else {
        [self login];
    }
}

#pragma mark - MyEduServiceDelegate

- (void)getSubscribedCoursesListForRequest:(MyEduRequest *)request didReturn:(MyEduSubscribedCoursesListReply *)reply {
    switch (reply.iStatus) {
        case 200:
            self.subscribedCourses = reply.iSubscribedCourses;
            [self.tableView reloadData];
            [self.pcRefreshControl endRefreshing];
            break;
        case 407:
            [self login];
            break;
        default:
            [self getSubscribedCoursesListFailedForRequest:request];
            break;
    }
}

- (void)getSubscribedCoursesListFailedForRequest:(MyEduRequest *)request {
    [self error];
}

- (void)getTequilaTokenForMyEduDidReturn:(MyEduTequilaToken *)tequilaToken {
    self.tequilaToken = tequilaToken;
    if (self.splitViewController) {
        [self.authController authToken:tequilaToken.iTequilaKey presentationViewController:self.splitViewController delegate:self];
    } else {
        [self.authController authToken:tequilaToken.iTequilaKey presentationViewController:self delegate:self];
    }
}

- (void)getTequilaTokenForMyEduFailed {
    [self error];
}

- (void)getMyEduSessionForTequilaToken:(MyEduTequilaToken *)tequilaToken didReturn:(MyEduSession *)myEduSession {
    [self.myEduService saveSession:myEduSession];
    [self startGetSubscribedCoursesListRequest];
}

- (void)getMyEduSessionFailedForTequilaToken:(MyEduTequilaToken *)tequilaToken {
    [self error];
}

- (void)error {
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerErrorShort", @"PocketCampus", nil);
    if (!self.subscribedCourses) {
        [[[UIAlertView alloc] initWithTitle:NSLocalizedStringFromTable(@"Error", @"PocketCampus", nil) message:NSLocalizedStringFromTable(@"ConnectionToServerError", @"PocketCampus", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil] show];
    }
    [self.pcRefreshControl hideInTimeInterval:2.0];
}

- (void)serviceConnectionToServerTimedOut {
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerTimedOutShort", @"PocketCampus", nil);
    if (!self.subscribedCourses) {
        [[[UIAlertView alloc] initWithTitle:NSLocalizedStringFromTable(@"Error", @"PocketCampus", nil) message:NSLocalizedStringFromTable(@"ConnectionToServerTimedOut", @"PocketCampus", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil] show];
    }
    [self.pcRefreshControl hideInTimeInterval:2.0];
}

#pragma mark - AuthenticationCallbackDelegate

- (void)authenticationSucceeded {
    if (!self.tequilaToken) {
        NSLog(@"-> ERROR : no tequilaToken saved after successful authentication");
        return;
    }
    [self.myEduService getMyEduSessionForTequilaToken:self.tequilaToken delegate:self];
}

- (void)userCancelledAuthentication {
    //TODO
}

- (void)invalidToken {
    [self startGetSubscribedCoursesListRequest];
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    MyEduCourse* course = self.subscribedCourses[indexPath.row];
    if (self.splitViewController) {
        self.splitViewController.viewControllers = @[self.splitViewController.viewControllers[0], [[MyEduCourseInfoViewController alloc] initWithCourse:course]];
    }
    [self.navigationController pushViewController:[[MyEduSectionListViewController alloc] initWithMyEduCourse:course] animated:YES];
}

#pragma mark - UITableViewDataSource

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (self.subscribedCourses && [self.subscribedCourses count] == 0) {
        if (indexPath.row == 2) {
            return [[PCCenterMessageCell alloc] initWithMessage:NSLocalizedStringFromTable(@"NotSubscribedToAnyCourse", @"MyEduPlugin", nil)];
        } else {
            return [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:nil];
        }
    }
    
    MyEduCourse* course = self.subscribedCourses[indexPath.row];
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:kMyEduCourseListCell];
    
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:kMyEduCourseListCell];
        cell.selectionStyle = UITableViewCellSelectionStyleGray;
        cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
    }
    
    cell.textLabel.text = course.iTitle;
    cell.detailTextLabel.text = course.iDescription;
    
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    if ([self.subscribedCourses count] == 0) {
        return 2; //first empty cell, second cell says no content
    }
    return [self.subscribedCourses count];
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    if (!self.subscribedCourses) {
        return 0;
    }
    return 1;
}

- (void)dealloc
{
    [self.myEduService cancelOperationsForDelegate:self];
}


@end
