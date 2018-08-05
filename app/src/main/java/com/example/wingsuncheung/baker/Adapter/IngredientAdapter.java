package com.example.wingsuncheung.baker.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Ingredient;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {

    private List<Ingredient> mData;
    private Context context;


    public IngredientAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.home_detail_ingredient_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Ingredient atIndex = mData.get(position);

        holder.mIngredientName.setText(atIndex.getIngredient());
        holder.mMeasure.setText(atIndex.getMeasure());
        holder.mQuantity.setText(atIndex.getQuantity().toString());
    }

    @Override
    public int getItemCount() {

        if (mData == null) {
            return 0;
        } else {
            return mData.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mIngredientName, mMeasure, mQuantity;

        public ViewHolder(View itemView) {
            super(itemView);

            mIngredientName = itemView.findViewById(R.id.tv_ingredients);
            mMeasure = itemView.findViewById(R.id.tv_measure);
            mQuantity = itemView.findViewById(R.id.tv_quantity);
        }
    }

    public void setData(List<Ingredient> data) {
        this.mData = data;
        notifyDataSetChanged();
    }



}
