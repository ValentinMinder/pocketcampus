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


enum CloudPrintStatusCode {
  CloudPrintStatusCode_OK = 200,
  CloudPrintStatusCode_AUTHENTICATION_ERROR = 407,
  CloudPrintStatusCode_PRINT_ERROR = 404
};

enum CloudPrintNbPagesPerSheet {
  CloudPrintNbPagesPerSheet_TWO = 2,
  CloudPrintNbPagesPerSheet_FOUR = 4,
  CloudPrintNbPagesPerSheet_SIX = 6,
  CloudPrintNbPagesPerSheet_NINE = 9,
  CloudPrintNbPagesPerSheet_SIXTEEN = 16
};

enum CloudPrintMultiPageLayout {
  CloudPrintMultiPageLayout_LEFT_TO_RIGHT_TOP_TO_BOTTOM = 0,
  CloudPrintMultiPageLayout_TOP_TO_BOTTOM_LEFT_TO_RIGHT = 1,
  CloudPrintMultiPageLayout_BOTTOM_TO_TOP_LEFT_TO_RIGHT = 2,
  CloudPrintMultiPageLayout_BOTTOM_TO_TOP_RIGHT_TO_LEFT = 3,
  CloudPrintMultiPageLayout_LEFT_TO_RIGHT_BOTTOM_TO_TOP = 4,
  CloudPrintMultiPageLayout_RIGHT_TO_LEFT_BOTTOM_TO_TOP = 5,
  CloudPrintMultiPageLayout_RIGHT_TO_LEFT_TOP_TO_BOTTOM = 6,
  CloudPrintMultiPageLayout_TOP_TO_BOTTOM_RIGHT_TO_LEFT = 7
};

enum CloudPrintDoubleSidedConfig {
  CloudPrintDoubleSidedConfig_LONG_EDGE = 1,
  CloudPrintDoubleSidedConfig_SHORT_EDGE = 2
};

@interface CloudPrintMultiPageConfig : NSObject <NSCoding> {
  int __nbPagesPerSheet;
  int __layout;

  BOOL __nbPagesPerSheet_isset;
  BOOL __layout_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=nbPagesPerSheet, setter=setNbPagesPerSheet:) int nbPagesPerSheet;
@property (nonatomic, getter=layout, setter=setLayout:) int layout;
#endif

- (id) initWithNbPagesPerSheet: (int) nbPagesPerSheet layout: (int) layout;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int) nbPagesPerSheet;
- (void) setNbPagesPerSheet: (int) nbPagesPerSheet;
- (BOOL) nbPagesPerSheetIsSet;

- (int) layout;
- (void) setLayout: (int) layout;
- (BOOL) layoutIsSet;

@end

@interface CloudPrintPageRange : NSObject <NSCoding> {
  int32_t __pageFrom;
  int32_t __pageTo;

  BOOL __pageFrom_isset;
  BOOL __pageTo_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=pageFrom, setter=setPageFrom:) int32_t pageFrom;
@property (nonatomic, getter=pageTo, setter=setPageTo:) int32_t pageTo;
#endif

- (id) initWithPageFrom: (int32_t) pageFrom pageTo: (int32_t) pageTo;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) pageFrom;
- (void) setPageFrom: (int32_t) pageFrom;
- (BOOL) pageFromIsSet;

- (int32_t) pageTo;
- (void) setPageTo: (int32_t) pageTo;
- (BOOL) pageToIsSet;

@end

@interface PrintDocumentRequest : NSObject <NSCoding> {
  int64_t __documentId;
  BOOL __blackAndWhite;
  int32_t __numberOfCopies;
  CloudPrintPageRange * __pageSelection;
  CloudPrintMultiPageConfig * __multiPageConfig;
  int __doubleSided;

  BOOL __documentId_isset;
  BOOL __blackAndWhite_isset;
  BOOL __numberOfCopies_isset;
  BOOL __pageSelection_isset;
  BOOL __multiPageConfig_isset;
  BOOL __doubleSided_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=documentId, setter=setDocumentId:) int64_t documentId;
@property (nonatomic, getter=blackAndWhite, setter=setBlackAndWhite:) BOOL blackAndWhite;
@property (nonatomic, getter=numberOfCopies, setter=setNumberOfCopies:) int32_t numberOfCopies;
@property (nonatomic, retain, getter=pageSelection, setter=setPageSelection:) CloudPrintPageRange * pageSelection;
@property (nonatomic, retain, getter=multiPageConfig, setter=setMultiPageConfig:) CloudPrintMultiPageConfig * multiPageConfig;
@property (nonatomic, getter=doubleSided, setter=setDoubleSided:) int doubleSided;
#endif

- (id) initWithDocumentId: (int64_t) documentId blackAndWhite: (BOOL) blackAndWhite numberOfCopies: (int32_t) numberOfCopies pageSelection: (CloudPrintPageRange *) pageSelection multiPageConfig: (CloudPrintMultiPageConfig *) multiPageConfig doubleSided: (int) doubleSided;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) documentId;
- (void) setDocumentId: (int64_t) documentId;
- (BOOL) documentIdIsSet;

- (BOOL) blackAndWhite;
- (void) setBlackAndWhite: (BOOL) blackAndWhite;
- (BOOL) blackAndWhiteIsSet;

- (int32_t) numberOfCopies;
- (void) setNumberOfCopies: (int32_t) numberOfCopies;
- (BOOL) numberOfCopiesIsSet;

- (CloudPrintPageRange *) pageSelection;
- (void) setPageSelection: (CloudPrintPageRange *) pageSelection;
- (BOOL) pageSelectionIsSet;

- (CloudPrintMultiPageConfig *) multiPageConfig;
- (void) setMultiPageConfig: (CloudPrintMultiPageConfig *) multiPageConfig;
- (BOOL) multiPageConfigIsSet;

- (int) doubleSided;
- (void) setDoubleSided: (int) doubleSided;
- (BOOL) doubleSidedIsSet;

@end

@interface PrintDocumentResponse : NSObject <NSCoding> {
  int __statusCode;

  BOOL __statusCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=statusCode, setter=setStatusCode:) int statusCode;
#endif

- (id) initWithStatusCode: (int) statusCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int) statusCode;
- (void) setStatusCode: (int) statusCode;
- (BOOL) statusCodeIsSet;

@end

@protocol CloudPrintService <NSObject>
- (PrintDocumentResponse *) printDocument: (PrintDocumentRequest *) request;  // throws TException
@end

@interface CloudPrintServiceClient : NSObject <CloudPrintService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface CloudPrintServiceProcessor : NSObject <TProcessor> {
  id <CloudPrintService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithCloudPrintService: (id <CloudPrintService>) service;
- (id<CloudPrintService>) service;
@end

@interface cloudprintConstants : NSObject {
}
@end
