package com.example.add.begibkotlin.view;


import android.content.Context;
import android.graphics.Typeface;

import com.example.add.begibkotlin.util.TypefaceUtil;

import java.util.Hashtable;

public class CustomCacheFont {
    private static Hashtable<String, Typeface> font = new Hashtable<>();

    public static Typeface getFonts(Context context, String fontName) {
        if (hasCache(fontName)) {
            return font.get(fontName);
        }

        font.put(fontName, TypefaceUtil.getTypefaceRegular(context));
        return TypefaceUtil.getTypefaceRegular(context);
    }


    private static boolean hasCache(String fontName) {
        return font.containsKey(fontName);
    }
}
