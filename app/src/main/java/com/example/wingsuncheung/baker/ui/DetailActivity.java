package com.example.wingsuncheung.baker.ui;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Bake;

import org.parceler.Parcels;

// This activity holds the HomeDetailFragment

public class DetailActivity extends AppCompatActivity {

    private Bake mData;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        mData = Parcels.unwrap(getIntent().getExtras().getParcelable("bake"));
        initDetailFragment();

    }

    private void initDetailFragment() {

        HomeDetailFragment detailFragment = new HomeDetailFragment();

        detailFragment.setData(mData);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.fl_detail_container, detailFragment)
                .commit();
    }


}
