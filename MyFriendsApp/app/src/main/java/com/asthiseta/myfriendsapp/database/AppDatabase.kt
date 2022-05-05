package com.asthiseta.myfriendsapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.asthiseta.myfriendsapp.model.MyFriend

@Database(entities = [MyFriend::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun friendDao(): MyFriendsDao

    companion object {
        var INSTANCE: AppDatabase? = null
        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE =

                        Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "MyFriendAppDB"
                        ).build()

                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}