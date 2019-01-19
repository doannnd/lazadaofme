package com.example.doannd.lazadaofme.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.activities.MainActivity;

public class CommonUtils {

    public static void showAlertDialog(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.error_message_title));
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setNegativeButton(context.getString(R.string.lable_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
