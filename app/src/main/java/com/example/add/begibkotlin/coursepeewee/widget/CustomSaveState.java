package com.example.add.begibkotlin.coursepeewee.widget;


import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.view.View;

public class CustomSaveState extends View.BaseSavedState {
    private int isVisible;
    private String text;
    private int isChecked;
    private int isEnable;
    private int isFocus;
    private Parcelable tag;

    public CustomSaveState(Parcel source) {
        super(source);
        isVisible = source.readInt();
        text = source.readString();
        isChecked = source.readInt();
        isEnable = source.readInt();
        isFocus = source.readInt();
        tag = source.readBundle(getClass().getClassLoader());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public CustomSaveState(Parcel source, ClassLoader loader) {
        super(source, loader);
    }

    public CustomSaveState(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(isVisible);
        out.writeString(text);
        out.writeInt(isChecked);
        out.writeInt(isEnable);
        out.writeInt(isFocus);
        out.writeParcelable(tag, 0);
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new CustomSaveState(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new CustomSaveState[size];
        }
    };
    public int getVisible() {
        return isVisible;
    }

    public void setVisible(int visible) {
        this.isVisible = visible;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public int getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(int isFocus) {
        this.isFocus = isFocus;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Parcelable tag) {
        this.tag = tag;
    }

}
