//
//  CategorySelectorViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 08.03.13.
//  Copyright (c) 2013 EPFL. All rights reserved.
//

#import "EventsCategorySelectorViewController.h"

#import "PCUtils.h"

#import "PCCenterMessageCell.h"

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
        [PCUtils throwExceptionIfObject:allCategories notKindOfClass:[NSArray class]];
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
    if ([PCUtils isIdiomPad]) {
        return UIInterfaceOrientationMaskAll;
    } else {
        return UIInterfaceOrientationMaskPortrait;
    }
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation //<= iOS5
{
    if ([PCUtils isIdiomPad]) {
        return YES;
    } else {
        return (interfaceOrientation == UIInterfaceOrientationPortrait);
    }
}


#pragma mark - Buttons actions

- (void)cancelButtonPressed {
    [self.presentingViewController dismissViewControllerAnimated:YES completion:NULL];
}

#pragma mark - UITableViewDelegate

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    if (!self.allCategories.count) {
        return;
    }
    if (!self.userValidatedSelectionBlock) {
        return;
    }
    self.userValidatedSelectionBlock([NSArray arrayWithObject:self.allCategories[indexPath.row]]);
}

#pragma mark - UITableViewDataSource

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (self.allCategories && [self.allCategories count] == 0) {
        if (indexPath.row == 1) {
            return [[PCCenterMessageCell alloc] initWithMessage:NSLocalizedStringFromTable(@"NoCategory", @"EventsPlugin", nil)];
        } else {
            UITableViewCell* cell =[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:nil];
            cell.selectionStyle = UITableViewCellSelectionStyleNone;
            return cell;
        }
    }
    
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
        NSInteger count = [self.allCategories count];
        if (count == 0) {
            return 2; //no category message a row index 1
        }
        return count;
    }
    
    return 0;
}


- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {

    if (self.allCategories) {
        return 1;
    }
    return 0;
}

@end