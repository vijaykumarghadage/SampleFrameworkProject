package com.cybage.mobitvassignment.details.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model for Details
 * Created by vijaykumargh on 29/09/2016.
 */

public class Details {

    @SerializedName("Id")
    private String mId;

    @SerializedName("Title")
    private String mTitle;

    @SerializedName("Url")
    private String mUrl;

    @SerializedName("Description")
    private String mDescription;

    @SerializedName("Time")
    private String mTime;

    @SerializedName("Duration")
    private String mDuration;

    @SerializedName("SimilarClipsId")
    private String mSimilarClipsId;

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
     * @return The mDescription
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * @param description The Description
     */
    public void setDescription(String description) {
        this.mDescription = description;
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

    /**
     * @return The mDuration
     */
    public String getDuration() {
        return mDuration;
    }

    /**
     * @param duration The Duration
     */
    public void setDuration(String duration) {
        this.mDuration = duration;
    }

    /**
     * @return The mSimilarClipsId
     */
    public String getSimilarClipsId() {
        return mSimilarClipsId;
    }

    /**
     * @param similarClipsId The SimilarClipsId
     */
    public void setSimilarClipsId(String similarClipsId) {
        this.mSimilarClipsId = similarClipsId;
    }

    @Override
    public String toString() {
        return "Details{" +
                "mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mDuration='" + mDuration + '\'' +
                ", mSimilarClipsId='" + mSimilarClipsId + '\'' +
                '}';
    }
}
