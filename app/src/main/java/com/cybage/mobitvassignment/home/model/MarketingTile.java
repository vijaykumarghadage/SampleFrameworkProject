package com.cybage.mobitvassignment.home.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO class for MarketingTile
 * Created by vijaykumargh on 05/10/2016.
 */

public class MarketingTile {

    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Url")
    private String mUrl;

    /**
     * @return The mTitle
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @param title The Title
     */
    public void setTitle(String title) {
        this.mTitle = title;
    }

    /**
     * @return The mUrl
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * @param url The Url
     */
    public void setUrl(String url) {
        this.mUrl = url;
    }

    @Override
    public String toString() {
        return "MarketingTile{" +
                "mTitle='" + mTitle + '\'' +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
