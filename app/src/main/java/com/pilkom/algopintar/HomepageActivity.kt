package com.pilkom.algopintar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pilkom.algopintar.databinding.ActivityHomepageBinding
import com.pilkom.algopintar.databinding.ActivityIdentitasBinding

class HomepageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            menuLeaderboard.setOnClickListener {
                startActivity(Intent(this@HomepageActivity, LeaderboardActivity::class.java))
                finish()
            }
            menuPemilihan.setOnClickListener {
                startActivity(Intent(this@HomepageActivity, PemilihanActivity::class.java))
                finish()
            }
            menuPerulangan.setOnClickListener {
                startActivity(Intent(this@HomepageActivity, PerulanganActivity::class.java))
                finish()
            }
//            include.btnMenu.setOnClickListener {
//                binding.include.motionLayout.start()
//            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}