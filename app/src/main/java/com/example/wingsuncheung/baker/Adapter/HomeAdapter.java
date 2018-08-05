package com.example.wingsuncheung.baker.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Bake;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Bake> mData;
    private OnClickListener listener;

    public void swapCursor(List<Bake> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onClick(Bake bake);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_recipe_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_serving.setText("Serving: " + mData.get(position).getServings().toString());
        holder.tv_recipeTitle.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {

        if (mData == null) {
            return 0;
        } else {
            return mData.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_recipeTitle;
        TextView tv_serving;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_recipeTitle = itemView.findViewById(R.id.tv_recipe_title);
            tv_serving = itemView.findViewById(R.id.tv_serving);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(mData.get(getAdapterPosition()));
        }
    }
}
