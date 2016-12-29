package com.cybage.mobitvassignment.details;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.details.model.SimilarClip;
import com.cybage.mobitvassignment.framework.common.Utils;

import java.util.ArrayList;

/**
 * Class is used as adapter for recycler view
 * Created by vijaykumargh on 03/10/2016.
 */

public class SimilarClipsAdapter extends RecyclerView.Adapter<SimilarClipsAdapter.SCViewHolder> implements View.OnClickListener {

    private ArrayList<SimilarClip> mClipsList;
    private Activity mContext;

    public SimilarClipsAdapter(Activity context, ArrayList<SimilarClip> clipsList) {
        mContext = context;
        mClipsList = clipsList;
    }

    class SCViewHolder extends RecyclerView.ViewHolder {
        TextView mTvClipTitle;
        TextView mTvClipTime;
        ImageView mIvClipImage;

        SCViewHolder(View itemView) {
            super(itemView);
            itemView.setTag(this);
            mTvClipTitle = (TextView) itemView.findViewById(R.id.tvClipTitle);
            mTvClipTime = (TextView) itemView.findViewById(R.id.tvClipTime);
            mIvClipImage = (ImageView) itemView.findViewById(R.id.ivClipImage);
        }
    }

    @Override
    public SCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_similar_clips_row, parent, false);
        itemView.setOnClickListener(this);
        return new SCViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SCViewHolder holder, int position) {
        SimilarClip clip = mClipsList.get(position);
        Utils.loadImage(mContext, clip.getUrl(), R.drawable.placeholder, holder.mIvClipImage);
        holder.mTvClipTitle.setText(clip.getTitle());
        holder.mTvClipTime.setText(clip.getTime());
    }

    @Override
    public int getItemCount() {
        return mClipsList.size();
    }

    @Override
    public void onClick(View view) {
       /* SCViewHolder viewHolder = (SCViewHolder) view.getTag();
        int pos = viewHolder.getAdapterPosition();*/
        ((DetailsActivity) mContext).showToast(mContext.getString(R.string.under_development));
    }

}
