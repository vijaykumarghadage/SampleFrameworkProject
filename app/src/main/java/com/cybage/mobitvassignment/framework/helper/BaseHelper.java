package com.cybage.mobitvassignment.framework.helper;

import android.util.Log;

import com.cybage.mobitvassignment.framework.network.NetworkConnector;
import com.cybage.mobitvassignment.framework.network.ResponseBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Base class for all helpers
 * Created by vijaykumargh on 28/09/2016.
 */

public abstract class BaseHelper implements Callback {

    private static final String TAG = "BaseHelper";
    private IHelper mIHelper;
    protected int mIdentifier;
    private ResponseBean responseBean = new ResponseBean();
    protected NetworkConnector mNetworkConnector;


    public BaseHelper(IHelper mIHelper, int identifier) {
        this.mIHelper = mIHelper;
        this.mIdentifier = identifier;
        responseBean.setOperationIdentifier(mIdentifier);
        mNetworkConnector = NetworkConnector.getInstance();
    }

    public IHelper getIHelper() {
        return mIHelper;
    }

    @Override
    public void onResponse(Call call, Response response) {
        Log.i(TAG, "onResponse");
        responseBean.setCall(call);
        responseBean.setResponse(response);
        mIHelper.onSuccess(responseBean);
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.i(TAG, "onFailure");
        responseBean.setCall(call);
        responseBean.setError(t);
        mIHelper.onError(responseBean);
    }
}
