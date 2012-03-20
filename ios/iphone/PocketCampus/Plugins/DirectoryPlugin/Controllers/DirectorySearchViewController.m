//
//  DirectorySearchViewController.m
//  DirectoryPlugin
//
//  Created by Loïc Gardiol on 01.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "DirectorySearchViewController.h"

@implementation DirectorySearchViewController

static NSString* kAutocompleteResultCellIdentifier = @"autocompleteResult";
static NSString* kSearchResultCellIdentifier = @"searchResult";

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
        directoryService = [[DirectoryService sharedInstanceToRetain] retain];
        typingTimer = nil;
        searchResults = nil;
        autocompleteResults = nil;
        resultsMode = ResutlsModeNotStarted;
        personViewController = nil;
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    searchBar.placeholder = NSLocalizedStringFromTable(@"SearchFieldPlaceholder", @"DirectoryPlugin", @"");
    
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
    if (resultsMode == ResutlsModeNotStarted) {
        [searchBar becomeFirstResponder];
    }
    [tableView deselectRowAtIndexPath:[tableView indexPathForSelectedRow] animated:YES];
}

- (void)viewWillAppear:(BOOL)animated {
    personViewController = nil; //so that profile picture request does not try to set picture for personViewController that is no longer displayed (and thus released)
}

