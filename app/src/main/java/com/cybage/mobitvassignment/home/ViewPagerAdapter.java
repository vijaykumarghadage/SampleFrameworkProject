package com.cybage.mobitvassignment.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the view pager to add and get the Fragment inside View pager
 * Created by vijaykumargh on 04/10/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * Method used to add fragment
     *
     * @param fragment fragment
     */
    public void addFrag(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
