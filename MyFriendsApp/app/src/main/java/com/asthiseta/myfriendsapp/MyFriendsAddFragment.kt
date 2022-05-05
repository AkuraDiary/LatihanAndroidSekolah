package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.asthiseta.myfriendsapp.database.AppDatabase
import com.asthiseta.myfriendsapp.database.MyFriendsDao
import com.asthiseta.myfriendsapp.model.MyFriend
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MyFriendsAddFragment : Fragment() {
    //variables
    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var alamatInput: String = ""
    private var genderInput: String = ""
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendsDao? = null

    //views component
    private var edtName : EditText? = null
    private var edtEmail : EditText? = null
    private var edtTelp : EditText? = null
    private var edtAddress : EditText? = null
    private var btn_save: Button? = null
    private var spinnerGender: Spinner? = null


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

    private fun setDataSpinnerGender() {
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

    private fun validasiInput() {
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()

        telpInput = edtTelp?.text.toString()
        alamatInput = edtAddress?.text.toString()
        genderInput = spinnerGender?.selectedItem.toString()
        when {
            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"

                genderInput.equals("Pilih kelamin") -> tampilToast("Kelamin harus dipilih")

            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"

                telpInput.isEmpty() -> edtTelp?.error = "Telp tidak boleh kosong"

                alamatInput.isEmpty() -> edtAddress?.error = "Alamat tidak boleh kosong"
            else -> {
                val teman = MyFriend(
                    nama = namaInput, kelamin =
                    genderInput, email = emailInput, telp = telpInput, alamat =
                    alamatInput
                )
                tambahDataTeman(teman)
            }
        }
    }


    private fun tambahDataTeman(teman: MyFriend): Job {
        return GlobalScope.launch {
            myFriendDao?.tambahTeman(teman)
            (activity as MainActivity).tampilMyFriendsFragment()
        }
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