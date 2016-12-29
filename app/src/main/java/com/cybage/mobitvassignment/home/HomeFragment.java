package com.cybage.mobitvassignment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.network.ResponseBean;
import com.cybage.mobitvassignment.framework.ui.BaseFragment;
import com.cybage.mobitvassignment.home.model.Category;
import com.cybage.mobitvassignment.home.model.CategoryList;
import com.cybage.mobitvassignment.home.model.MarketingTile;
import com.cybage.mobitvassignment.home.model.SubCategory;

import java.util.ArrayList;

/**
 * Fragment for Main TAB
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";
    private ArrayList<SubCategory> mSubCategoryList;
    private SubCategoryRVAdapter mSubCategoryRVAdapter;
    private Category mCategory;
    private ViewPager mTilesViewPager;
    private LinearLayout mLLDots;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        showProgressDialog(getActivity(), getString(R.string.loading));
        HomeHelper homeHelper = new HomeHelper(this, Constants.GET_CATEGORIES);
        homeHelper.getCategories();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mTilesViewPager = (ViewPager) rootView.findViewById(R.id.tilesViewPager);
        mLLDots = (LinearLayout) rootView.findViewById(R.id.llDots);

        RecyclerView rvSubCategory = (RecyclerView) rootView.findViewById(R.id.rvSubCategory);
        rvSubCategory.setLayoutManager(new LinearLayoutManager(getActivity()));

        mSubCategoryList = new ArrayList<>();
        mSubCategoryRVAdapter = new SubCategoryRVAdapter(getActivity(), mSubCategoryList);
        rvSubCategory.setAdapter(mSubCategoryRVAdapter);
        rvSubCategory.setNestedScrollingEnabled(false);

        updateUI();

        return rootView;
    }

    @Override
    public void onSuccessPostAction(ResponseBean responseBean) {
        stopProgressDialog();
        Log.i(TAG, "onSuccessPostAction");
        switch (responseBean.getOperationIdentifier()) {
            case Constants.GET_CATEGORIES:
                CategoryList categoryList = (CategoryList) responseBean.getResponse().body();
                Log.i(TAG, "Response: " + categoryList.toString());
                mCategory = categoryList.getCategories().get(0);
                updateUI();
                break;
            default:
                break;
        }
    }

    @Override
    public void onErrorPostAction(ResponseBean responseBean) {
        stopProgressDialog();
        Log.i(TAG, "onErrorPostAction");
        switch (responseBean.getOperationIdentifier()) {
            case Constants.GET_CATEGORIES:
                Log.e(TAG, "Response: " + responseBean.getError().getMessage());
                handleException(getString(R.string.alert), responseBean.getError().getMessage());
                break;
            default:
                break;
        }
    }

    /**
     * update UI
     */
    private void updateUI() {
        if (mCategory != null) {
            setupViewPager();
            mSubCategoryList.clear();
            mSubCategoryList.addAll(mCategory.getSubCategories());
            mSubCategoryRVAdapter.notifyDataSetChanged();
        }
    }

    /**
     * method used to setup view pager for tiles
     */
    private void setupViewPager() {
        TilesViewPagerAdapter tilesViewPagerAdapter = new TilesViewPagerAdapter(getActivity());
        final ArrayList<MarketingTile> tilesList = new ArrayList<>();
        tilesList.addAll(mCategory.getMarketingTiles());
        tilesViewPagerAdapter.setList(tilesList);
        mTilesViewPager.setAdapter(tilesViewPagerAdapter);
        mLLDots.removeAllViews();
        for (int i = 0; i < tilesList.size(); i++) {
            ImageView iv = new ImageView(getActivity());
            if (i == 0) {
                iv.setImageResource(R.drawable.dot_dark_gray);
            } else {
                iv.setImageResource(R.drawable.dot_gray);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(16, 16);
            layoutParams.setMargins(0, 0, 10, 10);
            iv.setLayoutParams(layoutParams);
            mLLDots.addView(iv);
        }
        mTilesViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "onPageSelected :" + position);
                for (int i = 0; i < tilesList.size(); i++) {
                    ImageView iv = (ImageView) mLLDots.getChildAt(i);
                    if (i == position) {
                        iv.setImageResource(R.drawable.dot_dark_gray);
                    } else {
                        iv.setImageResource(R.drawable.dot_gray);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

}
