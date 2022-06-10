package com.example.myapplication.databaseProduct

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DatabaseDao {
    @Query("SELECT * from products")
    fun getAll(): LiveData<List<Items>>
    @Query("SELECT * from products where itemId = :id")
    fun getById(id: Int) : Items?
    @Insert
    suspend fun insert(item:Items)
    @Update
    suspend fun update(item:Items)
    @Delete
    suspend fun delete(item: Items)
    @Query("DELETE FROM products")
    suspend fun deleteAllItems()
}