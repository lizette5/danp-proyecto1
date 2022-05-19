package com.example.myapplication.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.navigation.Routes

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Routes> //acceso a nuestros item de routes
) {
    val currentRoute = currentRoute(navController)
    BottomNavigation(
        backgroundColor = Color(0XFF38993C),
        contentColor = Color.White
    ) {
        items.forEach { view ->
            BottomNavigationItem(
                icon = { Icon(imageVector = view.icon, contentDescription = view.title) },
                label = { Text(view.title) },
                //si la ruta actual es igual al item q se slecciono
                selected = currentRoute == view.route,
                onClick = {
                    navController.navigate(view.route) {
                        //cada vez q se navegue en la barra de navegacion
                        //elimina la pila de navegacion para no generar controversias
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        //si el usuario presiona un mismo elemento de forma continua
                        //no se genera una pila de navegacion extensa
                        launchSingleTop = true
                        //restoreState = true //para restaurar datos y bloque las ventanas
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}