package com.example.myapplication.databaseProduct

import androidx.lifecycle.LiveData

class ItemsRepository(private val databaseDao: DatabaseDao) {
    val readAllData : LiveData<List<Items>> =  databaseDao.getAll()
    suspend fun addItem(todoItem: Items) {
        databaseDao.insert(todoItem)
    }
    suspend fun updateItem(todoItem: Items) {
        databaseDao.update(todoItem)
    }
    suspend fun deleteItem(todoItem: Items) {
        databaseDao.delete(todoItem)
    }
    suspend fun deleteAllItems() {
        databaseDao.deleteAllItems()
    }
}