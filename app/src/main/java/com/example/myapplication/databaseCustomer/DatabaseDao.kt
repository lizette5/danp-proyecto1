package com.example.myapplication.databaseCustomer

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.databaseCustomer.Customers

@Dao
interface DatabaseDao {
    @Query("SELECT * from customers")
    fun getAll(): LiveData<List<Customers>>
    @Query("SELECT * from customers where customerId = :id")
    fun getById(id: Int) : Customers?
    @Insert
    suspend fun insert(item: Customers)
    @Update
    suspend fun update(item: Customers)
    @Delete
    suspend fun delete(item: Customers)
    @Query("DELETE FROM customers")
    suspend fun deleteAllItems()
}