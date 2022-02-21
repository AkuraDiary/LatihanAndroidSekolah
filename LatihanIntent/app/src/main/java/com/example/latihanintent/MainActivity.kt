package com.example.latihanintent

import android.content.Intent
import android.net.Uri
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
        val btnMoveWithDataActivity = binding.btnMoveActivityData
        val btnDialNumber = binding.btnDialNumber
        val btnMoveObject = binding.btnMoveActivityObject

        btnDialNumber.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data ->{
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)

                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME_DUA, "Seta")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE_DUA, 17)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081214747968"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
        }
    }
}