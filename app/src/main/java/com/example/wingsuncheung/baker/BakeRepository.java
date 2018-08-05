package com.example.wingsuncheung.baker;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.wingsuncheung.baker.model.Bake;
import com.example.wingsuncheung.baker.service.BakeService;
import com.example.wingsuncheung.baker.utils.ApplicationExecutor;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BakeRepository {

    private static final String TAG = BakeRepository.class.getSimpleName();

    private BakeService service;

    public BakeRepository(BakeService service) {

        this.service = service;
    }

    /**
     *
     * @return
     */
    public MutableLiveData<List<Bake>> fetchBakeReceipes() {

        final MutableLiveData<List<Bake>> bake = new MutableLiveData<>();

        service.fetchBakeItem().enqueue(new Callback<List<Bake>>() {
            @Override
            public void onResponse(Call<List<Bake>> call, Response<List<Bake>> response) {
                bake.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Bake>> call, Throwable t) {

                Log.d(TAG, "onFailure: Call to movie DB failed. ");
                Log.d(TAG, call.request().url().toString());
                Log.d(TAG, "onFailure:  " + t.getMessage());
            }
        });

        return bake;
    }


}