- (void)viewWillDisappear:(BOOL)animated {
    [searchBar resignFirstResponder];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

- (void)startAutocompleteRequest {
    [directoryService cancelOperationsForDelegate:self];
    if (searchBar.text.length == 0) {
        return;
    }
    [barActivityIndicator startAnimating];
    [directoryService autocomplete:searchBar.text delegate:self];
}

- (void)startSearchRequest {
    [directoryService cancelOperationsForDelegate:self];
    if (searchBar.text.length == 0) {
        return;
    }
    [barActivityIndicator startAnimating];
    [directoryService searchPersons:searchBar.text delegate:self];
}

- (void)showNoResultMessage {
    [barActivityIndicator stopAnimating];
    tableView.hidden = YES;
    backgroundIcon.hidden = NO;
    messageLabel.text = NSLocalizedStringFromTable(@"SearchNoResult", @"DirectoryPlugin", @"Message that says the autocomplete/search returned empty result.");
    messageLabel.hidden = NO;
}

/* Search bar delegation */

- (void)searchBar:(UISearchBar *)searchBar textDidChange:(NSString *)searchText {
    messageLabel.text = @"";
    if (searchText.length == 0) {
        [barActivityIndicator stopAnimating];
        [directoryService cancelOperationsForDelegate:self];
        tableView.hidden = YES;
        backgroundIcon.hidden = NO;
        messageLabel.hidden = YES;
        resultsMode = ResutlsModeNotStarted;
        [tableView reloadData];
        return;
    }
    [typingTimer invalidate];
    [typingTimer release];
    typingTimer = nil;
    
    NSArray* words = [searchText componentsSeparatedByString:@" "];
    
    if (words.count > 1 && ((NSString*)[words objectAtIndex:0]).length > 1 && ((NSString*)[words objectAtIndex:1]).length > 0) {
        typingTimer = [[NSTimer scheduledTimerWithTimeInterval:0.5 target:self selector:@selector(startSearchRequest) userInfo:nil repeats:NO] retain];
    } else {
        typingTimer = [[NSTimer scheduledTimerWithTimeInterval:0.5 target:self selector:@selector(startAutocompleteRequest) userInfo:nil repeats:NO] retain];
    }
}

- (void)searchBarSearchButtonClicked:(UISearchBar *)searchBar_ {
    if (resultsMode == ResutlsModeNotStarted || resultsMode == ResultsModeFailed) {
        messageLabel.text = @"";
        [self startAutocompleteRequest];
    }
    [searchBar resignFirstResponder];
}

/* UIScrollView delegation */

- (void)scrollViewWillBeginDragging:(UIScrollView *)scrollView {
    [searchBar resignFirstResponder];
}


/* DirectoryServiceDelegate delegation */

- (void)autocompleteFor:(NSString *)constraint didReturn:(NSArray*)results {
    [barActivityIndicator stopAnimating];
    if (results.count == 0) {
        [self showNoResultMessage];
        return;
    }
    
    if (searchBar.text.length == 0) { //result from previous non-empty search returned => return to initial state
        tableView.hidden = YES;
        backgroundIcon.hidden = NO;
        messageLabel.hidden = YES;
        return;
    }
    
    tableView.hidden = NO;
    backgroundIcon.hidden = YES;
    messageLabel.hidden = YES;
    
    [autocompleteResults release];
    autocompleteResults = [results retain];
    resultsMode = ResultsModeAutocomplete;
    [tableView reloadSections:[NSIndexSet indexSetWithIndex:0] withRowAnimation:UITableViewRowAnimationFade];
    
    
    if (results.count == 1) {
        NSString* searchString = [NSString stringWithFormat:@"%@ ", [results objectAtIndex:0]];
        [directoryService searchPersons:searchString delegate:self];
    }
    
}

- (void)autocompleteFailedFor:(NSString *)constraint {
    [self resultsError];
}

- (void)searchFor:(NSString*)searchPattern didReturn:(NSArray*)results {
    [barActivityIndicator stopAnimating];
    if (results.count == 0) {
        [self showNoResultMessage];
        return;
    }
    
    if (searchBar.text.length == 0) { //result from previous non-empty search returned => return to initial state
        tableView.hidden = YES;
        backgroundIcon.hidden = NO;
        messageLabel.hidden = YES;
        return;
    }
    tableView.hidden = NO;
    backgroundIcon.hidden = YES;
    messageLabel.hidden = YES;
    
    [searchResults release];
    searchResults = [results retain];
    resultsMode = ResultsModeSearch;
    [tableView reloadSections:[NSIndexSet indexSetWithIndex:0] withRowAnimation:UITableViewRowAnimationFade];
}

- (void)searchFailedFor:(NSString*)searchPattern {
    [self resultsError];
}

- (void)profilePictureFor:(NSString*)sciper didReturn:(NSData*)data {
    ABPersonSetImageData(personViewController.displayedPerson,(CFDataRef)data, nil);
    [personViewController loadView]; //reload view content to update picture
}

- (void)profilePictureFailedFor:(NSString*)sciper {
    ABPersonSetImageData(personViewController.displayedPerson,NULL, nil);
    [personViewController loadView]; //reload view content to remove loader png
}

- (void)resultsError {
    [directoryService cancelOperationsForDelegate:self];
    [barActivityIndicator stopAnimating];
    tableView.hidden = YES;
    messageLabel.text = NSLocalizedStringFromTable(@"ConnectionToServerError", @"PocketCampus", @"Message that says that connection to server is impossible and that internet connection must be checked.");
    messageLabel.hidden = NO;
    resultsMode = ResultsModeFailed;
}

- (void)serviceConnectionToServerTimedOut {
    [directoryService cancelOperationsForDelegate:self];
    [barActivityIndicator stopAnimating];
    tableView.hidden = YES;
    messageLabel.text = NSLocalizedStringFromTable(@"ConnectionToServerTimedOut", @"PocketCampus", @"Message that says that connection to server is impossible and that internet connection must be checked.");
    messageLabel.hidden = NO;
    resultsMode = ResultsModeFailed;
}

/* UITableViewDelegate delegation */

- (void)tableView:(UITableView *)tableView_ didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (resultsMode == ResultsModeAutocomplete) {
        UIActivityIndicatorView* activityIndicatorView = (UIActivityIndicatorView*)[[tableView cellForRowAtIndexPath:indexPath] accessoryView];
        [activityIndicatorView startAnimating];
        NSString* searchString = [NSString stringWithFormat:@"%@ ", [tableView cellForRowAtIndexPath:indexPath].textLabel.text];
        [directoryService searchPersons:searchString delegate:self];
        [searchBar resignFirstResponder];
    } else if (resultsMode == ResultsModeSearch) {
        [self pushViewControllerForPerson:[searchResults objectAtIndex:indexPath.row]];
    } else {
        //Not supported mode
    }
}


