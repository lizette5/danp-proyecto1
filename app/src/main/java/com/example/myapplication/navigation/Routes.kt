package com.example.myapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    //id para realizar la navegacion
    val route: String,
    //atributos de los botones
    val title:String,  //nombre de boton
    val icon:ImageVector //icono de  boton
) {
    //creacion de los objetos
    object Ventana1 : Routes("Ventana1", "Principal", Icons.Filled.Home)
    object Ventana2 : Routes("Ventana2/?newText={newText}", "Lista", Icons.Filled.List){
        fun createRoute(newText: String) = "Ventana2/?newText=$newText"
    }
    object Ventana3 : Routes("Ventana3", "Información", Icons.Filled.Info)
    object Ventana4 : Routes("Ventana4/", "Usuario", Icons.Filled.AccountCircle)
}