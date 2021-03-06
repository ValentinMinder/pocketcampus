/*
 * Copyright (c) 2014, PocketCampus.Org
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 	* Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 	* Redistributions in binary form must reproduce the above copyright
 * 	  notice, this list of conditions and the following disclaimer in the
 * 	  documentation and/or other materials provided with the distribution.
 * 	* Neither the name of PocketCampus.Org nor the
 * 	  names of its contributors may be used to endorse or promote products
 * 	  derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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


enum EventsCategories {
  EventsCategories_ALL = 0,
  EventsCategories_CONF_SEMINAR = 1,
  EventsCategories_MEET_MGMT_TIPS = 2,
  EventsCategories_MISC = 4,
  EventsCategories_EXHIBIT = 5,
  EventsCategories_MOVIES = 6,
  EventsCategories_CELEB = 7,
  EventsCategories_INAUG_HONOR = 8,
  EventsCategories_CULTURAL = 9,
  EventsCategories_SPORT = 10,
  EventsCategories_DATING_EPFL_ECONOMY = 11,
  EventsCategories_THESIS_DEFENSE = 12,
  EventsCategories_ACADEMIC_CAL = 13
};

enum EventsTags {
  EventsTags_EPFL = 0,
  EventsTags_ENAC = 1,
  EventsTags_SB = 2,
  EventsTags_STI = 3,
  EventsTags_IC = 4,
  EventsTags_SV = 5,
  EventsTags_CDM = 6,
  EventsTags_CDH = 7,
  EventsTags_ACADEMIC_CALENDAR = 8,
  EventsTags_ASSOCIATIONS = 9
};

enum EventsPeriods {
  EventsPeriods_ONE_DAY = 1,
  EventsPeriods_TWO_DAYS = 2,
  EventsPeriods_ONE_WEEK = 7,
  EventsPeriods_TWO_WEEKS = 14,
  EventsPeriods_ONE_MONTH = 30,
  EventsPeriods_SIX_MONTHS = 180,
  EventsPeriods_ONE_YEAR = 365
};

@interface EventItem : NSObject <NSCoding> {
  int64_t __eventId;
  int64_t __startDate;
  int64_t __endDate;
  BOOL __fullDay;
  NSString * __eventPicture;
  NSString * __eventTitle;
  NSString * __eventPlace;
  NSString * __eventSpeaker;
  NSString * __eventDetails;
  NSString * __eventThumbnail;
  NSString * __eventUri;
  NSString * __vcalUid;
  NSString * __locationHref;
  NSString * __detailsLink;
  NSString * __secondLine;
  NSString * __timeSnippet;
  BOOL __hideTitle;
  BOOL __hideThumbnail;
  BOOL __hideEventInfo;
  int32_t __eventCateg;
  NSArray * __eventTags;
  NSArray * __childrenPools;
  int64_t __parentPool;

  BOOL __eventId_isset;
  BOOL __startDate_isset;
  BOOL __endDate_isset;
  BOOL __fullDay_isset;
  BOOL __eventPicture_isset;
  BOOL __eventTitle_isset;
  BOOL __eventPlace_isset;
  BOOL __eventSpeaker_isset;
  BOOL __eventDetails_isset;
  BOOL __eventThumbnail_isset;
  BOOL __eventUri_isset;
  BOOL __vcalUid_isset;
  BOOL __locationHref_isset;
  BOOL __detailsLink_isset;
  BOOL __secondLine_isset;
  BOOL __timeSnippet_isset;
  BOOL __hideTitle_isset;
  BOOL __hideThumbnail_isset;
  BOOL __hideEventInfo_isset;
  BOOL __eventCateg_isset;
  BOOL __eventTags_isset;
  BOOL __childrenPools_isset;
  BOOL __parentPool_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=eventId, setter=setEventId:) int64_t eventId;
@property (nonatomic, getter=startDate, setter=setStartDate:) int64_t startDate;
@property (nonatomic, getter=endDate, setter=setEndDate:) int64_t endDate;
@property (nonatomic, getter=fullDay, setter=setFullDay:) BOOL fullDay;
@property (nonatomic, retain, getter=eventPicture, setter=setEventPicture:) NSString * eventPicture;
@property (nonatomic, retain, getter=eventTitle, setter=setEventTitle:) NSString * eventTitle;
@property (nonatomic, retain, getter=eventPlace, setter=setEventPlace:) NSString * eventPlace;
@property (nonatomic, retain, getter=eventSpeaker, setter=setEventSpeaker:) NSString * eventSpeaker;
@property (nonatomic, retain, getter=eventDetails, setter=setEventDetails:) NSString * eventDetails;
@property (nonatomic, retain, getter=eventThumbnail, setter=setEventThumbnail:) NSString * eventThumbnail;
@property (nonatomic, retain, getter=eventUri, setter=setEventUri:) NSString * eventUri;
@property (nonatomic, retain, getter=vcalUid, setter=setVcalUid:) NSString * vcalUid;
@property (nonatomic, retain, getter=locationHref, setter=setLocationHref:) NSString * locationHref;
@property (nonatomic, retain, getter=detailsLink, setter=setDetailsLink:) NSString * detailsLink;
@property (nonatomic, retain, getter=secondLine, setter=setSecondLine:) NSString * secondLine;
@property (nonatomic, retain, getter=timeSnippet, setter=setTimeSnippet:) NSString * timeSnippet;
@property (nonatomic, getter=hideTitle, setter=setHideTitle:) BOOL hideTitle;
@property (nonatomic, getter=hideThumbnail, setter=setHideThumbnail:) BOOL hideThumbnail;
@property (nonatomic, getter=hideEventInfo, setter=setHideEventInfo:) BOOL hideEventInfo;
@property (nonatomic, getter=eventCateg, setter=setEventCateg:) int32_t eventCateg;
@property (nonatomic, retain, getter=eventTags, setter=setEventTags:) NSArray * eventTags;
@property (nonatomic, retain, getter=childrenPools, setter=setChildrenPools:) NSArray * childrenPools;
@property (nonatomic, getter=parentPool, setter=setParentPool:) int64_t parentPool;
#endif

- (id) initWithEventId: (int64_t) eventId startDate: (int64_t) startDate endDate: (int64_t) endDate fullDay: (BOOL) fullDay eventPicture: (NSString *) eventPicture eventTitle: (NSString *) eventTitle eventPlace: (NSString *) eventPlace eventSpeaker: (NSString *) eventSpeaker eventDetails: (NSString *) eventDetails eventThumbnail: (NSString *) eventThumbnail eventUri: (NSString *) eventUri vcalUid: (NSString *) vcalUid locationHref: (NSString *) locationHref detailsLink: (NSString *) detailsLink secondLine: (NSString *) secondLine timeSnippet: (NSString *) timeSnippet hideTitle: (BOOL) hideTitle hideThumbnail: (BOOL) hideThumbnail hideEventInfo: (BOOL) hideEventInfo eventCateg: (int32_t) eventCateg eventTags: (NSArray *) eventTags childrenPools: (NSArray *) childrenPools parentPool: (int64_t) parentPool;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) eventId;
- (void) setEventId: (int64_t) eventId;
- (BOOL) eventIdIsSet;

- (int64_t) startDate;
- (void) setStartDate: (int64_t) startDate;
- (BOOL) startDateIsSet;

- (int64_t) endDate;
- (void) setEndDate: (int64_t) endDate;
- (BOOL) endDateIsSet;

- (BOOL) fullDay;
- (void) setFullDay: (BOOL) fullDay;
- (BOOL) fullDayIsSet;

- (NSString *) eventPicture;
- (void) setEventPicture: (NSString *) eventPicture;
- (BOOL) eventPictureIsSet;

- (NSString *) eventTitle;
- (void) setEventTitle: (NSString *) eventTitle;
- (BOOL) eventTitleIsSet;

- (NSString *) eventPlace;
- (void) setEventPlace: (NSString *) eventPlace;
- (BOOL) eventPlaceIsSet;

- (NSString *) eventSpeaker;
- (void) setEventSpeaker: (NSString *) eventSpeaker;
- (BOOL) eventSpeakerIsSet;

- (NSString *) eventDetails;
- (void) setEventDetails: (NSString *) eventDetails;
- (BOOL) eventDetailsIsSet;

- (NSString *) eventThumbnail;
- (void) setEventThumbnail: (NSString *) eventThumbnail;
- (BOOL) eventThumbnailIsSet;

- (NSString *) eventUri;
- (void) setEventUri: (NSString *) eventUri;
- (BOOL) eventUriIsSet;

- (NSString *) vcalUid;
- (void) setVcalUid: (NSString *) vcalUid;
- (BOOL) vcalUidIsSet;

- (NSString *) locationHref;
- (void) setLocationHref: (NSString *) locationHref;
- (BOOL) locationHrefIsSet;

- (NSString *) detailsLink;
- (void) setDetailsLink: (NSString *) detailsLink;
- (BOOL) detailsLinkIsSet;

- (NSString *) secondLine;
- (void) setSecondLine: (NSString *) secondLine;
- (BOOL) secondLineIsSet;

- (NSString *) timeSnippet;
- (void) setTimeSnippet: (NSString *) timeSnippet;
- (BOOL) timeSnippetIsSet;

- (BOOL) hideTitle;
- (void) setHideTitle: (BOOL) hideTitle;
- (BOOL) hideTitleIsSet;

- (BOOL) hideThumbnail;
- (void) setHideThumbnail: (BOOL) hideThumbnail;
- (BOOL) hideThumbnailIsSet;

- (BOOL) hideEventInfo;
- (void) setHideEventInfo: (BOOL) hideEventInfo;
- (BOOL) hideEventInfoIsSet;

- (int32_t) eventCateg;
- (void) setEventCateg: (int32_t) eventCateg;
- (BOOL) eventCategIsSet;

- (NSArray *) eventTags;
- (void) setEventTags: (NSArray *) eventTags;
- (BOOL) eventTagsIsSet;

- (NSArray *) childrenPools;
- (void) setChildrenPools: (NSArray *) childrenPools;
- (BOOL) childrenPoolsIsSet;

- (int64_t) parentPool;
- (void) setParentPool: (int64_t) parentPool;
- (BOOL) parentPoolIsSet;

@end

@interface EventPool : NSObject <NSCoding> {
  int64_t __poolId;
  NSString * __poolPicture;
  NSString * __poolTitle;
  NSString * __poolPlace;
  NSString * __poolDetails;
  BOOL __disableStar;
  BOOL __disableFilterByCateg;
  BOOL __disableFilterByTags;
  BOOL __enableScan;
  NSString * __noResultText;
  BOOL __refreshOnBack;
  BOOL __sendStarredItems;
  NSString * __overrideLink;
  NSArray * __childrenEvents;
  int64_t __parentEvent;

  BOOL __poolId_isset;
  BOOL __poolPicture_isset;
  BOOL __poolTitle_isset;
  BOOL __poolPlace_isset;
  BOOL __poolDetails_isset;
  BOOL __disableStar_isset;
  BOOL __disableFilterByCateg_isset;
  BOOL __disableFilterByTags_isset;
  BOOL __enableScan_isset;
  BOOL __noResultText_isset;
  BOOL __refreshOnBack_isset;
  BOOL __sendStarredItems_isset;
  BOOL __overrideLink_isset;
  BOOL __childrenEvents_isset;
  BOOL __parentEvent_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=poolId, setter=setPoolId:) int64_t poolId;
@property (nonatomic, retain, getter=poolPicture, setter=setPoolPicture:) NSString * poolPicture;
@property (nonatomic, retain, getter=poolTitle, setter=setPoolTitle:) NSString * poolTitle;
@property (nonatomic, retain, getter=poolPlace, setter=setPoolPlace:) NSString * poolPlace;
@property (nonatomic, retain, getter=poolDetails, setter=setPoolDetails:) NSString * poolDetails;
@property (nonatomic, getter=disableStar, setter=setDisableStar:) BOOL disableStar;
@property (nonatomic, getter=disableFilterByCateg, setter=setDisableFilterByCateg:) BOOL disableFilterByCateg;
@property (nonatomic, getter=disableFilterByTags, setter=setDisableFilterByTags:) BOOL disableFilterByTags;
@property (nonatomic, getter=enableScan, setter=setEnableScan:) BOOL enableScan;
@property (nonatomic, retain, getter=noResultText, setter=setNoResultText:) NSString * noResultText;
@property (nonatomic, getter=refreshOnBack, setter=setRefreshOnBack:) BOOL refreshOnBack;
@property (nonatomic, getter=sendStarredItems, setter=setSendStarredItems:) BOOL sendStarredItems;
@property (nonatomic, retain, getter=overrideLink, setter=setOverrideLink:) NSString * overrideLink;
@property (nonatomic, retain, getter=childrenEvents, setter=setChildrenEvents:) NSArray * childrenEvents;
@property (nonatomic, getter=parentEvent, setter=setParentEvent:) int64_t parentEvent;
#endif

- (id) initWithPoolId: (int64_t) poolId poolPicture: (NSString *) poolPicture poolTitle: (NSString *) poolTitle poolPlace: (NSString *) poolPlace poolDetails: (NSString *) poolDetails disableStar: (BOOL) disableStar disableFilterByCateg: (BOOL) disableFilterByCateg disableFilterByTags: (BOOL) disableFilterByTags enableScan: (BOOL) enableScan noResultText: (NSString *) noResultText refreshOnBack: (BOOL) refreshOnBack sendStarredItems: (BOOL) sendStarredItems overrideLink: (NSString *) overrideLink childrenEvents: (NSArray *) childrenEvents parentEvent: (int64_t) parentEvent;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) poolId;
- (void) setPoolId: (int64_t) poolId;
- (BOOL) poolIdIsSet;

- (NSString *) poolPicture;
- (void) setPoolPicture: (NSString *) poolPicture;
- (BOOL) poolPictureIsSet;

- (NSString *) poolTitle;
- (void) setPoolTitle: (NSString *) poolTitle;
- (BOOL) poolTitleIsSet;

- (NSString *) poolPlace;
- (void) setPoolPlace: (NSString *) poolPlace;
- (BOOL) poolPlaceIsSet;

- (NSString *) poolDetails;
- (void) setPoolDetails: (NSString *) poolDetails;
- (BOOL) poolDetailsIsSet;

- (BOOL) disableStar;
- (void) setDisableStar: (BOOL) disableStar;
- (BOOL) disableStarIsSet;

- (BOOL) disableFilterByCateg;
- (void) setDisableFilterByCateg: (BOOL) disableFilterByCateg;
- (BOOL) disableFilterByCategIsSet;

- (BOOL) disableFilterByTags;
- (void) setDisableFilterByTags: (BOOL) disableFilterByTags;
- (BOOL) disableFilterByTagsIsSet;

- (BOOL) enableScan;
- (void) setEnableScan: (BOOL) enableScan;
- (BOOL) enableScanIsSet;

- (NSString *) noResultText;
- (void) setNoResultText: (NSString *) noResultText;
- (BOOL) noResultTextIsSet;

- (BOOL) refreshOnBack;
- (void) setRefreshOnBack: (BOOL) refreshOnBack;
- (BOOL) refreshOnBackIsSet;

- (BOOL) sendStarredItems;
- (void) setSendStarredItems: (BOOL) sendStarredItems;
- (BOOL) sendStarredItemsIsSet;

- (NSString *) overrideLink;
- (void) setOverrideLink: (NSString *) overrideLink;
- (BOOL) overrideLinkIsSet;

- (NSArray *) childrenEvents;
- (void) setChildrenEvents: (NSArray *) childrenEvents;
- (BOOL) childrenEventsIsSet;

- (int64_t) parentEvent;
- (void) setParentEvent: (int64_t) parentEvent;
- (BOOL) parentEventIsSet;

@end

@interface EventItemRequest : NSObject <NSCoding> {
  int64_t __eventItemId;
  NSString * __userToken;
  NSArray * __userTickets;
  NSString * __lang;

  BOOL __eventItemId_isset;
  BOOL __userToken_isset;
  BOOL __userTickets_isset;
  BOOL __lang_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=eventItemId, setter=setEventItemId:) int64_t eventItemId;
@property (nonatomic, retain, getter=userToken, setter=setUserToken:) NSString * userToken;
@property (nonatomic, retain, getter=userTickets, setter=setUserTickets:) NSArray * userTickets;
@property (nonatomic, retain, getter=lang, setter=setLang:) NSString * lang;
#endif

- (id) initWithEventItemId: (int64_t) eventItemId userToken: (NSString *) userToken userTickets: (NSArray *) userTickets lang: (NSString *) lang;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) eventItemId;
- (void) setEventItemId: (int64_t) eventItemId;
- (BOOL) eventItemIdIsSet;

- (NSString *) userToken;
- (void) setUserToken: (NSString *) userToken;
- (BOOL) userTokenIsSet;

- (NSArray *) userTickets;
- (void) setUserTickets: (NSArray *) userTickets;
- (BOOL) userTicketsIsSet;

- (NSString *) lang;
- (void) setLang: (NSString *) lang;
- (BOOL) langIsSet;

@end

@interface EventPoolRequest : NSObject <NSCoding> {
  int64_t __eventPoolId;
  NSString * __userToken;
  NSArray * __userTickets;
  NSArray * __starredEventItems;
  NSString * __lang;
  int32_t __period;
  int32_t __periodInHours;
  BOOL __fetchPast;

  BOOL __eventPoolId_isset;
  BOOL __userToken_isset;
  BOOL __userTickets_isset;
  BOOL __starredEventItems_isset;
  BOOL __lang_isset;
  BOOL __period_isset;
  BOOL __periodInHours_isset;
  BOOL __fetchPast_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=eventPoolId, setter=setEventPoolId:) int64_t eventPoolId;
@property (nonatomic, retain, getter=userToken, setter=setUserToken:) NSString * userToken;
@property (nonatomic, retain, getter=userTickets, setter=setUserTickets:) NSArray * userTickets;
@property (nonatomic, retain, getter=starredEventItems, setter=setStarredEventItems:) NSArray * starredEventItems;
@property (nonatomic, retain, getter=lang, setter=setLang:) NSString * lang;
@property (nonatomic, getter=period, setter=setPeriod:) int32_t period;
@property (nonatomic, getter=periodInHours, setter=setPeriodInHours:) int32_t periodInHours;
@property (nonatomic, getter=fetchPast, setter=setFetchPast:) BOOL fetchPast;
#endif

- (id) initWithEventPoolId: (int64_t) eventPoolId userToken: (NSString *) userToken userTickets: (NSArray *) userTickets starredEventItems: (NSArray *) starredEventItems lang: (NSString *) lang period: (int32_t) period periodInHours: (int32_t) periodInHours fetchPast: (BOOL) fetchPast;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) eventPoolId;
- (void) setEventPoolId: (int64_t) eventPoolId;
- (BOOL) eventPoolIdIsSet;

- (NSString *) userToken;
- (void) setUserToken: (NSString *) userToken;
- (BOOL) userTokenIsSet;

- (NSArray *) userTickets;
- (void) setUserTickets: (NSArray *) userTickets;
- (BOOL) userTicketsIsSet;

- (NSArray *) starredEventItems;
- (void) setStarredEventItems: (NSArray *) starredEventItems;
- (BOOL) starredEventItemsIsSet;

- (NSString *) lang;
- (void) setLang: (NSString *) lang;
- (BOOL) langIsSet;

- (int32_t) period;
- (void) setPeriod: (int32_t) period;
- (BOOL) periodIsSet;

- (int32_t) periodInHours;
- (void) setPeriodInHours: (int32_t) periodInHours;
- (BOOL) periodInHoursIsSet;

- (BOOL) fetchPast;
- (void) setFetchPast: (BOOL) fetchPast;
- (BOOL) fetchPastIsSet;

@end

@interface EventItemReply : NSObject <NSCoding> {
  int32_t __status;
  EventItem * __eventItem;
  NSDictionary * __childrenPools;
  NSDictionary * __categs;
  NSDictionary * __tags;

  BOOL __status_isset;
  BOOL __eventItem_isset;
  BOOL __childrenPools_isset;
  BOOL __categs_isset;
  BOOL __tags_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int32_t status;
@property (nonatomic, retain, getter=eventItem, setter=setEventItem:) EventItem * eventItem;
@property (nonatomic, retain, getter=childrenPools, setter=setChildrenPools:) NSDictionary * childrenPools;
@property (nonatomic, retain, getter=categs, setter=setCategs:) NSDictionary * categs;
@property (nonatomic, retain, getter=tags, setter=setTags:) NSDictionary * tags;
#endif

- (id) initWithStatus: (int32_t) status eventItem: (EventItem *) eventItem childrenPools: (NSDictionary *) childrenPools categs: (NSDictionary *) categs tags: (NSDictionary *) tags;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) status;
- (void) setStatus: (int32_t) status;
- (BOOL) statusIsSet;

- (EventItem *) eventItem;
- (void) setEventItem: (EventItem *) eventItem;
- (BOOL) eventItemIsSet;

- (NSDictionary *) childrenPools;
- (void) setChildrenPools: (NSDictionary *) childrenPools;
- (BOOL) childrenPoolsIsSet;

- (NSDictionary *) categs;
- (void) setCategs: (NSDictionary *) categs;
- (BOOL) categsIsSet;

- (NSDictionary *) tags;
- (void) setTags: (NSDictionary *) tags;
- (BOOL) tagsIsSet;

@end

@interface EventPoolReply : NSObject <NSCoding> {
  int32_t __status;
  EventPool * __eventPool;
  NSDictionary * __childrenItems;
  NSDictionary * __categs;
  NSDictionary * __tags;

  BOOL __status_isset;
  BOOL __eventPool_isset;
  BOOL __childrenItems_isset;
  BOOL __categs_isset;
  BOOL __tags_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int32_t status;
@property (nonatomic, retain, getter=eventPool, setter=setEventPool:) EventPool * eventPool;
@property (nonatomic, retain, getter=childrenItems, setter=setChildrenItems:) NSDictionary * childrenItems;
@property (nonatomic, retain, getter=categs, setter=setCategs:) NSDictionary * categs;
@property (nonatomic, retain, getter=tags, setter=setTags:) NSDictionary * tags;
#endif

- (id) initWithStatus: (int32_t) status eventPool: (EventPool *) eventPool childrenItems: (NSDictionary *) childrenItems categs: (NSDictionary *) categs tags: (NSDictionary *) tags;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) status;
- (void) setStatus: (int32_t) status;
- (BOOL) statusIsSet;

- (EventPool *) eventPool;
- (void) setEventPool: (EventPool *) eventPool;
- (BOOL) eventPoolIsSet;

- (NSDictionary *) childrenItems;
- (void) setChildrenItems: (NSDictionary *) childrenItems;
- (BOOL) childrenItemsIsSet;

- (NSDictionary *) categs;
- (void) setCategs: (NSDictionary *) categs;
- (BOOL) categsIsSet;

- (NSDictionary *) tags;
- (void) setTags: (NSDictionary *) tags;
- (BOOL) tagsIsSet;

@end

@interface ExchangeRequest : NSObject <NSCoding> {
  NSString * __exchangeToken;
  NSString * __userToken;
  NSArray * __userTickets;

  BOOL __exchangeToken_isset;
  BOOL __userToken_isset;
  BOOL __userTickets_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=exchangeToken, setter=setExchangeToken:) NSString * exchangeToken;
@property (nonatomic, retain, getter=userToken, setter=setUserToken:) NSString * userToken;
@property (nonatomic, retain, getter=userTickets, setter=setUserTickets:) NSArray * userTickets;
#endif

- (id) initWithExchangeToken: (NSString *) exchangeToken userToken: (NSString *) userToken userTickets: (NSArray *) userTickets;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) exchangeToken;
- (void) setExchangeToken: (NSString *) exchangeToken;
- (BOOL) exchangeTokenIsSet;

- (NSString *) userToken;
- (void) setUserToken: (NSString *) userToken;
- (BOOL) userTokenIsSet;

- (NSArray *) userTickets;
- (void) setUserTickets: (NSArray *) userTickets;
- (BOOL) userTicketsIsSet;

@end

@interface ExchangeReply : NSObject <NSCoding> {
  int32_t __status;

  BOOL __status_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int32_t status;
#endif

- (id) initWithStatus: (int32_t) status;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) status;
- (void) setStatus: (int32_t) status;
- (BOOL) statusIsSet;

@end

@interface SendEmailRequest : NSObject <NSCoding> {
  int64_t __eventPoolId;
  NSArray * __starredEventItems;
  NSArray * __userTickets;
  NSString * __emailAddress;
  NSString * __lang;

  BOOL __eventPoolId_isset;
  BOOL __starredEventItems_isset;
  BOOL __userTickets_isset;
  BOOL __emailAddress_isset;
  BOOL __lang_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=eventPoolId, setter=setEventPoolId:) int64_t eventPoolId;
@property (nonatomic, retain, getter=starredEventItems, setter=setStarredEventItems:) NSArray * starredEventItems;
@property (nonatomic, retain, getter=userTickets, setter=setUserTickets:) NSArray * userTickets;
@property (nonatomic, retain, getter=emailAddress, setter=setEmailAddress:) NSString * emailAddress;
@property (nonatomic, retain, getter=lang, setter=setLang:) NSString * lang;
#endif

- (id) initWithEventPoolId: (int64_t) eventPoolId starredEventItems: (NSArray *) starredEventItems userTickets: (NSArray *) userTickets emailAddress: (NSString *) emailAddress lang: (NSString *) lang;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int64_t) eventPoolId;
- (void) setEventPoolId: (int64_t) eventPoolId;
- (BOOL) eventPoolIdIsSet;

- (NSArray *) starredEventItems;
- (void) setStarredEventItems: (NSArray *) starredEventItems;
- (BOOL) starredEventItemsIsSet;

- (NSArray *) userTickets;
- (void) setUserTickets: (NSArray *) userTickets;
- (BOOL) userTicketsIsSet;

- (NSString *) emailAddress;
- (void) setEmailAddress: (NSString *) emailAddress;
- (BOOL) emailAddressIsSet;

- (NSString *) lang;
- (void) setLang: (NSString *) lang;
- (BOOL) langIsSet;

@end

@interface SendEmailReply : NSObject <NSCoding> {
  int32_t __status;

  BOOL __status_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int32_t status;
#endif

- (id) initWithStatus: (int32_t) status;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) status;
- (void) setStatus: (int32_t) status;
- (BOOL) statusIsSet;

@end

@interface AdminSendRegEmailRequest : NSObject <NSCoding> {
  NSString * __templateId;
  NSArray * __sendOnlyTo;

  BOOL __templateId_isset;
  BOOL __sendOnlyTo_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=templateId, setter=setTemplateId:) NSString * templateId;
@property (nonatomic, retain, getter=sendOnlyTo, setter=setSendOnlyTo:) NSArray * sendOnlyTo;
#endif

- (id) initWithTemplateId: (NSString *) templateId sendOnlyTo: (NSArray *) sendOnlyTo;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (NSString *) templateId;
- (void) setTemplateId: (NSString *) templateId;
- (BOOL) templateIdIsSet;

- (NSArray *) sendOnlyTo;
- (void) setSendOnlyTo: (NSArray *) sendOnlyTo;
- (BOOL) sendOnlyToIsSet;

@end

@interface AdminSendRegEmailReply : NSObject <NSCoding> {
  int32_t __status;

  BOOL __status_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=status, setter=setStatus:) int32_t status;
#endif

- (id) initWithStatus: (int32_t) status;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (int32_t) status;
- (void) setStatus: (int32_t) status;
- (BOOL) statusIsSet;

@end

@protocol EventsService <NSObject>
- (EventItemReply *) getEventItem: (EventItemRequest *) iRequest;  // throws TException
- (EventPoolReply *) getEventPool: (EventPoolRequest *) iRequest;  // throws TException
- (ExchangeReply *) exchangeContacts: (ExchangeRequest *) iRequest;  // throws TException
- (SendEmailReply *) sendStarredItemsByEmail: (SendEmailRequest *) iRequest;  // throws TException
- (AdminSendRegEmailReply *) adminSendRegistrationEmail: (AdminSendRegEmailRequest *) iRequest;  // throws TException
@end

@interface EventsServiceClient : NSObject <EventsService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface EventsServiceProcessor : NSObject <TProcessor> {
  id <EventsService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithEventsService: (id <EventsService>) service;
- (id<EventsService>) service;
@end

@interface eventsConstants : NSObject {
}
+ (int64_t) CONTAINER_EVENT_ID;
+ (NSDictionary *) EVENTS_CATEGS;
+ (NSDictionary *) EVENTS_TAGS;
+ (NSDictionary *) EVENTS_PERIODS;
@end
