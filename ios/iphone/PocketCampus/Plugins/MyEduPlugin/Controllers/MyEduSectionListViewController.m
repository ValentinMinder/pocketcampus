//
//  MyEduSectionListViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 31.10.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "MyEduSectionListViewController.h"

#import "ObjectArchiver.h"

#import "PCUtils.h"

#import "PCRefreshControl.h"

#import "MyEduModuleListViewController.h"

@interface MyEduSectionListViewController ()

@property (nonatomic, strong) MyEduService* myEduService;
@property (nonatomic, strong) MyEduCourse* course;
@property (nonatomic, strong) NSArray* sections;
@property (nonatomic, strong) AuthenticationController* authController;
@property (nonatomic, strong) MyEduTequilaToken* tequilaToken;
@property (nonatomic, strong) PCRefreshControl* pcRefreshControl;

@end

static NSString* kMyEduSectionListCell = @"MyEduSectionListCell";

@implementation MyEduSectionListViewController

- (id)initWithMyEduCourse:(MyEduCourse*)course
{
    self = [super initWithNibName:@"MyEduSectionListView" bundle:nil];
    if (self) {
        // Custom initialization
        self.course = course;
        self.title = course.iTitle;
        self.myEduService = [MyEduService sharedInstanceToRetain];
        self.authController = [[AuthenticationController alloc] init];
        //self.sections = [self.myEduService getFromCacheCourseDetailsForRequest:[[MyEduCourseDetailsRequest alloc] initWithICourseCode:self.course.iCode] myeduRequest:[self.myEduService createMyEduRequest]].iMyEduSections;
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
    if (!self.sections) {
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
    [self.pcRefreshControl startRefreshingWithMessage:NSLocalizedStringFromTable(@"DownloadingSectionList", @"MyEduPlugin", nil)];
    [self startGetCourseDetailsRequest];
}

- (void)login {
    [self.myEduService getTequilaTokenForMyEduWithDelegate:self];
}

- (void)startGetCourseDetailsRequest {
    if ([self.myEduService lastSession]) {
        [self.myEduService getCourseDetailsForRequest:[[MyEduCourseDetailsRequest alloc] initWithICourseCode:self.course.iCode] myeduRequest:[self.myEduService createMyEduRequest] delegate:self];
    } else {
        [self login];
    }
}

#pragma mark - MyEduServiceDelegate

- (void)getCourseDetailsForRequest:(MyEduCourseDetailsRequest*)request myeduRequest:(MyEduRequest*)myeduRequest didReturn:(MyEduCourseDetailsReply*)reply {
    switch (reply.iStatus) {
        case 200:
            self.sections = reply.iMyEduSections;
            [self.tableView reloadData];
            [self.pcRefreshControl endRefreshing];
            break;
        case 407:
            [self login];
            break;
        default:
            [self getCourseDetailsFailedForRequest:request myeduRequest:myeduRequest];
            break;
    }
}

- (void)getCourseDetailsFailedForRequest:(MyEduCourseDetailsRequest *)request myeduRequest:(MyEduRequest*)myeduRequest {
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerErrorShort", @"PocketCampus", nil);
    [self.pcRefreshControl hideInTimeInterval:2.0];
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
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerErrorShort", @"PocketCampus", nil);
    [self.pcRefreshControl hideInTimeInterval:2.0];
}

- (void)getMyEduSessionForTequilaToken:(MyEduTequilaToken *)tequilaToken didReturn:(MyEduSession *)myEduSession {
    [self.myEduService saveSession:myEduSession];
    [self startGetCourseDetailsRequest];
}

- (void)getMyEduSessionFailedForTequilaToken:(MyEduTequilaToken *)tequilaToken {
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerErrorShort", @"PocketCampus", nil);
    [self.pcRefreshControl hideInTimeInterval:2.0];
}

- (void)serviceConnectionToServerTimedOut {
    self.pcRefreshControl.type = RefreshControlTypeProblem;
    self.pcRefreshControl.message = NSLocalizedStringFromTable(@"ConnectionToServerTimedOutShort", @"PocketCampus", nil);
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
    //TODO
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    MyEduSection* section = self.sections[indexPath.row];
    [self.navigationController pushViewController:[[MyEduModuleListViewController alloc] initWithMyEduCourse:self.course andSection:section] animated:YES];
}

#pragma mark - UITableViewDataSource

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    MyEduSection* section = self.sections[indexPath.row];
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:kMyEduSectionListCell];
    
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:kMyEduSectionListCell];
        cell.selectionStyle = UITableViewCellSelectionStyleGray;
        cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
    }
    
    cell.textLabel.text = section.iTitle;
    cell.detailTextLabel.text = section.iDescription;
    
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    // Return the number of rows in the section.
    return [self.sections count];
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    // Return the number of sections.
    if (!self.sections) {
        return 0;
    }
    return 1;
}


@end
