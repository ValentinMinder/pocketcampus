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

//  Created by Loïc Gardiol on 16.03.12.

@interface PCTableViewSectionHeader : UIView

/**
 * @discussion same as nect with showInfoButton set to NO
 */
- (id)initWithSectionTitle:(NSString*)sectionTitle tableView:(UITableView*)tableView;

- (id)initWithSectionTitle:(NSString*)sectionTitle tableView:(UITableView*)tableView showInfoButton:(BOOL)showInfoButton;

@property (nonatomic, readonly, weak) UITableView* tableView;

/**
 * @discussion If YES, backgroundTintColor and textColor are set so that
 * the header view looks highlighted compare to the non-highlighted ones.
 * Manually setting backgroundTintColor and textColor after setting this property
 * to YES will set it back to NO.
 * Set to NO will set backgroundTintColor and textColor to their default values.
 */
@property (nonatomic) BOOL highlighted;

/**
 * @discussion The background of the header is made of a navigation bar
 * changing backgroundTintColor will change the bar's barTintColor.
 * Setting to nil will set to default nav bar tint color.
 * Default: nil
 */
@property (nonatomic, strong) UIColor* backgroundTintColor;

/**
 * @discussion Setting to nil will set to default.
 * Default: black with alpha 0.8
 */
@property (nonatomic, strong) UIColor* textColor;

/**
 * @discussion executed when info button tapped
 * Default: nil
 */
@property (nonatomic, copy) void (^infoButtonTappedBlock)();

+ (CGFloat)preferredHeight;

+ (CGFloat)preferredHeightWithInfoButton:(BOOL)withInfoButton;

@end
