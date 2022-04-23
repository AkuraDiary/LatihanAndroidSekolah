package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MyFriendsAddFragment : Fragment() {

    private var btn_save: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_friends_add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btn_save = activity?.findViewById(R.id.btnSave)
        btn_save?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsFragment()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        btn_save = null
    }

    companion object {
        fun newInstance() = MyFriendsAddFragment()
    }
}