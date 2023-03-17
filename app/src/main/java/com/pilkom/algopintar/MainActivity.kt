package com.pilkom.algopintar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pilkom.algopintar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()
    }

    private fun playAnimation() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvState.text = getString(R.string.start)
        }, DELAY_STATUS)

        Handler(Looper.getMainLooper()).postDelayed({
            val hideProgressBar =
                ObjectAnimator.ofFloat(binding.progressBar, View.ALPHA, 0f).setDuration(500)
            val hideIconApp =
                ObjectAnimator.ofFloat(binding.icAlgopintar, View.ALPHA, 0f).setDuration(500)
            val hideTvState =
                ObjectAnimator.ofFloat(binding.tvState, View.ALPHA, 0f).setDuration(500)

            val showIconApp =
                ObjectAnimator.ofFloat(binding.icAlgopintar, View.ALPHA, 1f).setDuration(500)
            val showTvState =
                ObjectAnimator.ofFloat(binding.tvState, View.ALPHA, 1f).setDuration(500)
            val showImgStart =
                ObjectAnimator.ofFloat(binding.imgStart, View.ALPHA, 1f).setDuration(500)

            AnimatorSet().apply {
                playTogether(hideProgressBar, hideIconApp, hideTvState)
                start()
            }

            AnimatorSet().apply {
                playSequentially(
                    hideProgressBar,
                    showIconApp,
                    showTvState,
                    showImgStart
                )
                start()
            }
        }, DELAY)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    companion object {
        private const val DELAY: Long = 3000
        private const val DELAY_STATUS: Long = 4000
    }
}