package com.example.wingsuncheung.baker.di.Modules;

import com.example.wingsuncheung.baker.BakeRepository;
import com.example.wingsuncheung.baker.di.Scopes.ActivityScope;
import com.example.wingsuncheung.baker.di.Scopes.BakeApplicationScope;
import com.example.wingsuncheung.baker.service.BakeService;
import com.example.wingsuncheung.baker.vm.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFactoryModule {

    @Provides
    @ActivityScope
    public BakeRepository repository(BakeService service) {
        return new BakeRepository(service);
    }

    @Provides
    @ActivityScope
    public ViewModelFactory viewModelFactory(BakeRepository repository) {
        return new ViewModelFactory(repository);
    }
}
