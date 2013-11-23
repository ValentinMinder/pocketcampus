//
//  TransportAddStationViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 24.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//


#import "TransportAddStationViewController.h"

#import "TransportUtils.h"

@interface TransportAddStationViewController ()<TransportServiceDelegate, UISearchBarDelegate, UITableViewDelegate, UITableViewDataSource>

@property (nonatomic, strong) IBOutlet UITableView* tableView;
@property (nonatomic, strong) IBOutlet UILabel* messageLabel;
@property (nonatomic, strong) IBOutlet UIActivityIndicatorView* barActivityIndicator;
@property (nonatomic, strong) IBOutlet UISearchBar* searchBar;

@property (nonatomic, strong) TransportService* transportService;
@property (nonatomic, strong) NSArray* stations;
@property (nonatomic, strong) NSTimer* typingTimer;

@end

@implementation TransportAddStationViewController

#pragma mark - Init

- (id)init
{
    self = [super initWithNibName:@"TransportAddStationView" bundle:nil];
    if (self) {
        self.title = NSLocalizedStringFromTable(@"AddStation", @"TransportPlugin", nil);
        self.transportService = [TransportService sharedInstanceToRetain];
    }
    return self;
}

#pragma mark - UIViewController overrides

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    [[PCGAITracker sharedTracker] trackScreenWithName:@"/transport/addStation"];
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemCancel target:self action:@selector(dismiss)];
    self.searchBar.placeholder = NSLocalizedStringFromTable(@"AddStationSearchFieldPlaceholder", @"TransportPlugin", nil);
    self.searchBar.isAccessibilityElement = YES;
    self.searchBar.accessibilityIdentifier = @"SearchBar";
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    [self.searchBar becomeFirstResponder];
}

- (NSUInteger)supportedInterfaceOrientations //iOS 6
{
    return UIInterfaceOrientationMaskPortrait;
}

#pragma mark - Requests & utils

- (void)startAutocompleteRequest {
    [self.transportService cancelOperationsForDelegate:self];
    if (self.searchBar.text.length == 0) {
        return;
    }
    [self.barActivityIndicator startAnimating];
    [self.transportService autocomplete:self.searchBar.text delegate:self];
}

- (void)showNoResultMessage {
    [self.barActivityIndicator stopAnimating];
    self.tableView.hidden = YES;
    self.messageLabel.text = NSLocalizedStringFromTable(@"SearchStationNoResult", @"TransportPlugin", nil);
}

- (void)resultsError {
    [self.transportService cancelOperationsForDelegate:self];
    [self.barActivityIndicator stopAnimating];
    self.tableView.hidden = YES;
    self.messageLabel.text = NSLocalizedStringFromTable(@"ServerError", @"PocketCampus", @"Message that says that connection to server is impossible and that internet connection must be checked.");
}

#pragma mark - Actions

- (void)dismiss {
    [self.presentingViewController dismissViewControllerAnimated:YES completion:NULL];
}

#pragma mark - TransportServiceDelegate

- (void)autocompleteFor:(NSString*)constraint didReturn:(NSArray*)results {
    [self.barActivityIndicator stopAnimating];
    if (results.count == 0) {
        [self showNoResultMessage];
        return;
    }
    
    if (self.searchBar.text.length == 0) { //result from previous non-empty search returned => return to initial state
        self.tableView.hidden = YES;
        self.messageLabel.text = nil;
        return;
    }
    
    self.tableView.hidden = NO;
    self.messageLabel.text = nil;
    
    self.stations = results;
    [self.tableView reloadSections:[NSIndexSet indexSetWithIndex:0] withRowAnimation:UITableViewRowAnimationAutomatic];
    
}

- (void)autocompleteFailedFor:(NSString*)constraint {
    [self resultsError];
}

- (void)serviceConnectionToServerTimedOut {
    [self.transportService cancelOperationsForDelegate:self];
    [self.barActivityIndicator stopAnimating];
    self.tableView.hidden = YES;
    self.messageLabel.text = NSLocalizedStringFromTable(@"ConnectionToServerTimedOut", @"PocketCampus", @"Message that says that connection to server is impossible and that internet connection must be checked.");
}

#pragma mark - UISearchBarDelegate

- (void)searchBar:(UISearchBar *)searchBar textDidChange:(NSString *)searchText {
    self.messageLabel.text = nil;
    if (searchText.length == 0) {
        [self.barActivityIndicator stopAnimating];
        [self.transportService cancelOperationsForDelegate:self];
        self.tableView.hidden = YES;
        self.messageLabel.text = nil;
        [self.tableView reloadData];
        return;
    }
    [self.typingTimer invalidate];
    self.typingTimer = nil;
    if (searchText.length > 1) {
        self.typingTimer = [NSTimer scheduledTimerWithTimeInterval:0.5 target:self selector:@selector(startAutocompleteRequest) userInfo:nil repeats:NO];
    }
}

- (void)searchBarSearchButtonClicked:(UISearchBar *)searchBar {
    [self.searchBar resignFirstResponder];
}

#pragma mark - UIScrollViewDelegate

- (void)scrollViewWillBeginDragging:(UIScrollView *)scrollView {
    [self.searchBar resignFirstResponder];
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView_ didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (indexPath.row >= self.stations.count) {
        return;
    }
    TransportStation* newStation = self.stations[indexPath.row];
    NSMutableOrderedSet* userStations = [self.transportService.userTransportStations mutableCopy];
    for (TransportStation* station in userStations) {
        if (newStation.id == station.id) {
            [self.tableView deselectRowAtIndexPath:indexPath animated:YES];
            UIAlertView* alertView = [[UIAlertView alloc] initWithTitle:nil message:NSLocalizedStringFromTable(@"StationAlreadyFavorite", @"TransportPlugin", nil) delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
            [alertView show];
            return;
        }
    }
    [userStations addObject:newStation]; //inserting at end of list
    self.transportService.userTransportStations = userStations;
    [self dismiss];
}

#pragma mark - UITableViewDataSource

- (UITableViewCell *)tableView:(UITableView *)tableView_ cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    TransportStation* station = self.stations[indexPath.row];
    static NSString* identifier = @"StationNameAutocompleteCell";
    UITableViewCell* cell =  [self.tableView dequeueReusableCellWithIdentifier:identifier];
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:identifier];
    }
    cell.textLabel.text = [TransportUtils nicerName:station.name];
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.stations.count;
}

#pragma mark - Dealloc

- (void)dealloc
{
    [self.transportService cancelOperationsForDelegate:self];
}

@end
