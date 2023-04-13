package com.pilkom.algopintar

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pilkom.algopintar.databinding.ActivityPreLatihanBinding

class PreLatihanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreLatihanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreLatihanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val originActivity = intent.getStringExtra("origin")
        val title = intent.getStringExtra("title")

        binding.tvTittle.text = title

        binding.apply {
            include.btnBack.setOnClickListener {
                if (originActivity == "pemilihan"){
                    startActivity(Intent(this@PreLatihanActivity, PemilihanActivity::class.java))
                    finish()
                }
                else if (originActivity == "perulangan"){
                    startActivity(Intent(this@PreLatihanActivity, PerulanganActivity::class.java))
                    finish()
                }
            }
            include.btnKeluar.setOnClickListener {
                AlertDialog.Builder(this@PreLatihanActivity)
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
                startActivity(Intent(this@PreLatihanActivity, HomepageActivity::class.java))
                finish()
            }
        }
    }
}