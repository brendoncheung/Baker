package com.example.wingsuncheung.baker.service;

import com.example.wingsuncheung.baker.model.Bake;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BakeService {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<Bake>> fetchBakeItem();
}
