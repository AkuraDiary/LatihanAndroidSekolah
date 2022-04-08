package com.asthiseta.latihanfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val mName = MutableLiveData<String>()
    val name: LiveData<String>
        get() = mName
    fun setName(name: String) {
        mName.value = name
    }
}