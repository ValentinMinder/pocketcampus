//
//  PCConfig.h
//  PocketCampus
//
//  Created by Loïc Gardiol on 03.09.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import <Foundation/Foundation.h>

/* IMPORTAN : __unused compiler flags are put so suppress unused warning. Do not remove. */

static NSString* GET_CONFIG_URL __unused = @"http://pocketcampus.epfl.ch/backend/get_config.php";

/* DEV NOTE : If a Config.plist is present in Application Support/<bundle_identifier>/, it will override any other config */

/* KEYS used in defaults (NSUserDefaults) */

/* these keys must match the ones returned by http://pocketcampus.epfl.ch/backend/get_config.php */

static NSString* PC_CONFIG_SERVER_PROTOCOL_KEY __unused = @"server_protocol";

static NSString* PC_CONFIG_SERVER_ADDRESS_KEY __unused = @"server_address";

static NSString* PC_CONFIG_SERVER_PORT_KEY __unused = @"server_port";

static NSString* PC_CONFIG_SERVER_URI_KEY __unused = @"server_uri";

/* following keys are optional and not garanteed to be existing in http://pocketcampus.epfl.ch/backend/get_config.php or bundle Config.plist */

static NSString* PC_OPTIONAL_CONFIG_ALLOW_MEALS_MULTI_VOTES_KEY __unused = @"allow_meals_mutli_votes";

static NSString* PC_OPTIONAL_GAN_DISABLED_KEY __unused = @"GAN_disabled"; //GAN is Google Analytics. If disabled, value in defaults is BOOL YES

/* VALUES FOR SOME DEFAULTS THINGS */

static NSString* PC_PROD_GAN_ACCOUNT_ID __unused = @"UA-22135241-3";

static NSInteger PC_PROD_GAN_DISPATCH_PERIOD_SEC __unused = 10; // The constant is used in AppDelegate when starting the GAN tracker

/* CONFIG TYPES - Defined in user defaults after + (void)initConfig has been called */

static NSString* PC_CONFIG_TYPE_KEY __unused = @"init_config_type";

static NSString* PC_CONFIG_TYPE_FROM_SERVER __unused = @"init_config_from_server";
static NSString* PC_CONFIG_TYPE_FROM_BUNDLE __unused = @"init_config_from_bundle";
static NSString* PC_CONFIG_TYPE_FROM_APPLICATION_SUPPORT __unused = @"init_config_type_from_application_support"; //when Config.plist in Application Support overrides all other configs

@interface PCConfig : NSObject

/* 
 * MUST BE CALLED BEFORE ANY ACCESS TO DEFAULTS
 * This method will synchronously (blocking) populate NSUserDefaults with content returned by http://pocketcampus.epfl.ch/backend/get_config.php
 * or Config.plist from bundle if server cannot be reached.
 * IMPORTANT DEV NOTE : if a Application Support/<bundle_identifier>/Config.plist exists, it will override keys found
 */
+ (void)initConfig;
    
+ (NSUserDefaults*)defaults;

@end
