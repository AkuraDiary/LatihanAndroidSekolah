package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {

    var fab_btn: FloatingActionButton? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.my_friends_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        fab_btn = activity?.findViewById(R.id.fabAddFriend)

        fab_btn?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fab_btn = null

    }

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
}