package com.asthiseta.myfriendsapp.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import androidx.lifecycle.LiveData
import com.asthiseta.myfriendsapp.model.MyFriend

@Dao
interface MyFriendsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friend: MyFriend)

    @Query("SELECT * FROM MyFriend")
    fun ambilSemuaTeman(): LiveData<List<MyFriend>>
}