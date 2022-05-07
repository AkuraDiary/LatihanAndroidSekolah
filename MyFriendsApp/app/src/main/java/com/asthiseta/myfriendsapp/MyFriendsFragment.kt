package com.asthiseta.myfriendsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asthiseta.myfriendsapp.adapter.MyFriendAdapter
import com.asthiseta.myfriendsapp.database.AppDatabase
import com.asthiseta.myfriendsapp.database.MyFriendsDao
import com.asthiseta.myfriendsapp.model.MyFriend
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {

    private var fab_btn: FloatingActionButton? = null
    private var listMyFriends: RecyclerView? = null
    private lateinit var listTeman: MutableList<MyFriend>
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendsDao? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.my_friends_fragment, container, false)
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

    private fun initView() {
        fab_btn = activity?.findViewById(R.id.fabAddFriend)
        listMyFriends = activity?.findViewById(R.id.listMyFriends)

        fab_btn?.setOnClickListener {
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }
        //simulasiDataTeman()
        tampilTeman()

    }

    private fun tampilTeman() {

        listMyFriends?.layoutManager = LinearLayoutManager(activity)
        listMyFriends?.adapter = MyFriendAdapter(
            requireActivity(),
            listTeman as ArrayList<MyFriend>
        )
    }

    private fun ambilDataTeman() {
        listTeman = ArrayList()

    }
    private fun tampilToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        fab_btn = null
        listMyFriends = null

    }

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
}