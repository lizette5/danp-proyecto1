package com.example.myapplication.presentation.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun Ventana1(navegarPantalla2: (String) -> Unit) {

    var textValue by remember { mutableStateOf("") }
    //animation cambio de color
    val infiniteTransition= rememberInfiniteTransition()
    val colorAnimation by infiniteTransition.animateColor(
        initialValue = Color(0xFF98F59C),
        targetValue = Color(0xFF439646),
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 3000),
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5FFC7))
            .padding(16.dp),

        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido a EcologiaVerde",
            style = TextStyle(
                color= colorAnimation,
                fontSize = 35.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Contact profile picture",
        )
        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Introduce tu nombre (opcional)") }
        )
        Button(
            onClick = { navegarPantalla2(textValue) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF38993C))
        ) {
            Text(
                text = "Ingresar",
                color= Color(0xFFFFFFFF)
            )

        }
    }
}