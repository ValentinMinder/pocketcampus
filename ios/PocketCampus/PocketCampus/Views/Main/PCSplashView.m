//
//  PCSplashView.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 30.11.13.
//  Copyright (c) 2013 EPFL. All rights reserved.
//

#import "PCSplashView.h"

@interface PCSplashView ()

@property (nonatomic, strong) UIImageView* backgroundImageView;

@property (nonatomic, strong) UIImageView* drawingImageView;

@property (nonatomic, strong) NSLayoutConstraint* drawingImageViewCenterYConstraint;

@end

@implementation PCSplashView

#pragma mark - Init

- (id)initWithSuperview:(UIView*)superview {
    self = [super initWithFrame:CGRectMake(0, 0, 1, 1)];
    if (self) {
        self.translatesAutoresizingMaskIntoConstraints = NO;
        [superview addSubview:self];
        [superview addConstraints:[NSLayoutConstraint constraintsToSuperview:superview forView:self edgeInsets:UIEdgeInsetsMake(0, 0, 0, 0)]];
        self.backgroundImageView = [[UIImageView alloc] initWithFrame:CGRectMake(0, 0, 1, 1)];
        self.backgroundImageView.translatesAutoresizingMaskIntoConstraints = NO;
        self.backgroundImageView.image = [self imageForDevice];
        [self addSubview:self.backgroundImageView];
        [self addConstraints:[NSLayoutConstraint constraintsToSuperview:self forView:self.backgroundImageView edgeInsets:UIEdgeInsetsMake(0, 0, 0, 0)]];
        
        self.drawingImageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"PocketCampusDrawing"]];
        self.drawingImageView.translatesAutoresizingMaskIntoConstraints = NO;
        [self.backgroundImageView addSubview:self.drawingImageView];
        self.drawingImageViewCenterYConstraint = [NSLayoutConstraint constraintForCenterYtoSuperview:self.backgroundImageView forView:self.drawingImageView constant:0.0];
        [self.backgroundImageView addConstraint:self.drawingImageViewCenterYConstraint];
        [self.backgroundImageView addConstraint:[NSLayoutConstraint constraintForCenterXtoSuperview:self.backgroundImageView forView:self.drawingImageView constant:0.0]];
        
        
    }
    return self;
}

- (id)initWithFrame:(CGRect)frame
{
    return [self init];
}

#pragma mark - Public methods

- (void)hideWithAnimationDuration:(NSTimeInterval)duration completion:(VoidBlock)completion {
    //duration = 5.0;
    CGFloat originalHeight = self.drawingImageView.frame.size.height;
    CGFloat compressedHeight = self.drawingImageView.frame.size.height*0.85;
    NSArray* compressedSizeConstraints = [NSLayoutConstraint width:self.drawingImageView.frame.size.width height:compressedHeight constraintsForView:self.drawingImageView];
    [self.drawingImageView addConstraints:compressedSizeConstraints];
    self.drawingImageViewCenterYConstraint.constant = (originalHeight-compressedHeight)/2.0;
    [UIView animateWithDuration:duration*0.6 delay:0.0 options:UIViewAnimationOptionCurveEaseInOut animations:^{
        [self.backgroundImageView layoutIfNeeded];
    } completion:^(BOOL finished) {
        [self.drawingImageView removeConstraints:compressedSizeConstraints];
        self.drawingImageViewCenterYConstraint.constant = 0.0;
        [UIView animateWithDuration:duration*0.07 delay:0.0 options:UIViewAnimationOptionCurveEaseIn animations:^{
            [self.backgroundImageView layoutIfNeeded];
        } completion:^(BOOL finished) {
            
            self.drawingImageViewCenterYConstraint.constant = [PCUtils is4inchDevice] ? -300.0 : -212.0;
            [UIView animateWithDuration:duration*0.33 delay:0.0 options:UIViewAnimationOptionCurveEaseOut animations:^{
                self.alpha = 0.0;
                [self.backgroundImageView layoutIfNeeded];
            } completion:^(BOOL finished) {
                if (completion) {
                    completion();
                }
            }];
        }];
    }];
}

#pragma mark - Image

- (UIImage*)imageForDevice {
    if ([PCUtils is4inchDevice]) {
        return [UIImage imageNamed:@"SplashImage4inch"];
    } else {
        return [UIImage imageNamed:@"SplashImage"];
    }
}

@end
