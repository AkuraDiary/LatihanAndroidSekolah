package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.asthiseta.myfriendsapp.database.AppDatabase
import com.asthiseta.myfriendsapp.database.MyFriendsDao

class MyFriendsAddFragment : Fragment() {
    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var alamatInput: String = ""
    private var genderInput: String = ""
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendsDao? = null

    private var btn_save: Button? = null
    private var spinnerGender : Spinner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_friends_add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendDao = db?.friendDao()
    }

    private fun setDataSpinnerGener() {
        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.gender_list,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerGender?.adapter = adapter
    }

    private fun initView() {
        spinnerGender = activity?.findViewById(R.id.spinnerGender)
        btn_save = activity?.findViewById(R.id.btnSave)
        btn_save?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsFragment()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        btn_save = null
        spinnerGender = null
    }

    companion object {
        fun newInstance() = MyFriendsAddFragment()
    }
}