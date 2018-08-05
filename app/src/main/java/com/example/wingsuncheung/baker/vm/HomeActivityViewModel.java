package com.example.wingsuncheung.baker.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.wingsuncheung.baker.BakeRepository;
import com.example.wingsuncheung.baker.model.Bake;

import java.util.List;

public class HomeActivityViewModel extends ViewModel {

    private BakeRepository repository;

    private LiveData<List<Bake>> bakes;

    public HomeActivityViewModel(BakeRepository repository) {
        this.repository = repository;
    }


    /**
     *
     * @return This returns the live data from the Bake Repository
     */
    public LiveData<List<Bake>> getBakes() {
        bakes = repository.fetchBakeReceipes();
        return bakes;
    }

}
