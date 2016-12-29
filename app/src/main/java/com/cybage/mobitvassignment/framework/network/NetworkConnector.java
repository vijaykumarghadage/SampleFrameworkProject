package com.cybage.mobitvassignment.framework.network;

import android.content.Context;
import android.util.Log;

import com.cybage.mobitvassignment.details.model.Details;
import com.cybage.mobitvassignment.details.model.SimilarClipsList;
import com.cybage.mobitvassignment.framework.common.Utils;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.home.model.CategoryList;
import com.google.gson.Gson;

import retrofit2.Call;

/**
 * Class used to connect to network and get response
 * Created by vijaykumargh on 28/09/2016.
 */
public class NetworkConnector {

    private static final String TAG = "NetworkConnector";
    private static NetworkConnector mInstance;

    private NetworkConnector() {
    }

    public static NetworkConnector getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkConnector();
        }
        return mInstance;
    }

    /**
     * Method used to create and send request over network
     *
     * @param requestBean request body
     */
    public void createAndSendRequest(final RequestBean requestBean) {
        Context context = requestBean.getCallback().getIHelper().getContext();
        if (Utils.isNetworkAvailable(context)) {
            Log.i(TAG, "createAndSendRequest");
            ApiInterface apiInterface = (ApiInterface) RetrofitClient
                    .getClient()
                    .create(requestBean.getApiClassName());

            switch (requestBean.getRequestId()) {
                case Constants.GET_CATEGORIES:

                    Call<CategoryList> call = apiInterface.getHomeScreenCategories();
                    call.enqueue(requestBean.getCallback());
                    //TODO: Remove below code(static response) later on
                   /* new Handler().postDelayed(new Runnable() {
                        public void run() {
                            Response<CategoryList> catResponse = Response.success(getCategories());
                            requestBean.getCallback().onResponse(null, catResponse);
                        }
                    }, 3000);*/
                    break;
                case Constants.GET_DETAILS:
                    Call<Details> detailsCall = apiInterface.getDetails(requestBean
                            .getPathParametersMap().get(Constants.DETAILS_ID_KEY));

                    detailsCall.enqueue(requestBean.getCallback());

                    //TODO: Remove below code(static response) later on
                    /*new Handler().postDelayed(new Runnable() {
                        public void run() {
                            Response<Details> response = Response.success(getDetailsResponse(requestBean
                                    .getPathParametersMap().get(Constants.DETAILS_ID_KEY)));
                            requestBean.getCallback().onResponse(null, response);
                        }
                    }, 3000);*/
                    break;
                case Constants.GET_SIMILAR_CLIPS:

                    Call<SimilarClipsList> clipsCall = apiInterface.getSimilarClips(requestBean
                            .getPathParametersMap().get(Constants.SIMILAR_CLIPS_ID_KEY));

                    clipsCall.enqueue(requestBean.getCallback());

                    //TODO: Remove below code(static response) later on
                   /* Response<SimilarClipsList> scResponse = Response.success(getSimilarClipsResponse(requestBean
                            .getPathParametersMap().get(Constants.SIMILAR_CLIPS_ID_KEY)));
                    requestBean.getCallback().onResponse(null, scResponse);*/
                    break;
                default:
                    break;
            }
        } else {
            Log.e(TAG, "Network Not Available!");
            requestBean.getCallback().onFailure(null, new Exception(Constants.NETWORK_NOT_AVAILABLE));
        }
    }


    /**
     * Method returns static response for Home screen api
     *
     * @return CategoryList
     */
    public CategoryList getCategories() {
        String responseString = "{\n" +
                "\t\"Categories\": [{\n" +
                "\t\t\"CategoryTitle\": \"Main\",\n" +
                "\t\t\"MarketingTiles\": [{\n" +
                "\t\t\t\"Title\": \"Tile 1\",\n" +
                "\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/movie.jpg?alt=media&token=9744f4b2-b758-4445-9925-46beeb10b9ed\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Tile 2\",\n" +
                "\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/tv.jpg?alt=media&token=c35d5139-2f64-474d-923b-0b740162679f\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Tile 3\",\n" +
                "\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/friends.jpg?alt=media&token=73c4c651-1e42-4965-a0df-7700f31df44d\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Tile 4\",\n" +
                "\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/1.jpg?alt=media&token=8696b0dc-7bda-4d27-8230-bd482fc38fb4\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Tile 5\",\n" +
                "\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/10.jpg?alt=media&token=cfcde230-742e-426c-9ad8-cfcf70b85b18\"\n" +
                "\t\t}],\n" +
                "\t\t\"SubCategories\": [{\n" +
                "\t\t\t\"Title\": \"Resume Watching\",\n" +
                "\t\t\t\"Shows\": [{\n" +
                "\t\t\t\t\"Id\": \"i1\",\n" +
                "\t\t\t\t\"Title\": \"Prision Break\",\n" +
                "\t\t\t\t\"SubTitle\": \"PB 102\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/11.jpg?alt=media&token=24a2ad01-b822-4a31-8ed7-0d03872957c9\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"20 mins\",\n" +
                "\t\t\t\t\"IsLocked\": true\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i2\",\n" +
                "\t\t\t\t\"Title\": \"Titanic\",\n" +
                "\t\t\t\t\"SubTitle\": \"Genre\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/12.jpg?alt=media&token=0f0a78bf-b026-413b-8f65-f03481f10070\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"10 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i3\",\n" +
                "\t\t\t\t\"Title\": \"Spartans\",\n" +
                "\t\t\t\t\"SubTitle\": \"Spartans 4\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/13.jpg?alt=media&token=8d36ea63-1f0a-44ef-b47c-8e7830d05b22\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"5 mins\",\n" +
                "\t\t\t\t\"IsLocked\": true\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i4\",\n" +
                "\t\t\t\t\"Title\": \"Transformer\",\n" +
                "\t\t\t\t\"SubTitle\": \"Genre HD\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/14.jpg?alt=media&token=8865bccf-a82d-40a2-80a7-5652f4f38d77\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"3 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Recommended To You\",\n" +
                "\t\t\t\"Shows\": [{\n" +
                "\t\t\t\t\"Id\": \"i5\",\n" +
                "\t\t\t\t\"Title\": \"Friends\",\n" +
                "\t\t\t\t\"SubTitle\": \"Friends 309\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/15.jpg?alt=media&token=e23ab5b5-3ad2-4516-b006-e4c5d0b14c04\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"7 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i6\",\n" +
                "\t\t\t\t\"Title\": \"ABCD2\",\n" +
                "\t\t\t\t\"SubTitle\": \"Genre\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/2.jpg?alt=media&token=9192b907-1f83-4fc8-8801-c4a6c3699132\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"12 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i7\",\n" +
                "\t\t\t\t\"Title\": \"Bun Maska\",\n" +
                "\t\t\t\t\"SubTitle\": \"BM episode 4\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/3.jpg?alt=media&token=06867220-e6f2-4446-877b-a72f0698673d\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"18 mins\",\n" +
                "\t\t\t\t\"IsLocked\": true\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i8\",\n" +
                "\t\t\t\t\"Title\": \"Rustom\",\n" +
                "\t\t\t\t\"SubTitle\": \"HHD\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/4.jpg?alt=media&token=0443f9f4-103a-452a-a20f-832f49a56a96\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"5.9 mins\",\n" +
                "\t\t\t\t\"IsLocked\": true\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"Title\": \"Trending Topic\",\n" +
                "\t\t\t\"Shows\": [{\n" +
                "\t\t\t\t\"Id\": \"i9\",\n" +
                "\t\t\t\t\"Title\": \"KKK\",\n" +
                "\t\t\t\t\"SubTitle\": \"KKK Episode 5\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/5.jpg?alt=media&token=ef8e1936-9c84-4053-b55e-5f3dba84edbc\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"6 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i10\",\n" +
                "\t\t\t\t\"Title\": \"Natsamrat\",\n" +
                "\t\t\t\t\"SubTitle\": \"Genre xyz\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/6.jpg?alt=media&token=b4b8a38c-a620-40ba-a961-ec64bde8eecc\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"3.5 mins\",\n" +
                "\t\t\t\t\"IsLocked\": true\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i11\",\n" +
                "\t\t\t\t\"Title\": \"Freshers\",\n" +
                "\t\t\t\t\"SubTitle\": \"Freshers E-7\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/friends.jpg?alt=media&token=73c4c651-1e42-4965-a0df-7700f31df44d\",\n" +
                "\t\t\t\t\"Type\": \"TV Series\",\n" +
                "\t\t\t\t\"Duration\": \"4.5 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}, {\n" +
                "\t\t\t\t\"Id\": \"i12\",\n" +
                "\t\t\t\t\"Title\": \"MSD\",\n" +
                "\t\t\t\t\"SubTitle\": \"Genre 5\",\n" +
                "\t\t\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/11.jpg?alt=media&token=24a2ad01-b822-4a31-8ed7-0d03872957c9\",\n" +
                "\t\t\t\t\"Type\": \"Movie\",\n" +
                "\t\t\t\t\"Duration\": \"11 mins\",\n" +
                "\t\t\t\t\"IsLocked\": false\n" +
                "\t\t\t}]\n" +
                "\t\t}]\n" +
                "\t}]\n" +
                "}";
        return new Gson().fromJson(responseString, CategoryList.class);
    }

    /**
     * Method returns static response for details screen api
     *
     * @return Details object
     */
    public Details getDetailsResponse(String id) {
        String responseString = "{\n" +
                "\t\"Id\": \"i1\",\n" +
                "\t\"Title\": \"The World's Least Light-Polluted Skies\",\n" +
                "\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/movie2.jpg?alt=media&token=51f943ab-07ee-4de7-af92-06d48253a90b\",\n" +
                "\t\"Description\": \"Light-pollution also hinders astronomers to do their job. The luminous fog covers their view of the sky. And experts say that excessive lights during the night can also affect the behavior of animals such as moths, and can potentially influence the growth of pollinating plants, according to a report by Popular Science. The medical community is also looking at the potential hazards of excessive night light to human beings\",\n" +
                "\t\"Time\": \"1 day ago\",\n" +
                "\t\"Duration\": \"4 mins\",\n" +
                "\t\"SimilarClipsId\": \"clipId1\"\n" +
                "}";

        return new Gson().fromJson(responseString, Details.class);
    }

    /**
     * Method returns static response for similar clips api
     *
     * @return SimilarClipsList
     */
    public SimilarClipsList getSimilarClipsResponse(String id) {
        String responseString = "{\n" +
                "\t\"SimilarClipsId\": \"clipId1\",\n" +
                "\t\"SimilarClips\": [{\n" +
                "\t\t\"Id\": \"i20\",\n" +
                "\t\t\"Title\": \"Artic Suicides: It's Not The Dark That Kills You\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/movie.jpg?alt=media&token=9744f4b2-b758-4445-9925-46beeb10b9ed\",\n" +
                "\t\t\"Time\": \"2 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i21\",\n" +
                "\t\t\"Title\": \"Simpsons\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/tv.jpg?alt=media&token=c35d5139-2f64-474d-923b-0b740162679f\",\n" +
                "\t\t\"Time\": \"1 day ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i22\",\n" +
                "\t\t\"Title\": \"Friends\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/friends.jpg?alt=media&token=73c4c651-1e42-4965-a0df-7700f31df44d\",\n" +
                "\t\t\"Time\": \"2 days ago\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"Id\": \"i23\",\n" +
                "\t\t\"Title\": \"Artic Suicides\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/1.jpg?alt=media&token=8696b0dc-7bda-4d27-8230-bd482fc38fb4\",\n" +
                "\t\t\"Time\": \"3 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i24\",\n" +
                "\t\t\"Title\": \"Canadian nature\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/10.jpg?alt=media&token=cfcde230-742e-426c-9ad8-cfcf70b85b18\",\n" +
                "\t\t\"Time\": \"5 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i25\",\n" +
                "\t\t\"Title\": \"HPAGOF\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/11.jpg?alt=media&token=24a2ad01-b822-4a31-8ed7-0d03872957c9\",\n" +
                "\t\t\"Time\": \"2 days ago\"\n" +
                "\t},{\n" +
                "\t\t\"Id\": \"i26\",\n" +
                "\t\t\"Title\": \"AS: Europe\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/12.jpg?alt=media&token=0f0a78bf-b026-413b-8f65-f03481f10070\",\n" +
                "\t\t\"Time\": \"1.5 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i27\",\n" +
                "\t\t\"Title\": \"MR and MRs\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/13.jpg?alt=media&token=8d36ea63-1f0a-44ef-b47c-8e7830d05b22\",\n" +
                "\t\t\"Time\": \"1 day ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i28\",\n" +
                "\t\t\"Title\": \"Africa\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/14.jpg?alt=media&token=8865bccf-a82d-40a2-80a7-5652f4f38d77\",\n" +
                "\t\t\"Time\": \"5 mins ago\"\n" +
                "\t},{\n" +
                "\t\t\"Id\": \"i29\",\n" +
                "\t\t\"Title\": \"Dark that kills you\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/15.jpg?alt=media&token=e23ab5b5-3ad2-4516-b006-e4c5d0b14c04\",\n" +
                "\t\t\"Time\": \"2.5 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i30\",\n" +
                "\t\t\"Title\": \"BCCI\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/2.jpg?alt=media&token=9192b907-1f83-4fc8-8801-c4a6c3699132\",\n" +
                "\t\t\"Time\": \"1 day ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i31\",\n" +
                "\t\t\"Title\": \"ICC\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/3.jpg?alt=media&token=06867220-e6f2-4446-877b-a72f0698673d\",\n" +
                "\t\t\"Time\": \"2 mins ago\"\n" +
                "\t},{\n" +
                "\t\t\"Id\": \"i32\",\n" +
                "\t\t\"Title\": \"It's Not The Dark That Kills You\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/4.jpg?alt=media&token=0443f9f4-103a-452a-a20f-832f49a56a96\",\n" +
                "\t\t\"Time\": \"2 months ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i33\",\n" +
                "\t\t\"Title\": \"Verizon\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/5.jpg?alt=media&token=ef8e1936-9c84-4053-b55e-5f3dba84edbc\",\n" +
                "\t\t\"Time\": \"2 day ago\"\n" +
                "\t}, {\n" +
                "\t\t\"Id\": \"i34\",\n" +
                "\t\t\"Title\": \"Counter strike\",\n" +
                "\t\t\"Url\": \"https://firebasestorage.googleapis.com/v0/b/fir-testapp-1647c.appspot.com/o/6.jpg?alt=media&token=b4b8a38c-a620-40ba-a961-ec64bde8eecc\",\n" +
                "\t\t\"Time\": \"9 days ago\"\n" +
                "\t}]\n" +
                "}";

        return new Gson().fromJson(responseString, SimilarClipsList.class);
    }
}
