package com.example.latihanintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.latihanintent.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var rgNumber : RadioGroup
    private lateinit var binding : ActivityMoveForResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnChoose = binding.btnChoose
        rgNumber = binding.rgNumber

        btnChoose.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
}