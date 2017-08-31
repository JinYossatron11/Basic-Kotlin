package com.example.add.begibkotlin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.example.add.begibkotlin.R;
import com.example.add.begibkotlin.util.MultiLanguageUtil;
import com.example.add.begibkotlin.util.TypefaceUtil;

public class CustomCheckBox extends AppCompatCheckBox{
    public CustomCheckBox(Context context) {
        super(context);
        TypefaceUtil.setTypeFace(this, context, null);
    }

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceUtil.setTypeFace(this, context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        try {
            MultiLanguageUtil.setLanguageToView(typedArray, this);
        }finally {
            typedArray.recycle();
        }
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCheckBox);
        try {
            boolean enableCheckbox = typedArray.getBoolean(R.styleable.CustomCheckBox_android_enabled, true);
            if (!enableCheckbox) {
                setButtonDrawable(R.drawable.c_custom_checkbox_disble);
                setTextColor(ContextCompat.getColor(getContext(), R.color.disableCheckBox));
                setChecked(false);
            }
        }finally {
            typedArray.recycle();
        }
    }
    public CustomCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypefaceUtil.setTypeFace(this, context, attrs);
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (!enabled) {
            setButtonDrawable(R.drawable.c_custom_checkbox_disble);
            setTextColor(ContextCompat.getColor(getContext(), R.color.disableCheckBox));
            setChecked(false);
            invalidate();
        }
        super.setEnabled(enabled);
    }
}
