package com.chathuranga.shan.navigationcomponent1.example2

import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.chathuranga.shan.navigationcomponent1.MainActivity
import com.chathuranga.shan.navigationcomponent1.R
import kotlinx.android.synthetic.main.activity_example2.*
import kotlin.math.abs


class Example2Activity : AppCompatActivity() {

    val toolbarHeightToFloat = 147f
    val statusBarHeightToFloat = 63f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)
    }

    fun fullScreenTransition() {

        toolbar.animate().translationY(-abs(toolbarHeightToFloat)).setDuration(1000).start()
        hostFragment.view?.animate()?.translationY(-abs(toolbarHeightToFloat))?.setDuration(1000)?.start()

        hostFragment.view?.viewTreeObserver?.addOnGlobalLayoutListener(object :
            OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                hostFragment.view?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                val currentHeight = hostFragment.view?.height

                if (currentHeight != null) {

                    val totalFinishValueAnimation =
                        currentHeight + (toolbarHeightToFloat + statusBarHeightToFloat).toInt()

                    val valueAnimator = ValueAnimator.ofInt(
                        currentHeight,
                        totalFinishValueAnimation
                    )
                    valueAnimator.duration = 1000
                    valueAnimator.addUpdateListener { animation ->
                        hostFragment.view?.also {

                            hostFragment.view?.requestLayout()
                            hostFragment.view?.layoutParams?.height = animation.animatedValue as Int

                            if (animation.animatedValue == totalFinishValueAnimation) {
                                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                                window.statusBarColor = Color.TRANSPARENT
                            }
                        }
                    }
                    valueAnimator.start()
                }
            }
        })
    }

    fun generalScreenTransition(){

        toolbar.animate().translationY(abs(0f)).setDuration(1000).start()
        hostFragment.view?.animate()?.translationY(abs(0f))?.setDuration(1000)?.start()

        hostFragment.view?.viewTreeObserver?.addOnGlobalLayoutListener(object :
            OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                hostFragment.view?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                val currentHeight = hostFragment.view?.height

                if (currentHeight != null) {

                    val totalFinishValueAnimation =
                        currentHeight + (toolbarHeightToFloat + statusBarHeightToFloat).toInt()

                    val valueAnimator = ValueAnimator.ofInt(
                        totalFinishValueAnimation,
                        currentHeight
                    )
                    valueAnimator.duration = 1000
                    valueAnimator.addUpdateListener { animation ->
                        hostFragment.view?.also {

                            hostFragment.view?.requestLayout()
                            hostFragment.view?.layoutParams?.height = animation.animatedValue as Int

                            if (animation.animatedValue == totalFinishValueAnimation) {

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                                } else {
                                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
                                }

                                window.statusBarColor =
                                    ContextCompat.getColor(this@Example2Activity, R.color.colorPrimaryDark)
                            }
                        }
                    }
                    valueAnimator.start()
                }
            }
        })
    }
}