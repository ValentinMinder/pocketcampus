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


#import "pushnotif.h"


@implementation pushnotifConstants
+ (void) initialize {
}
@end

@interface deleteMapping_args : NSObject <TBase, NSCoding> {
  NSString * __dummy;

  BOOL __dummy_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=dummy, setter=setDummy:) NSString * dummy;
#endif

- (id) init;
- (id) initWithDummy: (NSString *) dummy;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) dummy;
- (void) setDummy: (NSString *) dummy;
#endif
- (BOOL) dummyIsSet;

@end

@implementation deleteMapping_args

- (id) init
{
  self = [super init];
#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
#endif
  return self;
}

- (id) initWithDummy: (NSString *) dummy
{
  self = [super init];
  __dummy = [dummy retain_stub];
  __dummy_isset = YES;
  return self;
}

- (id) initWithCoder: (NSCoder *) decoder
{
  self = [super init];
  if ([decoder containsValueForKey: @"dummy"])
  {
    __dummy = [[decoder decodeObjectForKey: @"dummy"] retain_stub];
    __dummy_isset = YES;
  }
  return self;
}

- (void) encodeWithCoder: (NSCoder *) encoder
{
  if (__dummy_isset)
  {
    [encoder encodeObject: __dummy forKey: @"dummy"];
  }
}

- (void) dealloc
{
  [__dummy release_stub];
  [super dealloc_stub];
}

- (NSString *) dummy {
  return [[__dummy retain_stub] autorelease_stub];
}

- (void) setDummy: (NSString *) dummy {
  [dummy retain_stub];
  [__dummy release_stub];
  __dummy = dummy;
  __dummy_isset = YES;
}

- (BOOL) dummyIsSet {
  return __dummy_isset;
}

- (void) unsetDummy {
  [__dummy release_stub];
  __dummy = nil;
  __dummy_isset = NO;
}

- (void) read: (id <TProtocol>) inProtocol
{
  NSString * fieldName;
  int fieldType;
  int fieldID;

  [inProtocol readStructBeginReturningName: NULL];
  while (true)
  {
    [inProtocol readFieldBeginReturningName: &fieldName type: &fieldType fieldID: &fieldID];
    if (fieldType == TType_STOP) { 
      break;
    }
    switch (fieldID)
    {
      case 1:
        if (fieldType == TType_STRING) {
          NSString * fieldValue = [inProtocol readString];
          [self setDummy: fieldValue];
        } else { 
          [TProtocolUtil skipType: fieldType onProtocol: inProtocol];
        }
        break;
      default:
        [TProtocolUtil skipType: fieldType onProtocol: inProtocol];
        break;
    }
    [inProtocol readFieldEnd];
  }
  [inProtocol readStructEnd];
  [self validate];
}

- (void) write: (id <TProtocol>) outProtocol {
  [outProtocol writeStructBeginWithName: @"deleteMapping_args"];
  if (__dummy_isset) {
    if (__dummy != nil) {
      [outProtocol writeFieldBeginWithName: @"dummy" type: TType_STRING fieldID: 1];
      [outProtocol writeString: __dummy];
      [outProtocol writeFieldEnd];
    }
  }
  [outProtocol writeFieldStop];
  [outProtocol writeStructEnd];
}

- (void) validate {
  // check for required fields
}

- (NSString *) description {
  NSMutableString * ms = [NSMutableString stringWithString: @"deleteMapping_args("];
  [ms appendString: @"dummy:"];
  [ms appendFormat: @"\"%@\"", __dummy];
  [ms appendString: @")"];
  return [NSString stringWithString: ms];
}

@end

@interface DeleteMapping_result : NSObject <TBase, NSCoding> {
  int32_t __success;

  BOOL __success_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=success, setter=setSuccess:) int32_t success;
#endif

- (id) init;
- (id) initWithSuccess: (int32_t) success;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) success;
- (void) setSuccess: (int32_t) success;
#endif
- (BOOL) successIsSet;

@end

@implementation DeleteMapping_result

