/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

#import <Foundation/Foundation.h>

#import "TProtocol.h"
#import "TApplicationException.h"
#import "TProtocolException.h"
#import "TProtocolUtil.h"
#import "TProcessor.h"
#import "TObjective-C.h"
#import "TBase.h"


enum AppStore {
  AppStore_iOS = 1,
  AppStore_Android = 2,
  AppStore_WindowsPhone8 = 3
};

enum RecommendedAppsResponseStatus {
  RecommendedAppsResponseStatus_OK = 200,
  RecommendedAppsResponseStatus_ERROR = 500
};

@interface RecommendedAppOSConfiguration : NSObject <TBase, NSCoding> {
  NSString * __appStoreQuery;
  NSString * __appOpenURLPattern;
  NSString * __appLogoURL;

  BOOL __appStoreQuery_isset;
  BOOL __appOpenURLPattern_isset;
  BOOL __appLogoURL_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=appStoreQuery, setter=setAppStoreQuery:) NSString * appStoreQuery;
@property (nonatomic, retain, getter=appOpenURLPattern, setter=setAppOpenURLPattern:) NSString * appOpenURLPattern;
@property (nonatomic, retain, getter=appLogoURL, setter=setAppLogoURL:) NSString * appLogoURL;
#endif

- (id) init;
- (id) initWithAppStoreQuery: (NSString *) appStoreQuery appOpenURLPattern: (NSString *) appOpenURLPattern appLogoURL: (NSString *) appLogoURL;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) appStoreQuery;
- (void) setAppStoreQuery: (NSString *) appStoreQuery;
#endif
- (BOOL) appStoreQueryIsSet;

#if !__has_feature(objc_arc)
- (NSString *) appOpenURLPattern;
- (void) setAppOpenURLPattern: (NSString *) appOpenURLPattern;
#endif
- (BOOL) appOpenURLPatternIsSet;

#if !__has_feature(objc_arc)
- (NSString *) appLogoURL;
- (void) setAppLogoURL: (NSString *) appLogoURL;
#endif
- (BOOL) appLogoURLIsSet;

@end

@interface RecommendedApp : NSObject <TBase, NSCoding> {
  int32_t __appId;
  NSString * __appName;
  NSString * __appDescription;
  NSMutableDictionary * __appOSConfigurations;

  BOOL __appId_isset;
  BOOL __appName_isset;
  BOOL __appDescription_isset;
  BOOL __appOSConfigurations_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=appId, setter=setAppId:) int32_t appId;
@property (nonatomic, retain, getter=appName, setter=setAppName:) NSString * appName;
@property (nonatomic, retain, getter=appDescription, setter=setAppDescription:) NSString * appDescription;
@property (nonatomic, retain, getter=appOSConfigurations, setter=setAppOSConfigurations:) NSMutableDictionary * appOSConfigurations;
#endif

- (id) init;
- (id) initWithAppId: (int32_t) appId appName: (NSString *) appName appDescription: (NSString *) appDescription appOSConfigurations: (NSMutableDictionary *) appOSConfigurations;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) appId;
- (void) setAppId: (int32_t) appId;
#endif
- (BOOL) appIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) appName;
- (void) setAppName: (NSString *) appName;
#endif
- (BOOL) appNameIsSet;

#if !__has_feature(objc_arc)
- (NSString *) appDescription;
- (void) setAppDescription: (NSString *) appDescription;
#endif
- (BOOL) appDescriptionIsSet;

#if !__has_feature(objc_arc)
- (NSMutableDictionary *) appOSConfigurations;
- (void) setAppOSConfigurations: (NSMutableDictionary *) appOSConfigurations;
#endif
- (BOOL) appOSConfigurationsIsSet;

@end

@interface RecommendedAppCategory : NSObject <TBase, NSCoding> {
  int32_t __categoryId;
  NSString * __categoryName;
  NSString * __categoryLogoURL;
  NSString * __categoryDescription;
  NSMutableArray * __appIds;

