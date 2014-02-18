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



#import "PluginController.h"

#import "AuthenticationService.h"

#import "AuthenticationViewController.h"

extern NSString* const kAuthSessionIdPCConfigKey;

@class AuthenticationViewController;

@interface PCLoginObserver : NSObject

@property (nonatomic, weak) id observer;
@property (nonatomic, copy) NSString* operationIdentifier;
@property (nonatomic, copy) VoidBlock successBlock;
@property (nonatomic, copy) VoidBlock userCancelledBlock;
@property (nonatomic, copy) VoidBlock failureBlock;

@end

@interface AuthenticationController : PluginController<PluginControllerProtocol>


/*
 * Same as sharedInstanceToRetain, but once called AuthenticationController
 * becomes a singleton and is thus never released, which is ok as widely
 * used throught PocketCampus.
 * IMPORTANT: you MUST use this instead of sharedInstanceToRetain
 * when using new-style authentication (addLoginObserver:...)
 */
+ (instancetype)sharedInstance;

/*
 * ######### Standard authentication #########
 * (for plugins that do NOT authenticate using PocketCampus server.
 *  The plugin controller of these plugins can subclass PluginControllerAuthentified
 *  to benefit from easy support of login observeration management).
 *
 * Use this method to authenticate a tequila token.
 * Delegte MUST implement AuthenticateDelegate methods.
 * 
 * WARNING: this method cannot be called by multiple instances 
 * at the same time (1 delegate at a time). CRASH might occur if so.
 * This weakness should be corrected in future release by using
 * an observer pattern.
 */
- (void)authToken:(NSString*)token presentationViewController:(UIViewController*)presentationViewController delegate:(id<AuthenticationDelegate>)delegate;


/*
 * ######### New-style authentication #########
 * (for services that authenticate using PocketCampus server).
 *
 * Starts authentication procedure to PocketCampus server if not done already
 * and add observer to list of observers. On success, the PocketCampus session is
 * renewed and stored in [PCConfig defaults] under key kAuthSessionIdPCConfigKey
 * and all services that rely on PocketCampus authentication can start their
 * requests (they should access this key directly though, ServiceRequest does it
 * automatically). Observers are removed on success/userCancelled/failure.
 * 
 * This method ALWAYS starts the authentication process for the first observer,
 * i.e. that does check whether a PocketCampus session already exists. It is
 * responsability of plugins to call it only when necessary.
 */
- (void)addLoginObserver:(id)observer success:(VoidBlock)success userCancelled:(VoidBlock)userCancelled failure:(VoidBlock)failure;

/*
 * Removes observer from list of observers.
 * Does NOT cancel the authentication if currently in progress.
 * (finishes silently).
 */
- (void)removeLoginObserver:(id)observer;

@end
