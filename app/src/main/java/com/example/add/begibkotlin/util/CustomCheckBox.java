package com.example.add.begibkotlin.util;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;

import com.example.add.begibkotlin.view.TypefaceUtil;

public class CustomCheckBox extends AppCompatCheckBox{
    public CustomCheckBox(Context context) {
        super(context);
        TypefaceUtil.setTypeface(this, context, null);
    }
}
