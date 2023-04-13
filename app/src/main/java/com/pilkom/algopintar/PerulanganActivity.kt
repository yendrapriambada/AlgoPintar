package com.pilkom.algopintar

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pilkom.algopintar.databinding.ActivityPerulanganBinding


class PerulanganActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerulanganBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerulanganBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            include.btnBack.setOnClickListener {
                startActivity(Intent(this@PerulanganActivity, HomepageActivity::class.java))
                finish()
            }
            include.btnKeluar.setOnClickListener {
                AlertDialog.Builder(this@PerulanganActivity)
                    .setIcon(R.drawable.ic_dialog_alert)
                    .setTitle("Tutup Aplikasi")
                    .setMessage("Apakah anda yakin ingin keluar dari aplikasi?")
                    .setPositiveButton("Ya") { _, _ ->
                        finishAffinity()
                    }
                    .setNegativeButton("Tidak", null)
                    .show()
            }
            include.btnHome.setOnClickListener {
                startActivity(Intent(this@PerulanganActivity, HomepageActivity::class.java))
                finish()
            }
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