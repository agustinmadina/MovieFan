package com.madina.sampleapp.ui.splash

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import com.madina.sampleapp.R
import com.madina.sampleapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by Agustin Madina on 05/09/20.
 */
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initUI()
    }

    private fun initUI() {
//        fullScreenMode()

        window.decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                // The system bars are visible.
            } else {
                // The system bars are NOT visible.
            }
        }


        ObjectAnimator.ofFloat(splash_logo, "translationX", 100f).apply {
            duration = 2000
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    // 3
                    Toast.makeText(applicationContext, "Doge took off", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAnimationEnd(animation: Animator) {
                    showMoviesScreen()
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })
            start()
        }
        // Enable ConstraintLayout to fit system windows
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    fun showMoviesScreen() {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        startActivity(MainActivity.newInstance(this))
    }
}