- (id) init
{
  self = [super init];
#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
#endif
  return self;
}

- (id) initWithSuccess: (int32_t) success
{
  self = [super init];
  __success = success;
  __success_isset = YES;
  return self;
}

- (id) initWithCoder: (NSCoder *) decoder
{
  self = [super init];
  if ([decoder containsValueForKey: @"success"])
  {
    __success = [decoder decodeInt32ForKey: @"success"];
    __success_isset = YES;
  }
  return self;
}

- (void) encodeWithCoder: (NSCoder *) encoder
{
  if (__success_isset)
  {
    [encoder encodeInt32: __success forKey: @"success"];
  }
}

- (void) dealloc
{
  [super dealloc_stub];
}

- (int32_t) success {
  return __success;
}

- (void) setSuccess: (int32_t) success {
  __success = success;
  __success_isset = YES;
}

- (BOOL) successIsSet {
  return __success_isset;
}

- (void) unsetSuccess {
  __success_isset = NO;
}

- (void) read: (id <TProtocol>) inProtocol
{
  NSString * fieldName;
  int fieldType;
  int fieldID;

  [inProtocol readStructBeginReturningName: NULL];
  while (true)
  {
    [inProtocol readFieldBeginReturningName: &fieldName type: &fieldType fieldID: &fieldID];
    if (fieldType == TType_STOP) { 
      break;
    }
    switch (fieldID)
    {
      case 0:
        if (fieldType == TType_I32) {
          int32_t fieldValue = [inProtocol readI32];
          [self setSuccess: fieldValue];
        } else { 
          [TProtocolUtil skipType: fieldType onProtocol: inProtocol];
        }
        break;
      default:
        [TProtocolUtil skipType: fieldType onProtocol: inProtocol];
        break;
    }
    [inProtocol readFieldEnd];
  }
  [inProtocol readStructEnd];
  [self validate];
}

- (void) write: (id <TProtocol>) outProtocol {
  [outProtocol writeStructBeginWithName: @"DeleteMapping_result"];

  if (__success_isset) {
    [outProtocol writeFieldBeginWithName: @"success" type: TType_I32 fieldID: 0];
    [outProtocol writeI32: __success];
    [outProtocol writeFieldEnd];
  }
  [outProtocol writeFieldStop];
  [outProtocol writeStructEnd];
}

- (void) validate {
  // check for required fields
}

- (NSString *) description {
  NSMutableString * ms = [NSMutableString stringWithString: @"DeleteMapping_result("];
  [ms appendString: @"success:"];
  [ms appendFormat: @"%i", __success];
  [ms appendString: @")"];
  return [NSString stringWithString: ms];
}

@end

@implementation PushNotifServiceClient
- (id) initWithProtocol: (id <TProtocol>) protocol
{
  return [self initWithInProtocol: protocol outProtocol: protocol];
}

- (id) initWithInProtocol: (id <TProtocol>) anInProtocol outProtocol: (id <TProtocol>) anOutProtocol
{
  self = [super init];
  inProtocol = [anInProtocol retain_stub];
  outProtocol = [anOutProtocol retain_stub];
  return self;
}

- (void) dealloc
{
  [inProtocol release_stub];
  [outProtocol release_stub];
  [super dealloc_stub];
}

- (void) send_deleteMapping: (NSString *) dummy
{
  [outProtocol writeMessageBeginWithName: @"deleteMapping" type: TMessageType_CALL sequenceID: 0];
  [outProtocol writeStructBeginWithName: @"deleteMapping_args"];
  if (dummy != nil)  {
    [outProtocol writeFieldBeginWithName: @"dummy" type: TType_STRING fieldID: 1];
    [outProtocol writeString: dummy];
    [outProtocol writeFieldEnd];
  }
  [outProtocol writeFieldStop];
  [outProtocol writeStructEnd];
  [outProtocol writeMessageEnd];
  [[outProtocol transport] flush];
}

