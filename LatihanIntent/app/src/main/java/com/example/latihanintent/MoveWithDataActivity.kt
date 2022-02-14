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

        val name2 = intent.getStringExtra(EXTRA_NAME_DUA)
        val age2 = intent.getIntExtra(EXTRA_AGE_DUA, 0)

        val text = "Name1 : $name, \nYour Age : $age \nName2 : $name2, \nAges : $age2"
        tvDataRecieved.text = text
    }


    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NAME_DUA = "nama lagi"
        const val EXTRA_AGE_DUA = "umur lagi"
    }
}