package com.cybage.mobitvassignment.home;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.common.Utils;
import com.cybage.mobitvassignment.home.model.MarketingTile;

import java.util.ArrayList;

/**
 * Adapter for tiles view pager
 * Created by vijaykumargh on 06/10/2016.
 */

public class TilesViewPagerAdapter extends PagerAdapter {

    private ArrayList<MarketingTile> mMarketingTiles = new ArrayList<>();
    private Activity mActivity;

    public TilesViewPagerAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mMarketingTiles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = mActivity.getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.tiles_layout, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.ivTilesImage);
        Utils.loadImage(mActivity,
                mMarketingTiles.get(position).getUrl()
                , R.drawable.placeholder, imageView);
        container.addView(viewItem);

        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * Method used to set list
     *
     * @param marketingTiles tiles
     */
    public void setList(ArrayList<MarketingTile> marketingTiles) {
        mMarketingTiles = marketingTiles;
    }
}
