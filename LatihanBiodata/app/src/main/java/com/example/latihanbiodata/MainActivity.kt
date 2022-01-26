package com.example.latihanbiodata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.example.latihanbiodata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Input Biodata"
        binding.btnSimpan.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_simpan){
            val nama = binding.edtNama.text.trim()
            val ttl = binding.edtTtl.text.trim()
            val alamat = binding.edtAlamat.text.trim()
            val kelas = binding.edtKelas.text.trim()
            val hobi = binding.edtHobi.text.trim()

            when{
                TextUtils.isEmpty(nama) -> {
                    binding.edtNama.error = "Field ini tidak boleh kosong"
                }
                TextUtils.isEmpty(ttl) -> {
                    binding.edtTtl.error = "Field ini tidak boleh kosong"
                }

                TextUtils.isEmpty(alamat) -> {
                    binding.edtAlamat.error = "Field ini tidak boleh kosong"
                }

                TextUtils.isEmpty(kelas) -> {
                    binding.edtKelas.error = "Field ini tidak boleh kosong"
                }

                TextUtils.isEmpty(hobi) -> {
                    binding.edtHobi.error = "Field ini tidak boleh kosong"
                }

                else -> {
                    val intent = Intent(this, TampilActivity::class.java)
                    intent.putExtra(TampilActivity.EXTRA_NAME, nama.toString())
                    intent.putExtra(TampilActivity.EXTRA_TTL, ttl.toString())
                    intent.putExtra(TampilActivity.EXTRA_ALAMAT, alamat.toString())
                    intent.putExtra(TampilActivity.EXTRA_KELAS, kelas.toString())
                    intent.putExtra(TampilActivity.EXTRA_HOBI, hobi.toString())
                    startActivity(intent)
                }
            }
        }
    }
}








