package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.asthiseta.myfriendsapp.adapter.MyFriendAdapter
import com.asthiseta.myfriendsapp.model.MyFriend
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {

    private var fab_btn: FloatingActionButton? = null
    lateinit var listTeman: MutableList<MyFriend>

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

    private fun simulasiDataTeman() {
        listTeman = ArrayList()

        listTeman.add(
            MyFriend(
                "Muhammad", "Laki-laki",
                "ade@gmail.com", "085719004268", "Bandung"
            )
        )
        listTeman.add(
            MyFriend(
                "Al Harits", "Laki-laki",
                "rifaldi@gmail.com", "081213416171", "Bandung"
            )
        )
    }

    private fun initView() {
        fab_btn = activity?.findViewById(R.id.fabAddFriend)

        fab_btn?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }

    }

    private fun tampilTeman(){
        //listMyFriends.layoutManager = LinearLayoutManager(activity)
        //listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
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