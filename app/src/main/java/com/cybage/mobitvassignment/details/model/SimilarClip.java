package com.cybage.mobitvassignment.details.model;

import com.google.gson.annotations.SerializedName;

/**
 * Pojo Class for Similar clip
 * Created by vijaykumargh on 03/10/2016.
 */

public class SimilarClip {

    @SerializedName("Id")
    private String mId;
    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Url")
    private String mUrl;
    @SerializedName("Time")
    private String mTime;

    /**
     * @return The mId
     */
    public String getId() {
        return mId;
    }

    /**
     * @param id The Id
     */
    public void setId(String id) {
        this.mId = id;
    }

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

    /**
     * @return The mTime
     */
    public String getTime() {
        return mTime;
    }

    /**
     * @param time The Time
     */
    public void setTime(String time) {
        this.mTime = time;
    }

    @Override
    public String toString() {
        return "SimilarClip{" +
                "mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mTime='" + mTime + '\'' +
                '}';
    }
}