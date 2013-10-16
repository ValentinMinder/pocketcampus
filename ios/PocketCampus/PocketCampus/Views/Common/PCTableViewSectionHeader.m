//
//  PCTableViewSectionHeader.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 16.03.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "PCTableViewSectionHeader.h"
#import "PCValues.h"

static float SEPARATOR_HEIGHT = 1.0;

@implementation PCTableViewSectionHeader

- (id)initWithSectionTitle:(NSString*)sectionTitle tableView:(UITableView*)tableView
{
    float VIEW_HEIGHT = [PCValues tableViewSectionHeaderHeight];
    self = [super initWithFrame:CGRectMake(0, 0, tableView.frame.size.width, VIEW_HEIGHT)]; //screen height so that landscape orientation is directly supported
    self.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    if (self) {
        _tableView = tableView;
        self.alpha = 0.85;
        self.backgroundColor = [PCValues backgroundColor1];
        UIView* separator1 = [[UIView alloc] initWithFrame:CGRectMake(0, -1.0, self.frame.size.width, SEPARATOR_HEIGHT)];
        separator1.backgroundColor = [UIColor colorWithWhite:0.8 alpha:1.0];
        
        UILabel* label = [[UILabel alloc] initWithFrame:CGRectMake(0, 0.0, self.frame.size.width, VIEW_HEIGHT-(2*SEPARATOR_HEIGHT))];
        label.text = [NSString stringWithFormat:@"  %@", sectionTitle];
        label.backgroundColor = [UIColor clearColor];
        label.textColor = [PCValues textColor1];
        label.shadowColor = [PCValues shadowColor1];
        label.shadowOffset = [PCValues shadowOffset1];
        label.font = [UIFont boldSystemFontOfSize:14.0];
        label.textAlignment = UITextAlignmentLeft;
        
        UIView* separator2 = [[UIView alloc] initWithFrame:CGRectMake(0, VIEW_HEIGHT-SEPARATOR_HEIGHT, self.frame.size.width, SEPARATOR_HEIGHT)];
        separator2.backgroundColor = [UIColor colorWithWhite:0.8 alpha:1.0];
        
        separator1.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        label.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        separator2.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        
        [self addSubview:separator1];
        [self addSubview:label];
        [self addSubview:separator2];
    }
    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect
{
    // Drawing code
}
*/

@end