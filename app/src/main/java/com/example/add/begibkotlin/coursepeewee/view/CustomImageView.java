package com.example.add.begibkotlin.coursepeewee.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context) {super(context);}

    public CustomImageView(Context context, AttributeSet attrs) {super(context, attrs);}

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        final Drawable previous = getDrawable();
        super.setImageDrawable(drawable);

    }

    private static void notifyDrawable(Drawable drawable, final boolean isDisplayed) {

    }
}
