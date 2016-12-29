package com.cybage.mobitvassignment.framework.network;

import com.cybage.mobitvassignment.details.model.Details;
import com.cybage.mobitvassignment.details.model.SimilarClipsList;
import com.cybage.mobitvassignment.home.model.CategoryList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface for apis
 * Created by vijaykumargh on 29/09/2016.
 */

public interface ApiInterface {

    @GET("categories")
    Call<CategoryList> getHomeScreenCategories();

    @GET("details/{id}")
    Call<Details> getDetails(@Path("id") String id);

    @GET("similarClips/{id}")
    Call<SimilarClipsList> getSimilarClips(@Path("id") String similarClipsId);
}
