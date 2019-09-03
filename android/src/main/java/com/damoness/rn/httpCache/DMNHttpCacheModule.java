
package com.damoness.rn.httpCache;

import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.network.OkHttpClientProvider;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Nonnull;
import okhttp3.Cache;

//1.0.2
public class DMNHttpCacheModule extends ReactContextBaseJavaModule {

    public DMNHttpCacheModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nonnull
    @Override
    public String getName() {
        return "DMNHttpCache";
    }


    @ReactMethod
    public void clearHttpCache(Promise promise) {

        try {
            Cache cache = OkHttpClientProvider.getOkHttpClient().cache();

            if (cache != null) {
                cache.delete();
            }

            promise.resolve(null);

        } catch (IOException e) {
            promise.reject(e);
        }
    }

    static Method update;

    private void updateCacheSize(DiskStorageCache cache) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (update == null) {
            update = DiskStorageCache.class.getDeclaredMethod("maybeUpdateFileCacheSize");
            update.setAccessible(true);
        }
        update.invoke(cache);
    }

    @ReactMethod
    public void getImageCacheSize(Promise promise) {
        FileCache cache1 = ImagePipelineFactory.getInstance().getMainFileCache();
        long size1 = cache1.getSize();
        if (size1 < 0) {
            try {
                updateCacheSize((DiskStorageCache) cache1);
            } catch (Exception e) {
                promise.reject(e);
                return;
            }
            size1 = cache1.getSize();
        }

        FileCache cache2 = ImagePipelineFactory.getInstance().getSmallImageFileCache();
        long size2 = cache2.getSize();
        if (size2 < 0) {
            try {
                updateCacheSize((DiskStorageCache) cache2);
            } catch (Exception e) {
                promise.reject(e);
                return;
            }
            size2 = cache2.getSize();
        }


        promise.resolve(((double) (size1 + size2)));

    }

    @ReactMethod
    public void clearImageCache(Promise promise) {
        FileCache cache1 = ImagePipelineFactory.getInstance().getMainFileCache();
        cache1.clearAll();
        FileCache cache2 = ImagePipelineFactory.getInstance().getSmallImageFileCache();
        cache2.clearAll();
        promise.resolve(null);
    }

    @ReactMethod
    public void getHttpCacheSize(Promise promise) {

        try {
            Cache cache = OkHttpClientProvider.getOkHttpClient().cache();
            promise.resolve(cache != null ? ((double) cache.size()) : 0);

        } catch (IOException e) {

            promise.reject(e);

        }

    }
}