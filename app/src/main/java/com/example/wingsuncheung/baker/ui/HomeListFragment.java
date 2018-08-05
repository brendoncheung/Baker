package com.example.wingsuncheung.baker.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wingsuncheung.baker.Adapter.HomeAdapter;
import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Bake;
import com.example.wingsuncheung.baker.vm.HomeActivityViewModel;

import java.util.List;

public class HomeListFragment extends Fragment {

    private static final String TAG = HomeListFragment.class.getSimpleName();

    private HomeActivityViewModel viewModel;

    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    public OnListClickListener mCallback;

    public interface OnListClickListener {
        void onRecipeSelected(Bake bake);
    }

    /**
     * Mandatory public constructor to instanitate this fragment
     */
    public HomeListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_list_fragment, container, false);

        initViewModel();
        initRecyclerView(rootView);

        return rootView;
    }

    private void initViewModel() {

        HomeActivity home = (HomeActivity) getActivity(); // not good!
        viewModel = home.getViewModel();
        viewModel.getBakes().observe(this, new Observer<List<Bake>>() {
            @Override
            public void onChanged(@Nullable List<Bake> bakes) {
                adapter.swapCursor(bakes);
            }
        });
    }

    private void initRecyclerView(View rootView) {

        adapter = new HomeAdapter();

        adapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void onClick(Bake bake) {
                mCallback.onRecipeSelected(bake);
            }
        });

        recyclerView = rootView.findViewById(R.id.rv_recycler_recipe);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnListClickListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement onListClickListener");
        }
    }

    public void setListFragmentCallback(OnListClickListener listener) {
        this.mCallback = listener;
    }


}


























