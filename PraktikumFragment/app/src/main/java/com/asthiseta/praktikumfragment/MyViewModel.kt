package com.asthiseta.praktikumfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val mName = MutableLiveData<String>()
    private val mALamat = MutableLiveData<String>()
    private val mTelp = MutableLiveData<String>()

    val name: LiveData<String>
        get() = mName

    val alamat: LiveData<String>
        get() = mALamat

    val telp: LiveData<String>
        get() = mTelp

    fun setAlamat(alamat: String) {
        mALamat.value = alamat
    }

    fun setTelp(telp: String) {
        mTelp.value = telp
    }

    fun setName(name: String) {
        mName.value = name
    }
}