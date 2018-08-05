package com.example.wingsuncheung.baker.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wingsuncheung.baker.R;
import com.example.wingsuncheung.baker.model.Bake;
import com.example.wingsuncheung.baker.model.Ingredient;
import com.example.wingsuncheung.baker.model.Step;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {

    private List<Step> mData;

    private Context context;

    private SimpleExoPlayer mPlayer;

    public StepsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        initPlayer();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.home_detail_steps_card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Step atIndex = mData.get(position);

        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
// Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context,
                Util.getUserAgent(context, "baker"), bandwidthMeter);
// This is the MediaSource representing the media to be played.
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(atIndex.getVideoURL()));
// Prepare the player with the source.

        holder.mShortDescription.setText(atIndex.getShortDescription());
        holder.mLongDescription.setText(atIndex.getDescription());
        mPlayer.prepare(videoSource);
        holder.mPlayerView.setPlayer(mPlayer);
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


        // TODO: implement the exoplayer last

    private TextView mShortDescription, mLongDescription;
    private PlayerView mPlayerView;

        public ViewHolder(View itemView) {
            super(itemView);

            mShortDescription = itemView.findViewById(R.id.tv_steps_short_description);
            mLongDescription = itemView.findViewById(R.id.tv_steps_long_description);
            mPlayerView = itemView.findViewById(R.id.player_step_player);
        }
    }

    public void setData(List<Step> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    private void initPlayer() {

        // Should really dependency injected

        mPlayer = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(context),
                new DefaultTrackSelector(),
                new DefaultLoadControl()
        );



    }

}
