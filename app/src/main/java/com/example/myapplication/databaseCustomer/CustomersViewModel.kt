package com.example.myapplication.databaseCustomer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.databaseCustomer.DatabaseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CustomersViewModel (application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Customers>>
    private val repository: CustomersRepository

    init {
        val todoDao = DatabaseData.getInstance(application).todoDao()
        repository = CustomersRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addCustomer(todoItem: Customers) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCustomer(todoItem)
        }
    }

    fun updateCustomer(todoItem: Customers) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCustomer(todoItem = todoItem)
        }
    }

    fun deleteCustomer(todoItem: Customers) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCustomer(todoItem = todoItem)
        }
    }

    fun deleteAllCustomer() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCustomer()
        }
    }
}