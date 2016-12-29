package com.cybage.mobitvassignment.home;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.home.model.Show;
import com.cybage.mobitvassignment.home.model.SubCategory;

import java.util.ArrayList;

/**
 * Subcategory RecyclerView adapter
 * Created by vijaykumargh on 05/10/2016.
 */

public class SubCategoryRVAdapter extends RecyclerView.Adapter<SubCategoryRVAdapter.SCRVHolder> {

    private ArrayList<SubCategory> mSubCategoryList;
    private Activity mActivity;
    private ArrayList<Show> mShows = new ArrayList<>();

    public SubCategoryRVAdapter(Activity activity, ArrayList<SubCategory> subCategoryList) {
        mActivity = activity;
        mSubCategoryList = subCategoryList;
    }

    class SCRVHolder extends RecyclerView.ViewHolder {

        TextView tvSubCategoryTitle;
        RecyclerView innerRV;
        InnerRVAdapter innerRVAdapter;

        public SCRVHolder(View itemView) {
            super(itemView);
            tvSubCategoryTitle = (TextView) itemView.findViewById(R.id.tvSubCategoryTitle);
            innerRV = (RecyclerView) itemView.findViewById(R.id.innerRV);
            innerRV.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        }

        public void setAdapter() {
            innerRVAdapter = new InnerRVAdapter(mActivity, mShows);
            innerRV.setNestedScrollingEnabled(false);
            innerRV.setAdapter(innerRVAdapter);
            innerRVAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public SCRVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category_rv_row, parent, false);
        return new SCRVHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SCRVHolder holder, int position) {
        SubCategory subCategory = mSubCategoryList.get(position);
        holder.tvSubCategoryTitle.setText(subCategory.getTitle().toUpperCase());
        mShows = new ArrayList<>();
        mShows.addAll(subCategory.getShows());
        holder.setAdapter();
    }

    @Override
    public int getItemCount() {
        return mSubCategoryList.size();
    }

}
