package com.example.add.begibkotlin.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.add.begibkotlin.R;
import com.example.add.begibkotlin.view.CustomCacheFont;

public class TypefaceUtil {

    public static final String BOLD = "BOLD";
    public static final String REGULAR = "REGULAR";

    public static void setTypeFace(TextView textView, Context context, AttributeSet attrs) {
        if (!textView.isInEditMode()) {
            int attrTextStyle = Typeface.NORMAL;
            if (attrs != null) {
                int[] attributer = new int[]{android.R.attr.textStyle};
                TypedArray typedArray = context.obtainStyledAttributes(attrs, attributer);
                attrTextStyle = typedArray.getInt(0,0);
                typedArray.recycle();
            }

            Typeface typeface = textView.getTypeface();
            AssetManager assetManager = context.getAssets();

            if (typeface != null) {
                if ((typeface.getStyle() & Typeface.BOLD) == Typeface.BOLD || (attrTextStyle & Typeface.BOLD) == Typeface.BOLD) {
                    textView.setTypeface(TypefaceUtil.getTypeface(BOLD, assetManager));
                }else {
                    textView.setTypeface(CustomCacheFont.getFonts(context, REGULAR));
                }
            }
            textView.setTypeface(CustomCacheFont.getFonts(context, REGULAR));
        }
        textView.invalidate();
    }
    private static Typeface getTypeface(String style, AssetManager assetManager) {
        if (style.equals(BOLD)) {
            return Typeface.createFromAsset(assetManager, "fonts/DTAC2013_Bl.ttf");
        } else {
            return Typeface.createFromAsset(assetManager, "fonts/DTAC2013_Rg.ttf");
        }
    }
    public static Typeface getTypefaceRegular(Context context) {
        return Typeface.createFromAsset(context.getAssets(), Constant.TypeFace.typeFacePathRegular);
    }
}
