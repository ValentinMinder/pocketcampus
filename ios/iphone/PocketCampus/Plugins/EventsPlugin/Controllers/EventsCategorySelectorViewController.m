//
//  CategorySelectorViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 08.03.13.
//  Copyright (c) 2013 EPFL. All rights reserved.
//

#import "EventsCategorySelectorViewController.h"

#import "PCUtils.h"

@interface EventsCategorySelectorViewController ()

@property (nonatomic, strong) NSArray* allCategories;
@property (nonatomic, strong) NSArray* selectedInitially;

@end

static NSString* kCategoryCell = @"CategoryCell";

@implementation EventsCategorySelectorViewController

- (id)initWithCategories:(NSArray*)allCategories selectedInitially:(NSArray*)selectedInitially userValidatedSelectionBlock:(void (^)(NSArray* newlySelected))userValidatedSelectionBlock
{
    self = [super initWithNibName:@"EventsCategorySelectorView" bundle:nil];
    if (self) {
        [PCUtils throughExceptionIfObject:allCategories notKindOfClass:[NSArray class]];
        self.allCategories = allCategories;
        self.selectedInitially = selectedInitially;
        self.userValidatedSelectionBlock = userValidatedSelectionBlock;
        self.title = NSLocalizedStringFromTable(@"SelectCategory", @"EventsPlugin", nil);
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemCancel target:self action:@selector(cancelButtonPressed)];

}

- (NSUInteger)supportedInterfaceOrientations //iOS 6
{
    return UIInterfaceOrientationMaskPortrait;
}

- (BOOL)shouldAutorotate {
    //special dynamic conditions for temporary prevent rotation
    return NO;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation // iOS 5 and earlier
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

#pragma mark - Buttons actions

- (void)cancelButtonPressed {
    [self.presentingViewController dismissViewControllerAnimated:YES completion:NULL];
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    self.userValidatedSelectionBlock([NSArray arrayWithObject:self.allCategories[indexPath.row]]);
}

#pragma mark - UITableViewDataSource

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell* cell = [tableView dequeueReusableCellWithIdentifier:kCategoryCell];
    
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:kCategoryCell];
        cell.selectionStyle = UITableViewCellSelectionStyleGray;
    }
    
    cell.textLabel.text = self.allCategories[indexPath.row];
    
    return cell;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    if (self.allCategories) {
        return [self.allCategories count];
    }
    
    return 0;
}


- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {

    if (self.allCategories) {
        return 1;
    }
    
    return 0;
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    }   
    else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/



@end