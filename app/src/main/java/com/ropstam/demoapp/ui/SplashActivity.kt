package com.ropstam.demoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ropstam.demoapp.R
import com.ropstam.demoapp.databinding.ActivitySplashBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val backgroundImage = binding.appLogo
        val animation = AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in)
        backgroundImage.startAnimation(animation)


        Handler().postDelayed({
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }

        }, 2000) // 3000 is the delayed time in milliseconds.
    }



}