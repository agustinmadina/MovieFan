package com.madina.sampleapp.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.madina.sampleapp.R
import com.madina.sampleapp.ui.main.MainActivity
import com.madina.sampleapp.ui.utils.fullScreenMode
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
        fullScreenMode()
        splash_logo.animate().scaleX(4f).scaleY(4f)
        moveViewRight(splash_logo)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    private fun moveViewRight(view: View) {
        view.animate().translationX(1000f).apply {
            duration = 5000
            setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    showMoviesScreen()
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })
        }
    }

    fun showMoviesScreen() {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        startActivity(MainActivity.newInstance(this))
    }
}