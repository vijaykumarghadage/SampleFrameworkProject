package com.cybage.mobitvassignment.home.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO class for Show
 * Created by vijaykumargh on 05/10/2016.
 */
public class Show {

    @SerializedName("Id")
    private String mId;
    @SerializedName("Title")
    private String mTitle;
    @SerializedName("SubTitle")
    private String mSubTitle;
    @SerializedName("Url")
    private String mUrl;
    @SerializedName("Type")
    private String mType;
    @SerializedName("Duration")
    private String mDuration;
    @SerializedName("IsLocked")
    private Boolean mIsLocked;

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
     * @return The mSubTitle
     */
    public String getSubTitle() {
        return mSubTitle;
    }

    /**
     * @param subTitle The SubTitle
     */
    public void setSubTitle(String subTitle) {
        this.mSubTitle = subTitle;
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
     * @return The mType
     */
    public String getType() {
        return mType;
    }

    /**
     * @param type The Type
     */
    public void setType(String type) {
        this.mType = type;
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
     * @return The mIsLocked
     */
    public Boolean getIsLocked() {
        return mIsLocked;
    }

    /**
     * @param isLocked The IsLocked
     */
    public void setIsLocked(Boolean isLocked) {
        this.mIsLocked = isLocked;
    }


    @Override
    public String toString() {
        return "Show{" +
                "mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mSubTitle='" + mSubTitle + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mType='" + mType + '\'' +
                ", mDuration='" + mDuration + '\'' +
                ", mIsLocked=" + mIsLocked +
                '}';
    }
}