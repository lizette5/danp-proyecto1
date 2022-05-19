package com.example.myapplication.presentation.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun Ventana3()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5FFC7))
            .padding(16.dp),

        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //animation cambio de color
        val infiniteTransition= rememberInfiniteTransition()
        val colorAnimation by infiniteTransition.animateColor(
            initialValue = Color(0xFF98F59C),
            targetValue = Color(0xFF439646),
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 3000),
            )
        )
        Text(
            text ="Informate más",
            style = TextStyle(color= Color(0xFF4CAF50),fontSize=42.sp,fontWeight=FontWeight.Black)

        )
        Image(
            painter = painterResource(R.drawable.info2),
            contentDescription = "Contact profile picture",
        )
        Text(
            text = "Esta aplicación tiene el objetivo de informar sobre los productos que contaniman el medio ambiente." +
                    "La contaminación ambiental es un fenómeno que afecta directa e indirectamente la salud de las poblaciones, " +
                    "no sólo de seres humanos, pues también altera el equilibrio de los ecosistemas." +
                    "En general, las personas y los animales de vida silvestre están expuestos a mezclas de más de dos sustancias tóxicas.",
            style = TextStyle(
                color = Color(0xFF4CAF50),
                textAlign = TextAlign.Justify,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )
        )
        Text(
            text ="El planeta esta en tus manos...Tú decides",
            style = TextStyle(color= colorAnimation,fontSize=50.sp,fontWeight=FontWeight.Black, textAlign = TextAlign.Center)

        )
    }
}