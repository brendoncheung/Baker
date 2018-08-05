package com.example.wingsuncheung.baker.di.Modules;

import android.content.Context;

import com.example.wingsuncheung.baker.di.Scopes.BakeApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @BakeApplicationScope
    public Context context() {
        return context;
    }

}
