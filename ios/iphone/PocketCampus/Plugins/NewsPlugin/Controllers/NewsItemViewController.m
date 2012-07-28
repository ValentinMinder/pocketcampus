//
//  NewsItemViewController.m
//  PocketCampus
//
//  Created by Loïc Gardiol on 05.05.12.
//  Copyright (c) 2012 EPFL. All rights reserved.
//

#import "NewsItemViewController.h"

#import "PCValues.h"

#import "NewsUtils.h"

#import "ASIHTTPRequest.h"

static int NEWS_FONT_SIZE = 14.0;

@implementation NewsItemViewController

@synthesize scrollView, feedLabel, publishDateLabel, centerActivityIndicator, centerMessageLabel;

- (id)init
{
    self = [super initWithNibName:@"NewsItemView" bundle:nil];
    if (self) {
        newsService = [[NewsService sharedInstanceToRetain] retain];
        newsItem = nil;
        mainImageView = nil;
        mainImage = nil;
        thumbnailRequest = nil;
        urlClickedByUser = nil;
    }
    return self;
}

- (id)initWithNewsItem:(NewsItem*)newsItem_ {
    self = [self init];
    if (self) {
        newsItem = [newsItem_ retain];
        
    }
    return self;
}

- (id)initWithNewsItem:(NewsItem *)newsItem_ andCachedImage:(UIImage*)image {
    self = [self init];
    if (self) {
        newsItem = [newsItem_ retain];
        mainImage = [image retain];
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    self.title = newsItem.title;
    UIBarButtonItem* actionButton = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemAction target:self action:@selector(actionButtonPressed)];
    self.navigationItem.rightBarButtonItem = actionButton;
    [actionButton release];
    [centerActivityIndicator startAnimating];

    feedLabel.text = newsItem.feed;
    publishDateLabel.text = [NewsUtils dateLocaleStringForTimestamp:newsItem.pubDate/1000.0];
    
    UIFont* titleFont = [UIFont boldSystemFontOfSize:17.0];
    
    CGSize titleReqSize = [newsItem.title sizeWithFont:titleFont constrainedToSize:CGSizeMake(300.0, 200.0)];
    
    titleLabel = [[UILabel alloc] initWithFrame:CGRectMake(10.0, 55.0, titleReqSize.width, titleReqSize.height)];
    titleLabel.text = newsItem.title;
    titleLabel.font = titleFont;
    titleLabel.textColor = [PCValues textColor1];
    titleLabel.numberOfLines = 0;
    
    [scrollView addSubview:titleLabel];
    
    if (newsItem.imageUrl != nil) {
        if (mainImage != nil) {
            [self addMainImageToScrollView];
            [newsService getNewsItemContentForId:newsItem.newsItemId delegate:self];
        } else { //thumbnail has to be downloaded. When it returns, the request for news content will be done
            thumbnailRequest = [[ASIHTTPRequest requestWithURL:[NSURL URLWithString:newsItem.imageUrl]] retain];
            thumbnailRequest.cachePolicy = NSURLRequestReturnCacheDataElseLoad;
            thumbnailRequest.cacheStoragePolicy = ASICachePermanentlyCacheStoragePolicy;
            thumbnailRequest.timeOutSeconds = 20.0;
            thumbnailRequest.delegate = self;
            [thumbnailRequest startAsynchronous];
        }
    } else {
        [newsService getNewsItemContentForId:newsItem.newsItemId delegate:self];
    }
}

- (void)actionButtonPressed {
    UIActionSheet* actionSheet = [[UIActionSheet alloc] initWithTitle:@"" delegate:self cancelButtonTitle:NSLocalizedStringFromTable(@"Cancel", @"PocketCampus", nil) destructiveButtonTitle:nil otherButtonTitles:NSLocalizedStringFromTable(@"OpenInSafari", @"NewsPlugin", nil), nil];
    [actionSheet showInView:self.view];
    [actionSheet release];
}

- (void)addMainImageToScrollView {
    if (mainImage != nil) {
        if (mainImage.size.width > 300.0) {
            [mainImage autorelease];
            mainImage = [[UIImage imageWithCGImage:(CGImageRef)mainImage.CGImage scale:(mainImage.size.width/300.0) orientation:UIImageOrientationUp] retain]; //new resized image
        }
        mainImageView = [[UIImageView alloc] initWithImage:mainImage];
        mainImageView.center = CGPointMake(scrollView.center.x, titleLabel.frame.origin.y+titleLabel.frame.size.height+(mainImageView.frame.size.height/2.0)+7.0);
        [scrollView addSubview:mainImageView];
    }
}