  BOOL __categoryId_isset;
  BOOL __categoryName_isset;
  BOOL __categoryLogoURL_isset;
  BOOL __categoryDescription_isset;
  BOOL __appIds_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=categoryId, setter=setCategoryId:) int32_t categoryId;
@property (nonatomic, retain, getter=categoryName, setter=setCategoryName:) NSString * categoryName;
@property (nonatomic, retain, getter=categoryLogoURL, setter=setCategoryLogoURL:) NSString * categoryLogoURL;
@property (nonatomic, retain, getter=categoryDescription, setter=setCategoryDescription:) NSString * categoryDescription;
@property (nonatomic, retain, getter=appIds, setter=setAppIds:) NSMutableArray * appIds;
#endif

- (id) init;
- (id) initWithCategoryId: (int32_t) categoryId categoryName: (NSString *) categoryName categoryLogoURL: (NSString *) categoryLogoURL categoryDescription: (NSString *) categoryDescription appIds: (NSMutableArray *) appIds;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) categoryId;
- (void) setCategoryId: (int32_t) categoryId;
#endif
- (BOOL) categoryIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) categoryName;
- (void) setCategoryName: (NSString *) categoryName;
#endif
- (BOOL) categoryNameIsSet;

#if !__has_feature(objc_arc)
- (NSString *) categoryLogoURL;
- (void) setCategoryLogoURL: (NSString *) categoryLogoURL;
#endif
- (BOOL) categoryLogoURLIsSet;

#if !__has_feature(objc_arc)
- (NSString *) categoryDescription;
- (void) setCategoryDescription: (NSString *) categoryDescription;
#endif
- (BOOL) categoryDescriptionIsSet;

#if !__has_feature(objc_arc)
- (NSMutableArray *) appIds;
- (void) setAppIds: (NSMutableArray *) appIds;
#endif
- (BOOL) appIdsIsSet;

@end

@interface RecommendedAppsResponse : NSObject <TBase, NSCoding> {
  int __status;
  NSMutableArray * __categories;
  NSMutableDictionary * __apps;

  BOOL __status_isset;
  BOOL __categories_isset;
  BOOL __apps_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int status;
@property (nonatomic, retain, getter=categories, setter=setCategories:) NSMutableArray * categories;
@property (nonatomic, retain, getter=apps, setter=setApps:) NSMutableDictionary * apps;
#endif

- (id) init;
- (id) initWithStatus: (int) status categories: (NSMutableArray *) categories apps: (NSMutableDictionary *) apps;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int) status;
- (void) setStatus: (int) status;
#endif
- (BOOL) statusIsSet;

#if !__has_feature(objc_arc)
- (NSMutableArray *) categories;
- (void) setCategories: (NSMutableArray *) categories;
#endif
- (BOOL) categoriesIsSet;

#if !__has_feature(objc_arc)
- (NSMutableDictionary *) apps;
- (void) setApps: (NSMutableDictionary *) apps;
#endif
- (BOOL) appsIsSet;

@end

@interface RecommendedAppsRequest : NSObject <TBase, NSCoding> {
  NSString * __language;

  BOOL __language_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=language, setter=setLanguage:) NSString * language;
#endif

- (id) init;
- (id) initWithLanguage: (NSString *) language;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) language;
- (void) setLanguage: (NSString *) language;
#endif
- (BOOL) languageIsSet;

@end

@protocol RecommendedAppsService <NSObject>
- (RecommendedAppsResponse *) getRecommendedApps: (RecommendedAppsRequest *) request;  // throws TException
@end

@interface RecommendedAppsServiceClient : NSObject <RecommendedAppsService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface RecommendedAppsServiceProcessor : NSObject <TProcessor> {
  id <RecommendedAppsService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithRecommendedAppsService: (id <RecommendedAppsService>) service;
- (id<RecommendedAppsService>) service;
@end

@interface recommendedappsConstants : NSObject {
}
@end