/* UITableViewDataSource delegation */

- (UITableViewCell *)tableView:(UITableView *)tableView_ cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    if (resultsMode == ResultsModeAutocomplete) {
        UITableViewCell* newCell =  [tableView dequeueReusableCellWithIdentifier:kAutocompleteResultCellIdentifier];
        if (newCell == nil) {
            newCell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleValue1 reuseIdentifier:kAutocompleteResultCellIdentifier] autorelease];
            newCell.selectionStyle = UITableViewCellSelectionStyleGray;
            newCell.accessoryView = [[[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhite] autorelease];
        } else {
            [(UIActivityIndicatorView*)(newCell.accessoryView) stopAnimating];
        }
        newCell.textLabel.text = [autocompleteResults objectAtIndex:indexPath.row];
        return newCell;
    } else if (resultsMode == ResultsModeSearch) {
        UITableViewCell* newCell =  [tableView dequeueReusableCellWithIdentifier:kSearchResultCellIdentifier];
        if (newCell == nil) {
            newCell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleValue1 reuseIdentifier:kSearchResultCellIdentifier] autorelease];
            newCell.selectionStyle = UITableViewCellSelectionStyleGray;
        }
        Person* person = [searchResults objectAtIndex:indexPath.row];
        newCell.textLabel.text = [NSString stringWithFormat:@"%@ %@", person.firstName, person.lastName];
        if ([person OrganisationalUnitIsSet]) {
            newCell.detailTextLabel.text = [person.organisationalUnit objectAtIndex:0];
        }
        return newCell;
    } else {
        //Unsupported mode
    }
    return nil;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    if(resultsMode == ResultsModeAutocomplete) {
        if (autocompleteResults == nil) { //should not happen in such mode
            return 0; 
        }
        return autocompleteResults.count;
    } else if (resultsMode == ResultsModeSearch) {
        if (searchResults == nil) { //should not happen in such mode
            return 0; 
        }
        return searchResults.count;
    } else {
        //ResulsModeNotStarted or ResultsModeFailed
        return 0;
    }
}

/* AdressBook and records creation stuff */

