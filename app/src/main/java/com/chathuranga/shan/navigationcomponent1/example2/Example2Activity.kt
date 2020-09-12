package com.chathuranga.shan.navigationcomponent1.example2

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import com.chathuranga.shan.navigationcomponent1.R
import kotlinx.android.synthetic.main.activity_example2.*
import kotlin.math.roundToInt


class Example2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)
    }

    fun animateToolBar() {

        toolbar.animate().translationY(-147f).setDuration(1000).start()
        hostFragment.view?.animate()?.translationY(-147f)?.setDuration(1000)?.start()

        hostFragment.view?.viewTreeObserver?.addOnGlobalLayoutListener(object :
            OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                hostFragment.view?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                val currentHeight = hostFragment.view?.height

                if (currentHeight != null) {

                    val valueAnimator = ValueAnimator.ofInt(currentHeight, currentHeight+147)
                    valueAnimator.duration = 1000
                    valueAnimator.addUpdateListener { animation ->
                        hostFragment.view?.also {

                            hostFragment.view?.layoutParams?.height = animation.animatedValue as Int
                            hostFragment.view?.requestLayout()

                        }
                    }
                    valueAnimator.start()
                }
            }
        })
    }
}