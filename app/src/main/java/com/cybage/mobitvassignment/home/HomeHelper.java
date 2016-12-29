package com.cybage.mobitvassignment.home;

import com.cybage.mobitvassignment.framework.helper.BaseHelper;
import com.cybage.mobitvassignment.framework.helper.IHelper;
import com.cybage.mobitvassignment.framework.network.ApiInterface;
import com.cybage.mobitvassignment.framework.network.RequestBean;
import com.cybage.mobitvassignment.home.model.CategoryList;

/**
 * Helper class for Home
 * Created by vijaykumargh on 29/09/2016.
 */

public class HomeHelper extends BaseHelper {

    public HomeHelper(IHelper ihelper, int identifier) {
        super(ihelper, identifier);
    }

    /**
     * Method used to get categories
     */
    public void getCategories() {
        RequestBean requestBean = new RequestBean();
        requestBean.setCallback(this);
        requestBean.setApiClassName(ApiInterface.class);
        requestBean.setModelClassName(CategoryList.class);
        requestBean.setRequestId(mIdentifier);
        mNetworkConnector.createAndSendRequest(requestBean);
    }

}

