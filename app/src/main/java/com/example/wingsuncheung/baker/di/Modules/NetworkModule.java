package com.example.wingsuncheung.baker.di.Modules;

import android.content.Context;

import com.example.wingsuncheung.baker.di.Scopes.BakeApplicationScope;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @BakeApplicationScope
    public StethoInterceptor interceptor() {
        return new StethoInterceptor();
    }

    @Provides
    @BakeApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 10 * 1000); //10mb
    }

    @Provides
    @BakeApplicationScope
    public File file(Context context) {
        return new File(context.getCacheDir(), "okhttp-cache");
    }

    @Provides
    @BakeApplicationScope
    public OkHttpClient okHttpClient(StethoInterceptor stethoInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(stethoInterceptor)
                .cache(cache)
                .build();
    }

}
