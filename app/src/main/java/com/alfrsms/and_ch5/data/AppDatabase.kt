package com.alfrsms.and_ch5.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alfrsms.and_ch5.data.user.dao.UserDao
import com.alfrsms.and_ch5.data.user.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDatabaseDao() : UserDao

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "challenge5.db").build()
                }
                return instance
            }
        }
    }
}