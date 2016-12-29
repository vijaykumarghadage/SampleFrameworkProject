package com.cybage.mobitvassignment.framework.ui;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.helper.IHelper;
import com.cybage.mobitvassignment.framework.network.ResponseBean;

/**
 * Base class for all fragments
 * Created by vijaykumargh on 28/09/2016.
 */

public abstract class BaseFragment extends Fragment implements IHelper {

    private static final String TAG = "BaseFragment";
    private ProgressDialog mProgressDialog;

    protected abstract void onSuccessPostAction(ResponseBean responseBean);

    protected abstract void onErrorPostAction(ResponseBean responseBean);


    @Override
    public void onSuccess(ResponseBean responseBean) {
        Log.i(TAG, "onSuccess");
        onSuccessPostAction(responseBean);
    }

    @Override
    public void onError(ResponseBean responseBean) {
        Log.i(TAG, "onError");
        if (responseBean.getError().getMessage().equalsIgnoreCase(Constants.NETWORK_NOT_AVAILABLE)) {
            stopProgressDialog();
            Log.e(TAG, "Response: " + responseBean.getError().getMessage());
            handleException(getString(R.string.alert), getString(R.string.network_not_available));
        } else {
            onErrorPostAction(responseBean);
        }
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    /**
     * Method used to handle exception dialog
     *
     * @param title   title
     * @param message message
     */
    protected void handleException(String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                        getActivity().finish();
                    }
                });
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /**
     * Method used to show progress bar
     *
     * @param message message to be shown
     */
    public void showProgressDialog(Context context, String message) {
        mProgressDialog = ProgressDialog.show(context, "", message, true);
        mProgressDialog.setCancelable(false);
    }

    /**
     * Method used to stop the progress bar
     */
    public void stopProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.cancel();
        }
    }




   /* *//**
     * Method used to load image in to ImageView
     *
     * @param url                      url of image
     * @param placeHolderImageDrawable placeholder image
     * @param imageView                image view
     *//*
    public void loadImage(String url, int placeHolderImageDrawable, ImageView imageView) {
        Picasso.with(getActivity())
                .load(url)
                .placeholder(placeHolderImageDrawable)
                .into(imageView);
    }*/

}
