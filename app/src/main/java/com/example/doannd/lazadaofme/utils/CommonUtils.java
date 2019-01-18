package com.example.doannd.lazadaofme.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.example.doannd.lazadaofme.R;
import com.example.doannd.lazadaofme.activities.MainActivity;

public class CommonUtils {

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialogLoading = new ProgressDialog(context);
        progressDialogLoading.setMessage(context.getString(R.string.message_dialog_loading));
        progressDialogLoading.show();
        progressDialogLoading.setIndeterminate(true);
        progressDialogLoading.setCancelable(false);
        progressDialogLoading.setCanceledOnTouchOutside(false);
        return progressDialogLoading;
    }

    public static void startMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
