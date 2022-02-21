package com.example.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanintent.databinding.ActivityMoveWithObjectBinding

class MoveWithObjectActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    private lateinit var binding : ActivityMoveWithObjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email}, \nAge : ${person.age}, \nLocation : ${person.city}"
        binding.tvObjectReceived.text = text
    }
}