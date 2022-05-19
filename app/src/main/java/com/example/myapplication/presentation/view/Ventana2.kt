package com.example.myapplication.presentation.view


import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun Ventana2(text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5FFC7))
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color(0xFF408D44),
                fontSize = 40.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = "Conociendo sobre los productos que contaminan el planeta",
            style = TextStyle(
                color = Color(0xFF4CAF50),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )
        //animacion de aumento de tamaño
        var sizeState by remember { mutableStateOf(100.dp) }
        val sizeAnimate by animateDpAsState(
            targetValue = sizeState,
            tween(
                durationMillis = 3000,
                delayMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
        //animation cambio de color
        val infiniteTransition = rememberInfiniteTransition()
        val colorAnimate by infiniteTransition.animateColor(
            initialValue = Color(0xFFDDFCBA),
            targetValue = Color(0xFFAEDB79),
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 2000),
            )
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            // verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            items(10) {
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.bolsacolor),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Bolsa de color")
                                    }
                                }
                            )
                            Text(
                                text = "Su vida útil promedio es de 12 minutos,\n " +
                                        "se quedan en el planeta por más de 150 años"
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.bolsanegra),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Bolsa negra")
                                    }
                                }
                            )
                            Text(
                                text = "Su vida útil promedio es de 12 minutos, \n" +
                                        "se quedan en el planeta por más de 150 años"
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.ambientador),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Ambientador")
                                    }
                                }
                            )
                            Text(
                                text = "Contienen clorofluorocarburos conocidos como CFC,\n " +
                                        "sustancia que provoca el agujero en la capa de ozono."
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.papel),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Papel")
                                    }
                                }
                            )
                            Text(
                                text = "Para su producción se talan árboles, \n" +
                                        "resisten en promedio un uso, lo que no compensa su huella ambiental."
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.vasos),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Vasos de plastico")
                                    }
                                }
                            )
                            Text(
                                text = "Se desechan tras su único uso y generan grandes cantidades de basura. \n" +
                                        "Basura que no se degrada, que permanece en el ambiente y contamina."
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.capsulas),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Capsulas de cafe")
                                    }
                                }
                            )
                            Text(
                                text = "No se puede reciclar con facilidad,tarda entre 100 y 500 años en biodegradarse."
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.petroleo),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Petroleo")
                                    }
                                }
                            )
                            Text(
                                text = "Su combustión emite gases de efecto invernadero \n" +
                                        "como el dióxido de carbono (CO2) o el metano entre otros, \n" +
                                        "que se van acumulando en la atmósfera \n" +
                                        "y favoreciendo el calentamiento global."
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.toallas),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Toallas humedas")
                                    }
                                }
                            )
                            Text(
                                text = "Las fibras plásticas de las toallitas pueden tardar más de 100 años en degradarse en fragmentos aún más pequeños"
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.botella),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Botella de plastico")
                                    }
                                }
                            )
                            Text(
                                text = "Las botellas son responsables en gran parte de los residuos \n" +
                                        "contaminantes que se acumulan en el planeta, cuando se desechan,\n" +
                                        " permanecen en el ambiente cerca de 100 años o dependiendo del ambiente pueden durar mucho más."
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .size(sizeAnimate)
                        .background(colorAnimate)
                        .fillMaxWidth()
                        .padding(1.dp)
                        .clickable {},
                    elevation = 10.dp

                ) {
                    Row(modifier = Modifier
                        .clickable { sizeState += 50.dp }
                        .background(colorAnimate)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(R.drawable.tecnopor),

                            contentDescription = "Contact profile picture",
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    append("Producto: ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.W900,
                                            color = Color(0xFF4BA04E)
                                        )
                                    ) {
                                        append("Tecnopor")
                                    }
                                }
                            )
                            Text(
                                text = "Este material no es reciclable y uno de los grandes problemas\n" +
                                        " es que no se descompone y puede permanecer años contaminando zonas de nuestro planeta"
                            )
                        }
                    }
                }
            }
        }
    }
}
