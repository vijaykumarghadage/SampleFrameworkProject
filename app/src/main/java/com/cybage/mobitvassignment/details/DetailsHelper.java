package com.cybage.mobitvassignment.details;

import com.cybage.mobitvassignment.details.model.Details;
import com.cybage.mobitvassignment.details.model.SimilarClipsList;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.helper.BaseHelper;
import com.cybage.mobitvassignment.framework.helper.IHelper;
import com.cybage.mobitvassignment.framework.network.ApiInterface;
import com.cybage.mobitvassignment.framework.network.RequestBean;

import java.util.HashMap;

/**
 * Helper class for details module
 * Created by vijaykumargh on 30/09/2016.
 */

public class DetailsHelper extends BaseHelper {

    public DetailsHelper(IHelper mIHelper, int identifier) {
        super(mIHelper, identifier);
    }

    /**
     * Method used to retrieve details
     *
     * @param id id
     */
    public void getDetails(String id) {
        RequestBean requestBean = new RequestBean();
        requestBean.setCallback(this);
        requestBean.setApiClassName(ApiInterface.class);
        requestBean.setModelClassName(Details.class);
        requestBean.setRequestId(mIdentifier);
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put(Constants.DETAILS_ID_KEY, id);
        requestBean.setPathParametersMap(pathParams);
        mNetworkConnector.createAndSendRequest(requestBean);
    }

    /**
     * Method used to get similar clips
     *
     * @param similarClipsId id
     */
    public void getSimilarClips(String similarClipsId) {
        RequestBean requestBean = new RequestBean();
        requestBean.setCallback(this);
        requestBean.setApiClassName(ApiInterface.class);
        requestBean.setModelClassName(SimilarClipsList.class);
        requestBean.setRequestId(mIdentifier);
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put(Constants.SIMILAR_CLIPS_ID_KEY, similarClipsId);
        requestBean.setPathParametersMap(pathParams);
        mNetworkConnector.createAndSendRequest(requestBean);
    }
}
