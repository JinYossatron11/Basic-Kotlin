package com.example.add.begibkotlin.coursepeewee.widget.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import com.example.add.begibkotlin.R;
import com.example.add.begibkotlin.coursepeewee.util.TypefaceUtil;

public class CustomAlertDialog {
    private static String TAG = CustomAlertDialog.class.getSimpleName();

    private Activity activity;

    public CustomAlertDialog(Activity activity) {
        this.activity = activity;
    }

    public void show(String message) {
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton(R.string.ok, (dialogOnClick, which) -> activity.finish())
                .setNegativeButton(R.string.ok, (dialogOnClick, which) -> {
                }).show();
        customFonts(activity, dialog);
    }

    public void showPositiveButton(String message, DialogInterface.OnClickListener listener) {
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton(R.string.ok, listener).show();
        customFonts(activity, dialog);
    }

    private static void customFonts(Activity activity, AlertDialog dialog) {
        try {
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setTypeface(TypefaceUtil.getTypefaceRegular(activity));
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTypeface(TypefaceUtil.getTypefaceRegular(activity));
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTypeface(TypefaceUtil.getTypefaceRegular(activity));
        } catch (Exception e) {
            Log.d(TAG, "font not found");
        }
    }
}