- (void)viewWillUnload {
    [webView stopLoading];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

/* UIActionSheetDelegate delegation */

- (void)actionSheet:(UIActionSheet *)actionSheet didDismissWithButtonIndex:(NSInteger)buttonIndex {
    switch (buttonIndex) {
        case 0:
            [[UIApplication sharedApplication] openURL:[NSURL URLWithString:newsItem.link]];
            break;
        default:
            break;
    }
}

/* ASIHTTPRequestDelegate delegation */

- (void)requestFinished:(ASIHTTPRequest *)request {
    if (request == thumbnailRequest) {
        mainImage = [[UIImage imageWithData:request.responseData] retain];
        [self addMainImageToScrollView];
        [newsService getNewsItemContentForId:newsItem.newsItemId delegate:self];
        [thumbnailRequest release];
        thumbnailRequest = nil;
    }
}

- (void)requestFailed:(ASIHTTPRequest *)request {
    if (request == thumbnailRequest) {
        [self serviceConnectionToServerTimedOut];
        [thumbnailRequest release];
        thumbnailRequest = nil;
    }
}

/* NewsServiceDelegate delegation */

- (void)newsItemContentForId:(Id)newsItemId didReturn:(NSString *)content {
    CGFloat startY; 
    if (mainImage != nil) {
        startY = mainImageView.frame.origin.y+mainImageView.frame.size.height+5.0;
    } else {
        startY = titleLabel.frame.origin.y+titleLabel.frame.size.height+5.0;
    }
    webView = [[[UIWebView alloc] initWithFrame:CGRectMake(2.0, startY, 310.0, 50.0)] autorelease]; //height will be recomputed when HTML loaded in delegate call
    webView.scrollView.scrollEnabled = NO;
    webView.delegate = self;
    NSString* contentWithStyle = [NSString stringWithFormat:@"<meta name='viewport' content='width=device-width; initial-scale=1.0; maximum-scale=1.0;'><style type='text/css'>a { color:#B80000; text-decoration:none; }</style><span style='font-family: Helvetica; font-size: %dpx;'>%@</span>", NEWS_FONT_SIZE, content];
    
    [webView loadHTMLString:contentWithStyle baseURL:nil];
    
    [scrollView addSubview:webView];
    
}

- (void)newsItemContentFailedForId:(Id)newsItemId {
    [centerActivityIndicator stopAnimating];
    centerMessageLabel.text = NSLocalizedStringFromTable(@"ConnectionToServerError", @"PocketCampus", nil);
    centerMessageLabel.hidden = NO;
}

- (void)serviceConnectionToServerTimedOut {
    [centerActivityIndicator stopAnimating];
    centerMessageLabel.text = NSLocalizedStringFromTable(@"ConnectionToServerTimedOut", @"PocketCampus", nil);
    centerMessageLabel.hidden = NO;
}

/* UIWebViewDelegate delegation */

- (void)webViewDidFinishLoad:(UIWebView *)webView_ {
    [centerActivityIndicator stopAnimating];
    [webView sizeToFit];
    CGFloat scrollViewContentHeight = webView.frame.origin.y+webView.frame.size.height;
    
    if (scrollViewContentHeight <= self.view.frame.size.height) {
        scrollViewContentHeight = self.view.frame.size.height + 1.0;//to be able to scroll even if not necessary
    }
    [scrollView setContentSize:CGSizeMake(self.view.frame.size.width, scrollViewContentHeight)];
}

- (BOOL)webView:(UIWebView *)webView shouldStartLoadWithRequest:(NSURLRequest *)request navigationType:(UIWebViewNavigationType)navigationType {
    if (navigationType == UIWebViewNavigationTypeLinkClicked) {
        [urlClickedByUser release];
        urlClickedByUser = [request.URL retain];
        UIAlertView* alertView = [[UIAlertView alloc] initWithTitle:@"" message:NSLocalizedStringFromTable(@"ClickLinkLeaveApplicationExplanation", @"NewsPlugin", nil) delegate:self cancelButtonTitle:NSLocalizedStringFromTable(@"Cancel", @"PocketCampus", nil) otherButtonTitles:@"OK", nil];
        [alertView show];
        [alertView release];
        return NO;
    }
    return YES;
}

/* UIAlertViewDelegate delegation */

- (void)alertView:(UIAlertView *)alertView didDismissWithButtonIndex:(NSInteger)buttonIndex {
    if (urlClickedByUser != nil) {
        switch (buttonIndex) {
            case 0: //cancel
                //Nothing to do
                break;
            case 1: //OK
                [[UIApplication sharedApplication] openURL:urlClickedByUser];
            default:
                break;
        }
        [urlClickedByUser release];
        urlClickedByUser = nil;
    }
}

- (void)dealloc
{
    [titleLabel release];
    [mainImageView release];
    [mainImage release];
    [newsItem release];
    [newsService cancelOperationsForDelegate:self];
    [newsService release];
    if (thumbnailRequest != nil) {
        [thumbnailRequest cancel];
        thumbnailRequest.delegate = nil;
        [thumbnailRequest release];
    }
    [urlClickedByUser release];
    [super dealloc];
}

@end