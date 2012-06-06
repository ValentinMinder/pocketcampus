//
//  MapViewController.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 12.04.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <UIKit/UIKit.h>

#import <MapKit/MapKit.h>

#import "map.h"

#import "MapService.h"

#import "EPFLTileOverlay.h"

#import "CustomOverlayView.h"

typedef enum {
    SearchBarStateVisible,
    SearchBarStateHidden
} SearchBarState;

@interface MapViewController : UIViewController<MKMapViewDelegate, UIGestureRecognizerDelegate, UIActionSheetDelegate, UISearchBarDelegate, UIGestureRecognizerDelegate, MapServiceDelegate> {
    UIBarButtonItem* myLocationButton;
    UIBarButtonItem* floorDownButton;
    UILabel* floorLabel;
    UIBarButtonItem* floorUpButton;
    UIActionSheet* othersActionSheet;
    UIToolbar* toolbar;
    MapService* mapService;
    NSString* initialQuery;
    NSString* initialQueryManualPinLabelText;
    MKMapView* mapView;
    EPFLTileOverlay* epflTileOverlay;
    CustomOverlayView* overlayView;
    BOOL epflTileOverlayVisible;
    MKCoordinateRegion epflRegion;
    UISearchBar* searchBar;
    UIActivityIndicatorView* searchActivityIndicator; //no need to release it, the searchBar retains it
    SearchBarState searchBarState;
    CGRect searchBarHiddenFrame;
    CGRect searchBarVisibleFrame;
}

@property (nonatomic, assign) IBOutlet MKMapView* mapView;
@property (nonatomic, assign) IBOutlet UISearchBar* searchBar;
@property (nonatomic, assign) IBOutlet UIBarButtonItem* myLocationButton;
@property (nonatomic, assign) IBOutlet UIBarButtonItem* floorDownButton;
@property (nonatomic, assign) IBOutlet UILabel* floorLabel;
@property (nonatomic, assign) IBOutlet UIBarButtonItem* floorUpButton;
@property (nonatomic, assign) IBOutlet UIToolbar* toolbar;

- (id)initWithInitialQuery:(NSString*)query;
- (id)initWithInitialQuery:(NSString*)query pinTextLabel:(NSString*)pinTextLabel;

- (IBAction)myLocationPressed;
- (IBAction)floorDownPressed;
- (IBAction)floorUpPressed;
- (IBAction)othersPressed;


@end
