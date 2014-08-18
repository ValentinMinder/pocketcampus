//
//  RecommendedAppTableViewCell.m
//  PocketCampus
//
//  Created by Silviu Andrica on 8/18/14.
//  Copyright (c) 2014 EPFL. All rights reserved.
//

#import "RecommendedAppTableViewCell.h"
#import "RecommendedAppScrollView.h"
#import "RecommendedAppThumbView.h"
#import "UIImageView+AFNetworking.h"
#import <BTStoreView.h>

@interface RecommendedAppTableViewCell()
@property (nonatomic, weak) IBOutlet RecommendedAppScrollView* recommendedAppsScrollView;
@property (nonatomic, weak) IBOutlet UILabel* categoryNameLabel;
@property (nonatomic, weak) IBOutlet UILabel* categoryDescriptionLabel;
@property (nonatomic, weak) IBOutlet UIImageView* categoryLogoImage;
@end

@implementation RecommendedAppTableViewCell

- (instancetype)initWithRecommendedApps:(NSArray*)recommendedApps forCategory:(RecommendedAppCategory*)category{
    NSArray* elements = [[NSBundle mainBundle] loadNibNamed:@"RecommendedAppTableViewCell" owner:nil options:nil];
    self = (RecommendedAppTableViewCell*)elements[0];
    if(self){
        self.recommendedAppsScrollView.appItems = recommendedApps;
        [self.recommendedAppsScrollView setAppThumbTapped:^(RecommendedAppThumbView * thumbView) {
            RecommendedApp* app = thumbView.recommendedApp;
            RecommendedAppOSConfiguration* config = app.appOSConfigurations[@(AppStore_iOS)];
            NSString* appStoreURL = config.appStoreURL;
            NSInteger appStoreAppId = [appStoreURL integerValue];
            [[BTStoreView sharedInstance] openAppStorePageForAppId:appStoreAppId];
        }];
        self.categoryDescriptionLabel.text = category.categoryDescription;
        self.categoryNameLabel.text = category.categoryName;
        [self.categoryLogoImage setImageWithURL:[NSURL URLWithString:category.categoryLogoURL]];
    }
    return self;
}
@end
