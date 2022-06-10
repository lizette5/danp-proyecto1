package com.example.myapplication.databaseCustomer

import androidx.lifecycle.LiveData
import com.example.myapplication.databaseCustomer.DatabaseDao
import com.example.myapplication.databaseCustomer.Customers

class CustomersRepository (private val databaseDao: DatabaseDao) {
    val readAllData : LiveData<List<Customers>> =  databaseDao.getAll()
    suspend fun addCustomer(todoItem: Customers) {
        databaseDao.insert(todoItem)
    }
    suspend fun updateCustomer(todoItem: Customers) {
        databaseDao.update(todoItem)
    }
    suspend fun deleteCustomer(todoItem: Customers) {
        databaseDao.delete(todoItem)
    }
    suspend fun deleteAllCustomer() {
        databaseDao.deleteAllItems()
    }
}