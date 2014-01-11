//
//  Person+Extras.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 25.09.13.
//  Copyright (c) 2013 EPFL. All rights reserved.
//

#import "Person+Extras.h"

@implementation Person (Extras)

- (NSString*)fullFirstnameLastname {
    return [self firstnameLastnameWithFirstName:self.firstName];
}

- (NSString*)firstnameLastname {
    NSString* firstNameOnly = self.firstName;
    NSArray* elems = [firstNameOnly componentsSeparatedByString:@" "];
    firstNameOnly = [elems firstObject];
    return [self firstnameLastnameWithFirstName:firstNameOnly];
}

- (NSString*)organizationsString {
    NSString* ret __block = @"";
    [self.organisationalUnits enumerateObjectsUsingBlock:^(NSString* unit, NSUInteger index, BOOL *stop) {
        if (index < self.organisationalUnits.count - 1) {
            ret = [ret stringByAppendingFormat:@"%@ ", unit];
        } else {
            ret = [ret stringByAppendingString:unit];
        }
    }];
    return ret;
}

- (NSString*)emailPrefix {
    NSRange atRange = [self.email rangeOfString:@"@"];
    if (atRange.location == NSNotFound) {
        return nil;
    }
    return [self.email stringByReplacingCharactersInRange:NSMakeRange(atRange.location, self.email.length-atRange.location) withString:@""];
}

- (ABRecordRef)createABRecord {
    ABRecordRef abPerson = ABPersonCreate();
    
    CFErrorRef error = NULL;
	BOOL couldCreate = YES;
    
	ABRecordSetValue(abPerson, kABPersonFirstNameProperty, (__bridge CFTypeRef)(self.firstName), &error);
    
	ABRecordSetValue(abPerson, kABPersonLastNameProperty, (__bridge CFTypeRef)(self.lastName), &error);
    
    if (self.officePhoneNumber || self.privatePhoneNumber) {
        ABMultiValueRef phone = ABMultiValueCreateMutable(kABStringPropertyType);
        if (self.officePhoneNumber) {
            couldCreate = ABMultiValueAddValueAndLabel(phone, (__bridge CFTypeRef)(self.officePhoneNumber), (CFStringRef)@"EPFL", NULL);
        }
        if (self.privatePhoneNumber) {
            couldCreate = ABMultiValueAddValueAndLabel(phone, (__bridge CFTypeRef)(self.privatePhoneNumber), kABHomeLabel, NULL);
        }
        if (couldCreate) {
            ABRecordSetValue(abPerson, kABPersonPhoneProperty, phone, &error);
        }
        CFRelease(phone);
    }
    
	if (self.email) {
		ABMultiValueRef email = ABMultiValueCreateMutable(kABMultiStringPropertyType);
		couldCreate = ABMultiValueAddValueAndLabel(email, (__bridge CFTypeRef)(self.email), (CFStringRef)@"EPFL", NULL);
		if (couldCreate) {
			ABRecordSetValue(abPerson, kABPersonEmailProperty, email, &error);
		}
		CFRelease(email);
	}
    
    if (self.web) {
		ABMultiValueRef web = ABMultiValueCreateMutable(kABStringPropertyType);
		couldCreate = ABMultiValueAddValueAndLabel(web, (__bridge CFTypeRef)(self.web), (__bridge CFStringRef)(NSLocalizedStringFromTable(@"EPFLWebpage", @"DirectoryPlugin", nil)), NULL);
		if (couldCreate) {
			ABRecordSetValue(abPerson, kABPersonURLProperty, web, &error);
		}
		CFRelease(web);
	}
    
	/* WARNING : This property makes the app crash when the viewController is pushed onto the nav stack. Why ??? Seems to be a bug since iOS 5.1. Reported to Apple. */
	/*if (self.office) {
        ABMultiValueRef office = ABMultiValueCreateMutable(kABStringPropertyType);
        couldCreate = ABMultiValueAddValueAndLabel(office, (__bridge CFTypeRef)(self.office), (__bridge CFStringRef)(NSLocalizedStringFromTable(@"EPFLOffice", @"DirectoryPlugin", nil)), NULL);
        if (couldCreate) {
			ABRecordSetValue(abPerson, kABPersonNoteProperty, office, &anError);
		}
        //CFRelease(office);
    }*/

    
	if (self.office) {
		ABMultiValueRef office = ABMultiValueCreateMutable(kABMultiDictionaryPropertyType);
		NSMutableDictionary *addressDictionary = [NSMutableDictionary dictionaryWithCapacity:2];
        [addressDictionary setObject:self.office forKey:(NSString *)kABPersonAddressCityKey];
		[addressDictionary setObject:@"" forKey:(NSString *)kABPersonAddressCountryKey];
		couldCreate = ABMultiValueAddValueAndLabel(office, (__bridge CFTypeRef)(addressDictionary), (__bridge CFStringRef)(NSLocalizedStringFromTable(@"EPFLOffice", @"DirectoryPlugin", nil)), NULL);
		if (couldCreate) {
			ABRecordSetValue(abPerson, kABPersonAddressProperty, office, &error);
		}
		CFRelease(office);
	}
    
    
    
	/*NSString* message = @"";
     if (self.OrganisationalUnit) {
     for (NSString* unit in self.OrganisationalUnit) {
     message = [message stringByAppendingFormat:@"%@ ", unit];
     }
     }
     */
    
	if (error != NULL) {
        return nil;
	}
    
    return abPerson;
}


