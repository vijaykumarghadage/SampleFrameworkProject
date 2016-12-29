package com.cybage.mobitvassignment.framework.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class used to create retrofit client
 * Created by vijaykumargh on 28/09/2016.
 */

public class RetrofitClient {

    private static final String BASE_URL = "http://172.27.46.235:8080/RestApiTest/rest/MobiTV/";
    private static Retrofit sRetrofit;

    private RetrofitClient() {
    }

    /**
     * Method used to create retrofit instance
     *
     * @return instance of Retrofit
     */
    public static Retrofit getClient() {

        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
