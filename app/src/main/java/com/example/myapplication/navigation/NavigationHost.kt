package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.presentation.view.Ventana1
import com.example.myapplication.presentation.view.Ventana2
import com.example.myapplication.presentation.view.Ventana3
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
        requireNotNull(newText)
        Ventana2(newText)
        }
        composable(Ventana3.route)
        {
            Ventana3()
        }

    }
}