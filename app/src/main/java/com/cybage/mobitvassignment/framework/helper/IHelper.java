package com.cybage.mobitvassignment.framework.helper;

import android.content.Context;

import com.cybage.mobitvassignment.framework.network.ResponseBean;

/**
 * IHelper Interface
 * Created by vijaykumargh on 28/09/2016.
 */

public interface IHelper {
    void onSuccess(ResponseBean responseBean);

    void onError(ResponseBean responseBean);

    Context getContext();

}
