package com.example.latihanbiodata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanbiodata.databinding.ActivityTampilBinding

class TampilActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTampilBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTampilBinding.inflate(layoutInflater)
        supportActionBar?.title = "Tampil Biodata"
        setContentView(binding.root)

        val nama = intent.getStringExtra(EXTRA_NAME)
        val ttl = intent.getStringExtra(EXTRA_TTL)
        val alamat = intent.getStringExtra(EXTRA_ALAMAT)
        val kelas = intent.getStringExtra(EXTRA_KELAS)
        val hobi = intent.getStringExtra(EXTRA_HOBI)

        binding.apply {
            tampilNama.text = getString(R.string.tampil_nama, nama)
            tampilTtl.text = getString(R.string.tampil_ttl, ttl)
            tampilKelas.text = getString(R.string.tampil_kelas, kelas)
            tampilAlamat.text = getString(R.string.tampil_alamat, alamat)
            tampilHobi.text = getString(R.string.tampil_hobi, hobi)
        }
    }

    companion object{
        const val EXTRA_NAME = "extra_nama"
        const val EXTRA_TTL = "extra_ttl"
        const val EXTRA_ALAMAT = "extra_alamat"
        const val EXTRA_KELAS = "extra_kelas"
        const val EXTRA_HOBI = "extra_hobi"
    }

}