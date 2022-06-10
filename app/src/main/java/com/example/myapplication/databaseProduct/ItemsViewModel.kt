package com.example.myapplication.databaseProduct

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Items>>
    private val repository: ItemsRepository

    init {
        val todoDao = DatabaseData.getInstance(application).todoDao()
        repository = ItemsRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addItem(todoItem: Items) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(todoItem)
        }
    }

    fun updateItem(todoItem: Items) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateItem(todoItem = todoItem)
        }
    }

    fun deleteItem(todoItem: Items) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(todoItem = todoItem)
        }
    }

    fun deleteAllItems() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllItems()
        }
    }
}