package com.cybage.mobitvassignment.framework.network;

import com.cybage.mobitvassignment.framework.helper.BaseHelper;

import java.util.Map;

/**
 * Class contains information needed to create request
 * Created by vijaykumargh on 29/09/2016.
 */

public class RequestBean {

    private int mRequestId;
    private Class mApiClassName;
    private Class mModelClassName;
    private BaseHelper mCallback;
    private Map<String, String> mPathParametersMap;


    public int getRequestId() {
        return mRequestId;
    }

    public void setRequestId(int requestId) {
        this.mRequestId = requestId;
    }

    public Class getApiClassName() {
        return mApiClassName;
    }

    public void setApiClassName(Class className) {
        this.mApiClassName = className;
    }

    public BaseHelper getCallback() {
        return mCallback;
    }

    public void setCallback(BaseHelper callback) {
        this.mCallback = callback;
    }


    public Map<String, String> getPathParametersMap() {
        return mPathParametersMap;
    }

    public void setPathParametersMap(Map<String, String> pathParametersMap) {
        this.mPathParametersMap = pathParametersMap;
    }

    public Class getModelClassName() {
        return mModelClassName;
    }

    public void setModelClassName(Class modelClassName) {
        this.mModelClassName = modelClassName;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "mRequestId=" + mRequestId +
                ", mApiClassName=" + mApiClassName +
                ", mCallback=" + mCallback +
                ", mPathParametersMap=" + mPathParametersMap +
                '}';
    }
}
