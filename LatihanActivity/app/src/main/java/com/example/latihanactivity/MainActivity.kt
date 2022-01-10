package com.example.latihanactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_calculate){
            var inputLen = edtLength.text.toString().trim()
            var inputWidth = edtWidth.text.toString().trim()
            var inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (TextUtils.isEmpty(inputLen)){
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            var length = convertToDouble(inputLen)
            var width = convertToDouble(inputWidth)
            var height = convertToDouble(inputHeight)

            if (length == null){
                isInvalidDouble = true
                edtLength.error = "nilai tidak valid"
            }
            if (width == null){
                isInvalidDouble = true
                edtWidth.error = "nilai tidak valid"
            }

            if (height == null){
                isInvalidDouble = true
                edtHeight.error = "nilai tidak valid"
            }

            if(!isEmptyFields && !isInvalidDouble){
                var volume = height!! * length!! * length
                tvResult.text = volume.toString()
            }
        }
    }

    private fun convertToDouble(str: String):Double?{
        return try {
            str.toDouble()
        }catch (e : NumberFormatException){
            null
        }
    }
}