- (BOOL)addInfoToABRecord:(ABRecordRef)abPerson {
    BOOL couldCreate = YES;
    CFErrorRef error = NULL;
    
    if (self.officePhoneNumber || self.privatePhoneNumber) {
        ABMultiValueRef phones = ABRecordCopyValue(abPerson, kABPersonPhoneProperty);
        if (!phones || ABMultiValueGetCount(phones) == 0) {
            CFArrayRef linkedContacts = ABPersonCopyArrayOfAllLinkedPeople(abPerson);
            phones = ABMultiValueCreateMutable(kABPersonPhoneProperty);
            ABMultiValueRef linkedPhones;
            for (int i = 0; i<CFArrayGetCount(linkedContacts); i++) {
                ABRecordRef linkedContact = CFArrayGetValueAtIndex(linkedContacts, i);
                linkedPhones = ABRecordCopyValue(linkedContact, kABPersonPhoneProperty);
                if (linkedPhones != nil && ABMultiValueGetCount(linkedPhones) > 0) {
                    for (int j = 0; j<ABMultiValueGetCount(linkedPhones); j++) {
                        ABMultiValueAddValueAndLabel(phones, ABMultiValueCopyValueAtIndex(linkedPhones, j), ABMultiValueCopyLabelAtIndex(linkedPhones, j), NULL);
                    }
                }
                CFRelease(linkedPhones);
            }
            CFRelease(linkedContacts);
        } else {
            phones = ABMultiValueCreateMutableCopy(phones);
        }
        NSArray* existingValues = (__bridge NSArray*)(ABMultiValueCopyArrayOfAllValues(phones));
        if (self.officePhoneNumber && ![existingValues containsObject:self.officePhoneNumber]) {
            couldCreate = ABMultiValueAddValueAndLabel(phones, (__bridge CFTypeRef)(self.officePhoneNumber), kABWorkLabel, NULL);
        }
        if (self.privatePhoneNumber && ![existingValues containsObject:self.privatePhoneNumber]) {
            couldCreate = ABMultiValueAddValueAndLabel(phones, (__bridge CFTypeRef)(self.privatePhoneNumber), kABHomeLabel, NULL);
        }
        if (couldCreate) {
#warning THERE IS AN ERROR in error after this line
            ABRecordSetValue(abPerson, kABPersonPhoneProperty, phones, &error);
        }
        if (existingValues) {
            CFRelease((CFArrayRef)(existingValues));
        }
        CFRelease(phones);
    }
    
    if (self.email) {
		ABMultiValueRef email = ABRecordCopyValue(abPerson, kABPersonEmailProperty);
        if (email) {
            email = ABMultiValueCreateMutableCopy(email);
        } else {
            email = ABMultiValueCreateMutable(kABMultiStringPropertyType);
        }
        NSArray* existingValues = (__bridge NSArray*)(ABMultiValueCopyArrayOfAllValues(email));
        if (![existingValues containsObject:self.email]) {
            couldCreate = ABMultiValueAddValueAndLabel(email, (__bridge CFTypeRef)(self.email), kABWorkLabel, NULL);
            if (couldCreate) {
                ABRecordSetValue(abPerson, kABPersonEmailProperty, email, &error);
            }
        }
        if (existingValues) {
            CFRelease((CFArrayRef)(existingValues));
        }
		CFRelease(email);
	}

    if (self.web) {
		ABMultiValueRef web = ABRecordCopyValue(abPerson, kABPersonURLProperty);
        if (web) {
            web = ABMultiValueCreateMutableCopy(web);
        } else {
            web = ABMultiValueCreateMutable(kABMultiStringPropertyType);
        }
        NSArray* existingValues = (__bridge NSArray*)(ABMultiValueCopyArrayOfAllValues(web));
        if (![existingValues containsObject:self.web]) {
            couldCreate = ABMultiValueAddValueAndLabel(web, (__bridge CFTypeRef)(self.web), kABPersonHomePageLabel, NULL);
            if (couldCreate) {
                ABRecordSetValue(abPerson, kABPersonURLProperty, web, &error);
            }
        }
        if (existingValues) {
            CFRelease((CFArrayRef)(existingValues));
        }
		CFRelease(web);
	}
    
    if (self.office) {
        ABMultiValueRef office = ABRecordCopyValue(abPerson, kABPersonAddressProperty);
        if (office) {
            office = ABMultiValueCreateMutableCopy(office);
        } else {
            office = ABMultiValueCreateMutable(kABMultiDictionaryPropertyType);
        }
        
        NSMutableDictionary* addressDictionary = [NSMutableDictionary dictionaryWithCapacity:2];
        [addressDictionary setObject:self.office forKey:(NSString *)kABPersonAddressCityKey];
		[addressDictionary setObject:@"" forKey:(NSString *)kABPersonAddressCountryKey];
        BOOL shouldAdd = YES;
        NSArray* existingDictionaries = (__bridge NSArray*)(ABMultiValueCopyArrayOfAllValues(office));
        for (NSDictionary* existingDic in existingDictionaries) {
            if ([existingDic isEqualToDictionary:addressDictionary]) {
                shouldAdd = NO;
                break;
            }
        }
		if (shouldAdd) {
            couldCreate = ABMultiValueAddValueAndLabel(office, (__bridge CFTypeRef)(addressDictionary), (__bridge CFStringRef)(NSLocalizedStringFromTable(@"EPFLOffice", @"DirectoryPlugin", nil)), NULL);
            if (couldCreate) {
                ABRecordSetValue(abPerson, kABPersonAddressProperty, office, &error);
            }
        }
        if (existingDictionaries) {
            CFRelease((CFArrayRef)(existingDictionaries));
        }
		CFRelease(office);
	}
    
    return (error == NULL);
}

#pragma mark - Private methods

- (NSString*)firstnameLastnameWithFirstName:(NSString*)firstname {
    if (firstname && self.lastName) {
        return [NSString stringWithFormat:@"%@ %@", firstname, self.lastName];
    } else if (firstname) {
        return firstname;
    } else if (self.lastName) {
        return self.lastName;
    } else {
        return @"";
    }
}


@end
