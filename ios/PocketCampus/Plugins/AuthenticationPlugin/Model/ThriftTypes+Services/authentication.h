/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */

#import <Foundation/Foundation.h>

#import <TProtocol.h>
#import <TApplicationException.h>
#import <TProtocolUtil.h>
#import <TProcessor.h>


enum AuthStatusCode {
  AuthStatusCode_OK = 200,
  AuthStatusCode_NETWORK_ERROR = 404,
  AuthStatusCode_INVALID_SESSION = 407,
  AuthStatusCode_SERVER_ERROR = 500
};

@interface AuthTokenResponse : NSObject <NSCoding> {
  NSString * __tequilaToken;
  int __statusCode;

  BOOL __tequilaToken_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=tequilaToken, setter=setTequilaToken:) NSString * tequilaToken;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) initWithTequilaToken: (NSString *) tequilaToken statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) tequilaToken;
- (void) setTequilaToken: (NSString *) tequilaToken;
- (BOOL) tequilaTokenIsSet;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

@end

@interface AuthSessionResponse : NSObject <NSCoding> {
  NSString * __sessionId;
  int __statusCode;

  BOOL __sessionId_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) initWithSessionId: (NSString *) sessionId statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
- (BOOL) sessionIdIsSet;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

@end

@interface AuthSessionRequest : NSObject <NSCoding> {
  NSString * __tequilaToken;
  BOOL __rememberMe;

  BOOL __tequilaToken_isset;
  BOOL __rememberMe_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=tequilaToken, setter=setTequilaToken:) NSString * tequilaToken;
@property (nonatomic, getter=rememberMe, setter=setRememberMe:) BOOL rememberMe;
#endif

- (id) initWithTequilaToken: (NSString *) tequilaToken rememberMe: (BOOL) rememberMe;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) tequilaToken;
- (void) setTequilaToken: (NSString *) tequilaToken;
- (BOOL) tequilaTokenIsSet;

- (BOOL) rememberMe;
- (void) setRememberMe: (BOOL) rememberMe;
- (BOOL) rememberMeIsSet;

@end

@interface LogoutResponse : NSObject <NSCoding> {
  int __statusCode;
  int32_t __deletedSessionsCount;

  BOOL __statusCode_isset;
  BOOL __deletedSessionsCount_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
@property (nonatomic, getter=deletedSessionsCount, setter=setDeletedSessionsCount:) int32_t deletedSessionsCount;
#endif

- (id) initWithStatusCode: (int) statusCode deletedSessionsCount: (int32_t) deletedSessionsCount;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

- (int32_t) deletedSessionsCount;
- (void) setDeletedSessionsCount: (int32_t) deletedSessionsCount;
- (BOOL) deletedSessionsCountIsSet;

@end

@interface LogoutRequest : NSObject <NSCoding> {
  NSString * __sessionId;

  BOOL __sessionId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
#endif

- (id) initWithSessionId: (NSString *) sessionId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
- (BOOL) sessionIdIsSet;

@end

@interface UserAttributesResponse : NSObject <NSCoding> {
  NSArray * __userAttributes;
  int __statusCode;

  BOOL __userAttributes_isset;
  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=userAttributes, setter=setUserAttributes:) NSArray * userAttributes;
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) initWithUserAttributes: (NSArray *) userAttributes statusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSArray *) userAttributes;
- (void) setUserAttributes: (NSArray *) userAttributes;
- (BOOL) userAttributesIsSet;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

@end

@interface UserAttributesRequest : NSObject <NSCoding> {
  NSString * __sessionId;
  NSArray * __attributeNames;

  BOOL __sessionId_isset;
  BOOL __attributeNames_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=sessionId, setter=setSessionId:) NSString * sessionId;
@property (nonatomic, retain, getter=attributeNames, setter=setAttributeNames:) NSArray * attributeNames;
#endif

- (id) initWithSessionId: (NSString *) sessionId attributeNames: (NSArray *) attributeNames;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) sessionId;
- (void) setSessionId: (NSString *) sessionId;
- (BOOL) sessionIdIsSet;

- (NSArray *) attributeNames;
- (void) setAttributeNames: (NSArray *) attributeNames;
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
