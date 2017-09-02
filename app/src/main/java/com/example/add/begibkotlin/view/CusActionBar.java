package com.example.add.begibkotlin.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import com.example.add.begibkotlin.util.Constant;


public class CusActionBar extends Toolbar{
    public CusActionBar(Context context) {
        super(context);
    }

    public CusActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CusActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init() {
        setTitle(Constant.EMPTY);
    }
}
