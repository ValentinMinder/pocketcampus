/**
 * Autogenerated by Thrift Compiler (0.9.2)
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


enum AuthStatusCode {
  AuthStatusCode_OK = 200,
  AuthStatusCode_NETWORK_ERROR = 404,
  AuthStatusCode_INVALID_SESSION = 407,
  AuthStatusCode_SERVER_ERROR = 500
};

@interface AuthTokenResponse : NSObject <TBase, NSCoding> {
  NSString * __tequilaToken;
  int __statusCode;

  BOOL __tequilaToken_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=tequilaToken, setter=setTequilaToken:) NSString * tequilaToken;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) init;
- (id) initWithTequilaToken: (NSString *) tequilaToken statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) tequilaToken;
- (void) setTequilaToken: (NSString *) tequilaToken;
#endif
- (BOOL) tequilaTokenIsSet;

#if !__has_feature(objc_arc)
- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
#endif
- (BOOL) statusCodeIsSet;

@end

@interface AuthSessionResponse : NSObject <TBase, NSCoding> {
  NSString * __sessionId;
  int __statusCode;

  BOOL __sessionId_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) init;
- (id) initWithSessionId: (NSString *) sessionId statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
#endif
- (BOOL) sessionIdIsSet;

#if !__has_feature(objc_arc)
- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
#endif
- (BOOL) statusCodeIsSet;

@end

@interface AuthSessionRequest : NSObject <TBase, NSCoding> {
  NSString * __tequilaToken;
  BOOL __rememberMe;

  BOOL __tequilaToken_isset;
  BOOL __rememberMe_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=tequilaToken, setter=setTequilaToken:) NSString * tequilaToken;
@property (nonatomic, getter=rememberMe, setter=setRememberMe:) BOOL rememberMe;
#endif

- (id) init;
- (id) initWithTequilaToken: (NSString *) tequilaToken rememberMe: (BOOL) rememberMe;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) tequilaToken;
- (void) setTequilaToken: (NSString *) tequilaToken;
#endif
- (BOOL) tequilaTokenIsSet;

#if !__has_feature(objc_arc)
- (BOOL) rememberMe;
- (void) setRememberMe: (BOOL) rememberMe;
#endif
- (BOOL) rememberMeIsSet;

@end

@interface LogoutResponse : NSObject <TBase, NSCoding> {
  int __statusCode;
  int32_t __deletedSessionsCount;

  BOOL __statusCode_isset;
  BOOL __deletedSessionsCount_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
@property (nonatomic, getter=deletedSessionsCount, setter=setDeletedSessionsCount:) int32_t deletedSessionsCount;
#endif

- (id) init;
- (id) initWithStatusCode: (int) statusCode deletedSessionsCount: (int32_t) deletedSessionsCount;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
#endif
- (BOOL) statusCodeIsSet;

#if !__has_feature(objc_arc)
- (int32_t) deletedSessionsCount;
- (void) setDeletedSessionsCount: (int32_t) deletedSessionsCount;
#endif
- (BOOL) deletedSessionsCountIsSet;

@end

@interface LogoutRequest : NSObject <TBase, NSCoding> {
  NSString * __sessionId;

  BOOL __sessionId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
#endif

- (id) init;
- (id) initWithSessionId: (NSString *) sessionId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
#endif
- (BOOL) sessionIdIsSet;

@end

@interface UserAttributesResponse : NSObject <TBase, NSCoding> {
  NSMutableArray * __userAttributes;
  int __statusCode;

  BOOL __userAttributes_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=userAttributes, setter=setUserAttributes:) NSMutableArray * userAttributes;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) init;
- (id) initWithUserAttributes: (NSMutableArray *) userAttributes statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSMutableArray *) userAttributes;
- (void) setUserAttributes: (NSMutableArray *) userAttributes;
#endif
- (BOOL) userAttributesIsSet;

#if !__has_feature(objc_arc)
- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
#endif
- (BOOL) statusCodeIsSet;

@end

@interface UserAttributesRequest : NSObject <TBase, NSCoding> {
  NSString * __sessionId;
  NSMutableArray * __attributeNames;

  BOOL __sessionId_isset;
  BOOL __attributeNames_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
@property (nonatomic, retain, getter=attributeNames, setter=setAttributeNames:) NSMutableArray * attributeNames;
#endif

- (id) init;
- (id) initWithSessionId: (NSString *) sessionId attributeNames: (NSMutableArray *) attributeNames;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
#endif
- (BOOL) sessionIdIsSet;

#if !__has_feature(objc_arc)
- (NSMutableArray *) attributeNames;
- (void) setAttributeNames: (NSMutableArray *) attributeNames;
#endif
- (BOOL) attributeNamesIsSet;

@end

@protocol AuthenticationService <NSObject>
- (AuthTokenResponse *) getAuthTequilaToken;  // throws TException
- (AuthSessionResponse *) getAuthSession: (AuthSessionRequest *) req;  // throws TException
- (LogoutResponse *) destroyAllUserSessions: (LogoutRequest *) req;  // throws TException
- (UserAttributesResponse *) getUserAttributes: (UserAttributesRequest *) req;  // throws TException
- (AuthSessionResponse *) getAuthSessionId: (NSString *) tequilaToken;  // throws TException
@end

@interface AuthenticationServiceClient : NSObject <AuthenticationService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface AuthenticationServiceProcessor : NSObject <TProcessor> {
  id <AuthenticationService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithAuthenticationService: (id <AuthenticationService>) service;
- (id<AuthenticationService>) service;
@end

@interface authenticationConstants : NSObject {
}
@end
