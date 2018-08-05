package com.example.wingsuncheung.baker;

import android.app.Activity;
import android.app.Application;

import com.example.wingsuncheung.baker.di.Components.BakeApplicationComponent;
import com.example.wingsuncheung.baker.di.Components.DaggerBakeApplicationComponent;
import com.example.wingsuncheung.baker.di.Modules.ContextModule;
import com.example.wingsuncheung.baker.service.BakeService;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class BakeApplication extends Application {

    private static final String TAG = BakeApplication.class.getSimpleName();

    private BakeApplicationComponent component;


    public static BakeApplication get(Activity activity) {
        return (BakeApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initializing debug bridge
        Stetho.initializeWithDefaults(this);

        component = DaggerBakeApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public BakeApplicationComponent getComponent() {
        return component;
    }
}




