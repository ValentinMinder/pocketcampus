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




//  Created by Loïc Gardiol on 23.03.12.


#import "PCObjectArchiver.h"

@implementation PCObjectArchiver

+ (BOOL)saveObject:(id<NSCoding>)object forKey:(NSString*)key andPluginName:(NSString*)pluginName {
    return [self saveObject:object forKey:key andPluginName:pluginName isCache:NO];
}

+ (BOOL)saveObject:(id<NSCoding>)object forKey:(NSString *)key andPluginName:(NSString *)pluginName isCache:(BOOL)isCache {
    @synchronized(self) {
        if (![key isKindOfClass:[NSString class]] || ![pluginName isKindOfClass:[NSString class]]) {
            @throw [NSException exceptionWithName:@"bad argument(s)" reason:@"bad key and/or pluginName argument" userInfo:nil];
        }
        @try {
            NSString* path = [self pathForKey:key pluginName:pluginName customFileExtension:nil isCache:isCache];
            if (object == nil) {
                NSError* error = NULL;
                NSFileManager* fileManager = [[NSFileManager alloc] init];
                [fileManager removeItemAtPath:path error:&error];
                
                if (error && ![fileManager fileExistsAtPath:path]) { //then error is that file is already deleted
                    return YES;
                }
                return (error == NULL);
            }
            [[self class] createComponentsForPath:path];
            return [NSKeyedArchiver archiveRootObject:object toFile:path];
        }
        @catch (NSException *exception) {
            CLSNSLog(@"-> Save object exception : %@", exception);
            return NO;
        }
    }
}

+ (id<NSCoding>)objectForKey:(NSString*)key andPluginName:(NSString*)pluginName {
    return [self objectForKey:key andPluginName:pluginName isCache:NO];
}

+ (id<NSCoding>)objectForKey:(NSString*)key andPluginName:(NSString*)pluginName isCache:(BOOL)isCache {
    if (![key isKindOfClass:[NSString class]] || ![pluginName isKindOfClass:[NSString class]]) {
        @throw [NSException exceptionWithName:@"bad argument(s)" reason:@"bad key and/or pluginName argument" userInfo:nil];
    }
    @try {
        return [NSKeyedUnarchiver unarchiveObjectWithFile:[self pathForKey:key pluginName:pluginName customFileExtension:nil isCache:isCache]];
    }
    @catch (NSException *exception) {
        CLSNSLog(@"-> Object for key %@ exception : impossible to retrieve archived object (%@)", key, exception);
        return nil;
    }
}

+ (id<NSCoding>)objectForKey:(NSString*)key andPluginName:(NSString*)pluginName nilIfDiffIntervalLargerThan:(NSTimeInterval)interval isCache:(BOOL)isCache {
    if (![key isKindOfClass:[NSString class]] || ![pluginName isKindOfClass:[NSString class]]) {
        @throw [NSException exceptionWithName:@"bad argument(s)" reason:@"bad key and/or pluginName argument" userInfo:nil];
    }
    
    id<NSCoding> object = [self objectForKey:key andPluginName:pluginName isCache:isCache];
    
    if (!object) {
        return nil;
    }
    
    NSDictionary* fileAttributes = [self fileAttributesForKey:key andPluginName:pluginName isCache:isCache];
    if (!fileAttributes) {
        CLSNSLog(@"!! ERROR in objectForKey:andPluginName:nilIfDiffIntervalLargerThan:isCache: : could not read file attributes");
        return nil;
    }
    NSDate* modifDate = fileAttributes[@"NSFileModificationDate"];
    if ((double)(abs([modifDate timeIntervalSinceNow])) > interval) {
        return nil;
    }
    return object;
}

+ (NSDictionary*)fileAttributesForKey:(NSString*)key andPluginName:(NSString*)pluginName {
    return [self fileAttributesForKey:key andPluginName:pluginName isCache:NO];
}

