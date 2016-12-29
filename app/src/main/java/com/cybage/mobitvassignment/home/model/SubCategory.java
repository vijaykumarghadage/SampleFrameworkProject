package com.cybage.mobitvassignment.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for SubCategory
 * Created by vijaykumargh on 05/10/2016.
 */
public class SubCategory {

    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Shows")
    private List<Show> mShows = new ArrayList<>();

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
     * @return The mShows
     */
    public List<Show> getShows() {
        return mShows;
    }

    /**
     * @param shows The Shows
     */
    public void setShows(List<Show> shows) {
        this.mShows = shows;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "mTitle='" + mTitle + '\'' +
                ", mShows=" + mShows +
                '}';
    }
}
