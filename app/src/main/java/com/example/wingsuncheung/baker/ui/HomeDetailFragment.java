package com.example.wingsuncheung.baker.ui;

import android.arch.lifecycle.Observer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wingsuncheung.baker.Adapter.IngredientAdapter;
import com.example.wingsuncheung.baker.Adapter.StepsAdapter;
import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Bake;

public class HomeDetailFragment extends Fragment {

    private RecyclerView rv_ingredients, rv_steps;
    private StepsAdapter stepsAdapter;
    private IngredientAdapter ingredientAdapter;

    private Bake bake;

    public void setData(Bake bake) {
        this.bake = bake;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.home_detail_fragment, container, false);

        initRecyclerView(rootView);
        return rootView;
    }

    private void initRecyclerView(View view) {

        rv_ingredients = view.findViewById(R.id.rv_ingredients);
        rv_steps = view.findViewById(R.id.rv_steps);

        stepsAdapter = new StepsAdapter(getContext());

        rv_steps.setAdapter(stepsAdapter);
        rv_steps.setHasFixedSize(true);
        rv_steps.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ingredientAdapter = new IngredientAdapter(getContext());

        rv_ingredients.setAdapter(ingredientAdapter);
        rv_ingredients.setHasFixedSize(true);
        rv_ingredients.setLayoutManager(new LinearLayoutManager(getContext()));

        stepsAdapter.setData(bake.getSteps());

        ingredientAdapter.setData(bake.getIngredients());

    }








}
