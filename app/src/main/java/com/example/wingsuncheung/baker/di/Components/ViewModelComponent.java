package com.example.wingsuncheung.baker.di.Components;

import com.example.wingsuncheung.baker.di.Modules.ViewModelFactoryModule;
import com.example.wingsuncheung.baker.di.Scopes.ActivityScope;
import com.example.wingsuncheung.baker.vm.ViewModelFactory;

import dagger.Component;

@ActivityScope
@Component(modules = ViewModelFactoryModule.class, dependencies = BakeApplicationComponent.class)
public interface ViewModelComponent {

    ViewModelFactory getViewModelFactory();

}
