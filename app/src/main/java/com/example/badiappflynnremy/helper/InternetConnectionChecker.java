package com.example.badiappflynnremy.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.badiappflynnremy.R;

public class InternetConnectionChecker {
    public static boolean isNetworkConnectionAvailable(Context context) {
        ConnectivityManager connectivityService = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityService.getActiveNetworkInfo();

        return null != networkInfo && networkInfo.isConnected();
    }

    public static void generateError(final Context context) {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {             // Closes this activity
                dialog.dismiss();
            }
        });
        dialogBuilder.setMessage(R.string.alert_description_data_fail).setTitle(R.string.alert);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
