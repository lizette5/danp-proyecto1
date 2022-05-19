package com.example.myapplication

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import res.drawable.*
import com.example.myapplication.navigation.Routes.*
import com.example.myapplication.navigation.NavigationHost
import com.example.myapplication.presentation.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            Ventana3
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