+ (NSDictionary*)fileAttributesForKey:(NSString*)key andPluginName:(NSString*)pluginName isCache:(BOOL)isCache {
    if (![key isKindOfClass:[NSString class]] || ![pluginName isKindOfClass:[NSString class]]) {
        @throw [NSException exceptionWithName:@"bad argument(s)" reason:@"bad key and/or pluginName argument" userInfo:nil];
    }
    NSString* filePath = [self pathForKey:key pluginName:pluginName customFileExtension:nil isCache:isCache];
    NSFileManager* fileManager = [[NSFileManager alloc] init];
    NSError* error = nil;
    NSDictionary* fileAttributes = [fileManager attributesOfItemAtPath:filePath error:&error];
    if (error != nil) {
        CLSNSLog(@"-> fileAttributeForKey:andPluginName:isCache: impossible to get attribute of file %@", filePath);
        return nil;
    }
    return fileAttributes;
}

+ (NSString*)standardizedNameForPluginName:(NSString*)name {
    name = [[name lowercaseString] stringByReplacingOccurrencesOfString:@"plugin" withString:@""];
    name = [name stringByReplacingOccurrencesOfString:@" " withString:@""];
    return name;
}

+ (NSString*)pathForKey:(NSString*)key pluginName:(NSString*)pluginName {
    return [self pathForKey:key pluginName:pluginName customFileExtension:nil isCache:NO];
}

+ (NSString*)pathForKey:(NSString*)key pluginName:(NSString*)pluginName customFileExtension:(NSString*)customFileExtension isCache:(BOOL)isCache {
    if (![key isKindOfClass:[NSString class]] || ![pluginName isKindOfClass:[NSString class]]) {
        @throw [NSException exceptionWithName:@"bad argument(s)" reason:@"bad key and/or pluginName argument" userInfo:nil];
    }
    /*NSArray* paths = NSSearchPathForDirectoriesInDomains(NSLibraryDirectory, NSUserDomainMask, YES);
    NSString* path = [[paths objectAtIndex:0] stringByAppendingPathComponent:[NSString stringWithFormat:@"%@.%@.save", pluginName, key]];
    path = [path stringByAppendingPathComponent:@"Archived Objects"];
    return path;*/
    
    NSString* dir = [NSSearchPathForDirectoriesInDomains(NSApplicationSupportDirectory, NSUserDomainMask, YES) lastObject];
	NSString* path = [dir stringByAppendingPathComponent:[[NSBundle mainBundle] bundleIdentifier]];
    path = [path stringByAppendingPathComponent:[self standardizedNameForPluginName:pluginName]];
    if (isCache) {
        path = [path stringByAppendingPathComponent:@"cache"];
    }
    NSString* ext = @"archive";
    if (customFileExtension) {
        ext = customFileExtension;
    }
    path = [path stringByAppendingPathComponent:[NSString stringWithFormat:@"%@.%@", key, ext]];
	return path;
    
}

+ (void)createComponentsForPath:(NSString*)path {
    @synchronized(self) {
        if (![path isKindOfClass:[NSString class]]) {
            @throw [NSException exceptionWithName:@"bad path" reason:@"bad path argument" userInfo:nil];
        }
        NSFileManager* fileManager = [[NSFileManager alloc] init];
        NSString* directoryPath = [path stringByDeletingLastPathComponent];
        if (![fileManager fileExistsAtPath:directoryPath]) {
            [fileManager createDirectoryAtPath:directoryPath withIntermediateDirectories:YES attributes:nil error:nil];
        }
    }
}

+ (BOOL)deleteAllCachedObjectsForPluginName:(NSString*)pluginName {
    @synchronized(self) {
        if (![pluginName isKindOfClass:[NSString class]]) {
            @throw [NSException exceptionWithName:@"bad pluginName argument" reason:@"pluginName is either nil or not kind of class NSString*" userInfo:nil];
        }
        NSString* dir = [NSSearchPathForDirectoriesInDomains(NSApplicationSupportDirectory, NSUserDomainMask, YES) lastObject];
        NSString* path = [dir stringByAppendingPathComponent:[[NSBundle mainBundle] bundleIdentifier]];
        path = [path stringByAppendingPathComponent:[self standardizedNameForPluginName:pluginName]];
        path = [path stringByAppendingPathComponent:@"cache"];
        NSFileManager* fileManager = [[NSFileManager alloc] init];
        NSError* error = nil;
        [fileManager removeItemAtPath:path error:&error];
        if (error) {
            return NO;
        }
        return YES;
    }
}

@end