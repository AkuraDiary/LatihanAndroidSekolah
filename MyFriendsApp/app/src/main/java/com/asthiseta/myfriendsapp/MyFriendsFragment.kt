package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {

    var fab_btn : FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        fab_btn = activity?.findViewById(R.id.fabAddFriend)
        fab_btn?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }
        super.onCreate(savedInstanceState)
    }

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
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
     //   this.clearFindViewByIdCache()
    }
    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
}