- (int32_t) recv_deleteMapping
{
  int msgType = 0;
  [inProtocol readMessageBeginReturningName: nil type: &msgType sequenceID: NULL];
  if (msgType == TMessageType_EXCEPTION) {
    TApplicationException * x = [TApplicationException read: inProtocol];
    [inProtocol readMessageEnd];
    @throw x;
  }
  DeleteMapping_result * result = [[[DeleteMapping_result alloc] init] autorelease_stub];
  [result read: inProtocol];
  [inProtocol readMessageEnd];
  if ([result successIsSet]) {
    return [result success];
  }
  @throw [TApplicationException exceptionWithType: TApplicationException_MISSING_RESULT
                                           reason: @"deleteMapping failed: unknown result"];
}

- (int32_t) deleteMapping: (NSString *) dummy
{
  [self send_deleteMapping : dummy];
  return [self recv_deleteMapping];
}

@end

@implementation PushNotifServiceProcessor

- (id) initWithPushNotifService: (id <PushNotifService>) service
{
  self = [super init];
  if (!self) {
    return nil;
  }
  mService = [service retain_stub];
  mMethodMap = [[NSMutableDictionary dictionary] retain_stub];
  {
    SEL s = @selector(process_deleteMapping_withSequenceID:inProtocol:outProtocol:);
    NSMethodSignature * sig = [self methodSignatureForSelector: s];
    NSInvocation * invocation = [NSInvocation invocationWithMethodSignature: sig];
    [invocation setSelector: s];
    [invocation retainArguments];
    [mMethodMap setValue: invocation forKey: @"deleteMapping"];
  }
  return self;
}

- (id<PushNotifService>) service
{
  return [[mService retain_stub] autorelease_stub];
}

- (BOOL) processOnInputProtocol: (id <TProtocol>) inProtocol
                 outputProtocol: (id <TProtocol>) outProtocol
{
  NSString * messageName;
  int messageType;
  int seqID;
  [inProtocol readMessageBeginReturningName: &messageName
                                       type: &messageType
                                 sequenceID: &seqID];
  NSInvocation * invocation = [mMethodMap valueForKey: messageName];
  if (invocation == nil) {
    [TProtocolUtil skipType: TType_STRUCT onProtocol: inProtocol];
    [inProtocol readMessageEnd];
    TApplicationException * x = [TApplicationException exceptionWithType: TApplicationException_UNKNOWN_METHOD reason: [NSString stringWithFormat: @"Invalid method name: '%@'", messageName]];
    [outProtocol writeMessageBeginWithName: messageName
                                      type: TMessageType_EXCEPTION
                                sequenceID: seqID];
    [x write: outProtocol];
    [outProtocol writeMessageEnd];
    [[outProtocol transport] flush];
    return YES;
  }
  // NSInvocation does not conform to NSCopying protocol
  NSInvocation * i = [NSInvocation invocationWithMethodSignature: [invocation methodSignature]];
  [i setSelector: [invocation selector]];
  [i setArgument: &seqID atIndex: 2];
  [i setArgument: &inProtocol atIndex: 3];
  [i setArgument: &outProtocol atIndex: 4];
  [i setTarget: self];
  [i invoke];
  return YES;
}

- (void) process_deleteMapping_withSequenceID: (int32_t) seqID inProtocol: (id<TProtocol>) inProtocol outProtocol: (id<TProtocol>) outProtocol
{
  deleteMapping_args * args = [[deleteMapping_args alloc] init];
  [args read: inProtocol];
  [inProtocol readMessageEnd];
  DeleteMapping_result * result = [[DeleteMapping_result alloc] init];
  [result setSuccess: [mService deleteMapping: [args dummy]]];
  [outProtocol writeMessageBeginWithName: @"deleteMapping"
                                    type: TMessageType_REPLY
                              sequenceID: seqID];
  [result write: outProtocol];
  [outProtocol writeMessageEnd];
  [[outProtocol transport] flush];
  [result release_stub];
  [args release_stub];
}

- (void) dealloc
{
  [mService release_stub];
  [mMethodMap release_stub];
  [super dealloc_stub];
}

@end

