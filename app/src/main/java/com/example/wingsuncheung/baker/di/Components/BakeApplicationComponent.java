package com.example.wingsuncheung.baker.di.Components;

import com.example.wingsuncheung.baker.di.Modules.BakeServiceModule;
import com.example.wingsuncheung.baker.di.Modules.PicassoModule;
import com.example.wingsuncheung.baker.di.Scopes.BakeApplicationScope;
import com.example.wingsuncheung.baker.service.BakeService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@BakeApplicationScope
@Component(modules = {BakeServiceModule.class, PicassoModule.class})
public interface BakeApplicationComponent {

    BakeService getServive();
    Picasso getPicasso();

}
