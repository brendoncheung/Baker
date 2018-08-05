package com.example.wingsuncheung.baker.di.Modules;

import com.example.wingsuncheung.baker.di.Scopes.BakeApplicationScope;
import com.example.wingsuncheung.baker.service.BakeService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class BakeServiceModule {

    @Provides
    @BakeApplicationScope
    public BakeService bakeService(Retrofit retrofit) {

        return retrofit.create(BakeService.class);
    }

    @Provides
    @BakeApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://d17h27t6h515a5.cloudfront.net")
                .build();
    }
}




















