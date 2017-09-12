package com.example.add.begibkotlin.coursepeewee.widget.view


import android.content.Context
import android.content.res.TypedArray
import android.os.Parcelable
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.manager.Contextor
import com.example.add.begibkotlin.coursepeewee.util.MultiLanguageUtil
import com.example.add.begibkotlin.coursepeewee.util.TypefaceUtil
import com.example.add.begibkotlin.coursepeewee.widget.CustomSaveState

class CustomFontButton : AppCompatButton {
    private var animationText = false
    constructor(context: Context) : super(context) {
        TypefaceUtil.setTypeFace(this, Contextor.getInstance().context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        TypefaceUtil.setTypeFace(this, Contextor.getInstance().context,attrs)

        val typedArray : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView)
        try {
            animationText = typedArray.getBoolean(R.styleable.CustomFontTextView_animationTextChange, false)
            MultiLanguageUtil.setLanguageToView(typedArray, this)
        }finally {
            typedArray.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        TypefaceUtil.setTypeFace(this, Contextor.getInstance().context, attrs)
    }


    override fun setText(text : CharSequence, type : BufferType) {
        super.setText(text, type)

        if (animationText) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in)
            startAnimation(animation)
            invalidate()
        }
    }

    override fun onSaveInstanceState() : Parcelable  {
        val superState : Parcelable  = super.onSaveInstanceState()
        val saveState : CustomSaveState = CustomSaveState(superState)
        saveState.visible = visibility
        saveState.text = text.toString()
        return saveState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val saveState : CustomSaveState = (CustomSaveState(state))
        super.onRestoreInstanceState(state)
        text = saveState.text
    }
}
