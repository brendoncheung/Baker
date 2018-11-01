package com.example.wingsuncheung.baker.ui;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wingsuncheung.baker.BakeApplication;
import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.di.Components.DaggerViewModelComponent;
import com.example.wingsuncheung.baker.di.Components.ViewModelComponent;
import com.example.wingsuncheung.baker.model.Bake;
import com.example.wingsuncheung.baker.vm.HomeActivityViewModel;
import com.example.wingsuncheung.baker.vm.ViewModelFactory;

import org.parceler.Parcels;

public class HomeActivity extends AppCompatActivity implements HomeListFragment.OnListClickListener {

    private static final String TAG = HomeActivity.class.getSimpleName();

    private ViewModelComponent component;

    private ViewModelFactory viewModelFactory;
    private HomeActivityViewModel viewModel;
    private FragmentManager fragmentManager;

    private Parcelable mock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        inject();
        initViewModel();
        initMasterListFragment();
    }

    private void inject() {
        component = DaggerViewModelComponent.builder()
                .bakeApplicationComponent(BakeApplication.get(this).getComponent())
                .build();
        viewModelFactory = component.getViewModelFactory();
    }

    private void initViewModel() {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeActivityViewModel.class);
    }

    private void initMasterListFragment() {

        HomeListFragment listFragment = new HomeListFragment();

        listFragment.setListFragmentCallback(this);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction
                .add(R.id.fl_list_container, listFragment)
                .commit();
    }

    public HomeActivityViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onRecipeSelected(Bake bake) {



        Intent intent = new Intent(this, DetailActivity.class);
        Parcelable wrappedBake = Parcels.wrap(bake);

        mock = wrappedBake;

        intent.putExtra("bake", wrappedBake);

        startActivity(intent);

    }

    public Parcelable getMock() {
        return mock;
    }
}











