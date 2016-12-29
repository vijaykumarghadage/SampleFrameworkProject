package com.cybage.mobitvassignment.framework.common;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.network.PicassoClient;

/**
 * Utility class
 * Created by vijaykumargh on 29/09/2016.
 */

public class Utils {

    /**
     * Method used to check network connectivity
     *
     * @param context context
     * @return true if network is available
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    /**
     * Method used to show alert dialog with single button
     *
     * @param context context
     * @param title   dialog title
     * @param message message to be shown
     */
    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    /**
     * Method used to load image in to ImageView
     *
     * @param context                  context
     * @param url                      url of image
     * @param placeHolderImageDrawable placeholder image
     * @param imageView                image view
     */
    public static void loadImage(Context context, String url, int placeHolderImageDrawable, ImageView imageView) {

        PicassoClient.getClient(context)
                .getPicassoInstance()
                .load(url)
                .placeholder(placeHolderImageDrawable)
                .into(imageView);

       /* Picasso.with(context)
                .load(url)
                .placeholder(placeHolderImageDrawable)
                .into(imageView);*/
    }
}
