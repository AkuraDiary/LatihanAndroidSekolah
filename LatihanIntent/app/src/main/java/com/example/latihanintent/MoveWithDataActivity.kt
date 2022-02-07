package com.example.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanintent.databinding.ActivityMoveWithDataBinding

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMoveWithDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvDataRecieved = binding.tvDataReceived

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Name : $name, \nYour Age : $age"
        tvDataRecieved.text = text
    }


    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
}