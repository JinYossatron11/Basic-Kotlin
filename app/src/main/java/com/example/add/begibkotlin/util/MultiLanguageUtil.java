package com.example.add.begibkotlin.util;

import android.content.res.TypedArray;
import android.util.Log;
import android.widget.TextView;

import com.example.add.begibkotlin.R;
import com.example.add.begibkotlin.coursepeewee.manager.Contextor;

public class MultiLanguageUtil {
    public static void setLanguageToView(TypedArray typedArray, TextView view) {
        int textResId = typedArray.getResourceId(R.styleable.CustomFontTextView_android_text, 0);
        int hintResId = typedArray.getResourceId(R.styleable.CustomFontTextView_android_hint, 0);

        if (textResId != 0) {
            try {
                view.setText(Contextor.getInstance().getContext().getString(textResId));
            } catch (Exception e) {
                Log.w("MultiLanguageUtil", "Not found Message ID #0x" + Integer.toHexString(textResId) + " to set text");
            }
        }
        if (hintResId != 0) {
            try {
                view.setHint(Contextor.getInstance().getContext().getString(hintResId));
            } catch (Exception e) {
                Log.w("MultiLanguageUtil", "Not found Message ID #0x" + Integer.toHexString(hintResId) + " to set hint");
            }
        }
    }
}
