package com.example.add.begibkotlin.coursepeewee.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.add.begibkotlin.R;
import com.example.add.begibkotlin.coursepeewee.manager.Contextor;
import com.example.add.begibkotlin.coursepeewee.util.MultiLanguageUtil;
import com.example.add.begibkotlin.coursepeewee.util.TypefaceUtil;
import com.example.add.begibkotlin.coursepeewee.widget.CustomSaveState;

public class CustomFontTextView extends AppCompatTextView{
    private boolean animationText = false;
    Animation animationFadeIn;
    Animation animationFadeOut;
    public CustomFontTextView(Context context) {
        super(context);
        init();
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypefaceUtil.setTypeFace(this, Contextor.getInstance().getContext(), attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        try {
            animationText = typedArray.getBoolean(R.styleable.CustomFontTextView_animationTextChange, false);

            MultiLanguageUtil.setLanguageToView(typedArray, this);
        }finally {
            typedArray.recycle();
        }
        init();
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        TypefaceUtil.setTypeFace(this, Contextor.getInstance().getContext(), null);
        animationFadeIn = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_in);
        animationFadeOut = AnimationUtils.loadAnimation(getContext(), android.R.anim.fade_out);
    }

    @Override
    public void setTextColor(int color) {
        invalidate();
        super.setTextColor(color);
    }
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        CustomSaveState saveState = new CustomSaveState(superState);
        saveState.setVisible(getVisibility());
        saveState.setText(getText().toString());
        saveState.setIsEnable(isEnabled() ? 1 : 0);
        saveState.setTag((Parcelable) getTag());
        return saveState;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        CustomSaveState saveState = (CustomSaveState) state;
        super.onRestoreInstanceState(((CustomSaveState) state).getSuperState());
        setText(saveState.getText());
        setEnabled(saveState.getIsEnable() == 1);
        setTag(saveState.getTag());
    }
}
