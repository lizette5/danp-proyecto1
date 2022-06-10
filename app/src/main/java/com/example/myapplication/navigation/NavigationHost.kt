package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.databaseCustomer.CustomersViewModel
import com.example.myapplication.databaseProduct.ItemsViewModel
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.presentation.view.Ventana1
import com.example.myapplication.presentation.view.Ventana2
import com.example.myapplication.presentation.view.Ventana3
import com.example.myapplication.presentation.view.Ventana4

@Composable
fun NavigationHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = Ventana1.route ){
        composable(Ventana1.route)
        {
            Ventana1(
                navegarPantalla2 = { newText ->
                    navController.navigate(Ventana2.createRoute(newText))
                }
            )
        }
        composable(
            Ventana2.route,
            arguments = listOf(navArgument("newText"){defaultValue=" "})
        )
        { navBackStackEntry ->
        var newText = navBackStackEntry.arguments?.getString("newText")
        val itemViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[ItemsViewModel::class.java]

        requireNotNull(newText)
        Ventana2(newText,itemViewModel)
        }
        composable(Ventana3.route)
        {
            Ventana3()
        }
        composable(Ventana4.route)
        {
            val customerViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[CustomersViewModel::class.java]
            Ventana4(customerViewModel)
        }

    }
}