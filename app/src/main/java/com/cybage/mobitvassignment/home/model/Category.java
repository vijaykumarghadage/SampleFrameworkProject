package com.cybage.mobitvassignment.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for Category
 * Created by vijaykumargh on 05/10/2016.
 */

public class Category {

    @SerializedName("CategoryTitle")
    private String mCategoryTitle;
    @SerializedName("MarketingTiles")
    private List<MarketingTile> mMarketingTiles = new ArrayList<>();
    @SerializedName("SubCategories")
    private List<SubCategory> mSubCategories = new ArrayList<>();

    /**
     * @return The mCategoryTitle
     */
    public String getCategoryTitle() {
        return mCategoryTitle;
    }

    /**
     * @param categoryTitle The CategoryTitle
     */
    public void setCategoryTitle(String categoryTitle) {
        this.mCategoryTitle = categoryTitle;
    }

    /**
     * @return The mMarketingTiles
     */
    public List<MarketingTile> getMarketingTiles() {
        return mMarketingTiles;
    }

    /**
     * @param marketingTiles The MarketingTiles
     */
    public void setMarketingTiles(List<MarketingTile> marketingTiles) {
        this.mMarketingTiles = marketingTiles;
    }

    /**
     * @return The mSubCategories
     */
    public List<SubCategory> getSubCategories() {
        return mSubCategories;
    }

    /**
     * @param subCategories The SubCategories
     */
    public void setSubCategories(List<SubCategory> subCategories) {
        this.mSubCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "mCategoryTitle='" + mCategoryTitle + '\'' +
                ", mMarketingTiles=" + mMarketingTiles +
                ", mSubCategories=" + mSubCategories +
                '}';
    }
}