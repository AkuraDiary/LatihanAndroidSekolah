package com.example.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.latihanintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnMoveActivity = binding.btnMoveActivity
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when{
            // TODO:  
        }
    }
}