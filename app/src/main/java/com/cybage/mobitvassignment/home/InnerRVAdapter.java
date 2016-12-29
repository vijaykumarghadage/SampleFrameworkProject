package com.cybage.mobitvassignment.home;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.details.DetailsActivity;
import com.cybage.mobitvassignment.framework.common.Utils;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.home.model.Show;

import java.util.ArrayList;

/**
 * Adapter for inner recycler view
 * Created by vijaykumargh on 05/10/2016.
 */

public class InnerRVAdapter extends RecyclerView.Adapter<InnerRVAdapter.InnerHolder> implements View.OnClickListener {

    private static final String TAG = "InnerRVAdapter";
    private ArrayList<Show> mShows;
    private Activity mActivity;

    public InnerRVAdapter(Activity activity, ArrayList<Show> shows) {
        mActivity = activity;
        mShows = shows;
    }

    class InnerHolder extends RecyclerView.ViewHolder {

        ImageView ivThumbnail;
        TextView tvShowTitle;
        TextView tvShowSubTitle;
        ImageView ivLock;
        TextView tvShowDuration;

        public InnerHolder(View itemView) {
            super(itemView);
            itemView.setTag(this);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            tvShowDuration = (TextView) itemView.findViewById(R.id.tvShowDuration);
            tvShowTitle = (TextView) itemView.findViewById(R.id.tvShowTitle);
            tvShowSubTitle = (TextView) itemView.findViewById(R.id.tvShowSubTitle);
            ivLock = (ImageView) itemView.findViewById(R.id.ivLock);
        }
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner_rv_row, parent, false);
        itemView.setOnClickListener(this);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {
        Show show = mShows.get(position);
        holder.tvShowTitle.setText(show.getTitle());
        holder.tvShowSubTitle.setText(show.getSubTitle());
        holder.tvShowDuration.setText("[" + show.getDuration() + "]");
        Utils.loadImage(mActivity, show.getUrl(), R.drawable.placeholder, holder.ivThumbnail);
        if (show.getIsLocked()) {
            holder.ivLock.setVisibility(View.VISIBLE);
        } else {
            holder.ivLock.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mShows.size();
    }

    @Override
    public void onClick(View view) {
        InnerHolder innerHolder = (InnerHolder) view.getTag();
        int position = innerHolder.getAdapterPosition();
        Log.i(TAG, mShows.get(position).getId());
        Intent detailsIntent = new Intent(mActivity, DetailsActivity.class);
        detailsIntent.putExtra(Constants.DETAILS_ID_KEY, "i1");
        mActivity.startActivity(detailsIntent);
    }

}
