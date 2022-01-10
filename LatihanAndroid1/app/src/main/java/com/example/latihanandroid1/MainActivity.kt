package com.example.latihanandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var clicked = 0
    private lateinit var tulisan : TextView
    private lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.tombol)
        tulisan = findViewById(R.id.tulisan)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        if (v?.id== R.id.tombol){
            clicked++
            tulisan.text = clicked.toString()
        }
    }
}