package com.example.memorygame

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.graphics.toColorInt

enum class State {
    DOWN,
    UP,
    MATCHED
}

data class Card (var myContext: Context, var value: String) : AppCompatTextView (myContext)
{
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        setMeasuredDimension(width, width)
    }

    var tileState: State = State.UP

    fun updateTile ()
    {
        val oa1 = ObjectAnimator.ofFloat(this, "rotationY", 0f, 90f)
        val oa2 = ObjectAnimator.ofFloat(this, "rotationY", 90f, 0f)

        oa1.duration = 250
        oa2.duration = 250

        oa1.interpolator = DecelerateInterpolator ()
        oa2.interpolator = AccelerateInterpolator ()

        oa1.addListener(object : AnimatorListenerAdapter ()
        {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)

                when (tileState)
                {
                    State.DOWN ->
                    {
                        this@Card.text = "\uD83E\uDDFA"
                        this@Card.setBackgroundColor("#FFF291".toColorInt())
                    }
                    State.UP ->
                    {
                        this@Card.text = this@Card.value
                        this@Card.setBackgroundColor(Color.WHITE)
                    }
                    State.MATCHED ->
                    {
                        this@Card.text = this@Card.value
                        this@Card.setBackgroundColor("#9CFF91".toColorInt())
                    }
                }

                oa2.start()
            }
        })

        oa1.start()
    }
}

class AppData {
    companion object {
        var difficulty: Int = 4
    }
}