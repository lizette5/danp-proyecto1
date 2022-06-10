package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.databaseCustomer.CustomersViewModel
import com.example.myapplication.databaseProduct.ItemsViewModel
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.navigation.NavigationHost
import com.example.myapplication.presentation.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemViewModel = ViewModelProvider(this)[ItemsViewModel::class.java]
        val customerViewModel = ViewModelProvider(this)[CustomersViewModel::class.java]
        setContent {
            MainViews()

        }
    }
    @Composable
    fun MainViews() {
        val navController = rememberNavController()
        val navigationItem = listOf(
            Ventana1,
            Ventana2,
            Ventana3,
            Ventana4
        )
        //scaffold provee una plantilla de materialdesing
        //ejemplo:navigation drawables,top bar ,botton navigation etc
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    items = navigationItem
                )
            }
        ) {
            NavigationHost(navController)
        }
    }
}
