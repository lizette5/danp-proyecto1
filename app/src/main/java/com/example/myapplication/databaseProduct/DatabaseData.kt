package com.example.myapplication.databaseProduct

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Items::class], version = 1)
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
                        "list_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}