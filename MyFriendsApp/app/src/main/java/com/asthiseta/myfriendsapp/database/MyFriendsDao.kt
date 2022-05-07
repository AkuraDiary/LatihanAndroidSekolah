package com.asthiseta.myfriendsapp.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asthiseta.myfriendsapp.model.MyFriend

@Dao
interface MyFriendsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friend: MyFriend)

    @Query("SELECT * FROM MyFriend")
    fun ambilSemuaTeman(): LiveData<List<MyFriend>>
}