package com.cybage.mobitvassignment.details.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * pojo class for list of clips
 * Created by vijaykumargh on 03/10/2016.
 */

public class SimilarClipsList {

    @SerializedName("SimilarClipsId")
    private String mSimilarClipsId;
    @SerializedName("SimilarClips")
    private List<SimilarClip> mSimilarClips = new ArrayList<>();

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

    /**
     * @return The mSimilarClips
     */
    public List<SimilarClip> getSimilarClips() {
        return mSimilarClips;
    }

    /**
     * @param similarClips The SimilarClips
     */
    public void setSimilarClips(List<SimilarClip> similarClips) {
        this.mSimilarClips = similarClips;
    }


    @Override
    public String toString() {
        return "SimilarClipsList{" +
                "mSimilarClipsId='" + mSimilarClipsId + '\'' +
                ", mSimilarClips=" + mSimilarClips +
                '}';
    }
}
