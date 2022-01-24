package com.example.latihanbiodata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanbiodata.databinding.ActivityMainBinding
import com.example.latihanbiodata.databinding.ActivityTampilBinding

class TampilActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTampilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTampilBinding.inflate(layoutInflater)
        supportActionBar?.title = "Tampil Biodata"
        setContentView(binding.root)

    }

}