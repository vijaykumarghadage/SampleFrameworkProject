package com.cybage.mobitvassignment.framework.network;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Class used to collect response
 * Created by vijaykumargh on 29/09/2016.
 */

public class ResponseBean {
    private Call mCall;
    private Response mResponse;
    private Throwable mError;
    private int mOperationIdentifier;

    public Call getCall() {
        return mCall;
    }

    public void setCall(Call call) {
        this.mCall = call;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        this.mResponse = response;
    }

    public Throwable getError() {
        return mError;
    }

    public void setError(Throwable error) {
        this.mError = error;
    }

    public int getOperationIdentifier() {
        return mOperationIdentifier;
    }

    public void setOperationIdentifier(int operationIdentifier) {
        this.mOperationIdentifier = operationIdentifier;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "mCall=" + mCall +
                ", mResponse=" + mResponse +
                ", mError=" + mError +
                ", mOperationIdentifier=" + mOperationIdentifier +
                '}';
    }
}
