package com.example.myapplication.databaseCustomer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.databaseCustomer.DatabaseDao
import com.example.myapplication.databaseCustomer.Customers

@Database(entities = [Customers::class], version = 2)
abstract class DatabaseData : RoomDatabase() {
    abstract fun todoDao(): DatabaseDao
    companion object {
        private var INSTANCE: DatabaseData? = null
        fun getInstance(context: Context): DatabaseData {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseData::class.java,
                        "listC_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}