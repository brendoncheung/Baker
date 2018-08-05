package com.example.wingsuncheung.baker.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.wingsuncheung.baker.BakeRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final BakeRepository repository;

    public ViewModelFactory(BakeRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(HomeActivityViewModel.class)) {
            return (T) new HomeActivityViewModel(repository);
        }

        return null;

    }
}
