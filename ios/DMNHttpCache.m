//
//  DMNHttpCache.m
//  QiChangBuyCar
//
//  Created by Damoness on 2019/8/30.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "DMNHttpCache.h"

@implementation DMNHttpCache

RCT_EXPORT_MODULE(DMNHttpCache);
//1.0.2
RCT_EXPORT_METHOD(getHttpCacheSize:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{
  NSURLCache *httpCache = [NSURLCache sharedURLCache];
  resolve(@([httpCache currentDiskUsage]));
}
RCT_EXPORT_METHOD(clearHttpCache:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{
  NSURLCache *httpCache = [NSURLCache sharedURLCache];
  [httpCache removeAllCachedResponses];
  resolve(nil);
}

RCT_EXPORT_METHOD(getImageCacheSize:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{
  
  [[SDImageCache sharedImageCache]calculateSizeWithCompletionBlock:^(NSUInteger fileCount, NSUInteger totalSize) {
    
    resolve(@(totalSize));
    
  }];
  
}

RCT_EXPORT_METHOD(clearImageCache:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)
{
  
  [[SDImageCache sharedImageCache]clearDiskOnCompletion:^{
    resolve(@(true));
  }];
  
}

@end