- (void)pushViewControllerForPerson:(Person*)person {
    
    if (![person isKindOfClass:[Person class]]) {
        goto error;
    }
    
    ABUnknownPersonViewController* viewController = [[ABUnknownPersonViewController alloc] init];
    personViewController = viewController;
    
    ABRecordRef abPerson = ABPersonCreate();
    
    viewController.unknownPersonViewDelegate = self;
    viewController.displayedPerson = abPerson;
    viewController.allowsAddingToAddressBook = YES;
    viewController.allowsActions = YES;
    viewController.title = [NSString stringWithFormat:@"%@ %@", person.firstName, person.lastName];
    
    [directoryService getProfilePicture:person.sciper delegate:self];
    
	CFErrorRef anError = NULL;
    BOOL couldCreate = true;
    
    UIImage* loadingImage = [UIImage imageNamed:@"LoadingIndicator"];
     NSData* imageData = UIImagePNGRepresentation(loadingImage);
     ABPersonSetImageData(abPerson, (CFDataRef)imageData, nil);
    
    if ([person firstNameIsSet]) {
        ABRecordSetValue(abPerson, kABPersonFirstNameProperty, person.firstName, &anError);
    }
    
    if ([person lastNameIsSet]) {
        ABRecordSetValue(abPerson, kABPersonLastNameProperty, person.lastName, &anError);
    }
    
    ABMultiValueRef phone = ABMultiValueCreateMutable(kABStringPropertyType);
    if ([person officePhoneNumberIsSet]) {
        couldCreate = ABMultiValueAddValueAndLabel(phone, person.officePhoneNumber, kABWorkLabel, NULL);
        
    }
    if ([person privatePhoneNumberIsSet]) {
        couldCreate = ABMultiValueAddValueAndLabel(phone, person.privatePhoneNumber, kABHomeLabel, NULL);
        
    }
    if (couldCreate) {
        ABRecordSetValue(abPerson, kABPersonPhoneProperty, phone, &anError);
    }
    CFRelease(phone);
    
    ABMultiValueRef email = ABMultiValueCreateMutable(kABMultiStringPropertyType);
    if ([person emailIsSet]) {
        couldCreate = ABMultiValueAddValueAndLabel(email, person.email, (CFStringRef)@"email", NULL);
        if (couldCreate) {
            ABRecordSetValue(abPerson, kABPersonEmailProperty, email, &anError);
        }
    }
    CFRelease(email);
    
    
    /* WARNING : This property makes the app crash when the viewController is pushed onto the nav stack. Why ??? */ 
    /*ABMultiValueRef office = ABMultiValueCreateMutable(kABStringPropertyType);
    if ([person officeIsSet]) {
        NSMutableString* label = [NSLocalizedStringFromTable(@"OfficeLabel", @"DirectoryPlugin", @"Short name to describe label of office room") mutableCopy];
        couldCreate = ABMultiValueAddValueAndLabel(office, [person.office mutableCopy], (CFStringRef)label, NULL);
        //couldCreate = ABMultiValueAddValueAndLabel(office, person.sciper, (CFStringRef)@"sciper", NULL);
        if (couldCreate) {
            ABRecordSetValue(abPerson, kABPersonInstantMessageProperty, office, &anError);
            CFRelease(office);
        }
    }*/
    
    
    ABMultiValueRef office = ABMultiValueCreateMutable(kABMultiDictionaryPropertyType);
    NSMutableDictionary *addressDictionary = [NSMutableDictionary dictionaryWithCapacity:2];
    if ([person officeIsSet]) {
        NSString* label = NSLocalizedStringFromTable(@"OfficeLabel", @"DirectoryPlugin", @"Short name to describe label of office room");
        [addressDictionary setObject:person.office forKey:(NSString *)kABPersonAddressCityKey];
        [addressDictionary setObject:@"" forKey:(NSString *)kABPersonAddressCountryKey];
        couldCreate = ABMultiValueAddValueAndLabel(office, addressDictionary, (CFStringRef)label, NULL);
        if (couldCreate) {
            ABRecordSetValue(abPerson, kABPersonAddressProperty, office, &anError);
        }
    }
    CFRelease(office);
    
    ABMultiValueRef web = ABMultiValueCreateMutable(kABStringPropertyType);
    if ([person webIsSet]) {
        couldCreate = ABMultiValueAddValueAndLabel(web, person.web, (CFStringRef)@"web", NULL);
        if (couldCreate) {
            ABRecordSetValue(abPerson, kABPersonURLProperty, web, &anError);
        }
    }
    CFRelease(web);
    
    
    if (anError != NULL) {
error:        
        NSLog(@"-> pushViewControllerForPerson: an error occured");
        UIAlertView* alert = [[UIAlertView alloc] initWithTitle:@"Error" message:@"Impossible to display this person, sorry." delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
        [alert show];
        [alert release];
        return;
        
        return;
    }
    
    
    if ([person OrganisationalUnitIsSet]) {
        NSString* message = @"";
        for (NSString* unit in person.OrganisationalUnit) {
            message = [message stringByAppendingFormat:@"%@ ", unit];
        }
        viewController.message = message;
    }
    CFRelease(abPerson);
    
    [self.navigationController pushViewController:viewController animated:YES];
    [viewController release];
    
    
}

/* ABUnknownPersonViewControllerDelegate delegation */

- (BOOL)unknownPersonViewController:(ABUnknownPersonViewController *)personViewController shouldPerformDefaultActionForPerson:(ABRecordRef)person property:(ABPropertyID)property identifier:(ABMultiValueIdentifier)identifier {
    if (property == kABPersonAddressProperty) {
        //TODO call map plugin with office location
        return NO;
    }
    return YES;
}

- (void)unknownPersonViewController:(ABUnknownPersonViewController *)unknownPersonView didResolveToPerson:(ABRecordRef)person {
    //Nothing
}

- (void)dealloc
{
    [directoryService cancelOperationsForDelegate:self];
    [tableView release];
    [directoryService release];
    [typingTimer release];
    [autocompleteResults release];
    [searchResults release];
    [super dealloc];
}


@end
