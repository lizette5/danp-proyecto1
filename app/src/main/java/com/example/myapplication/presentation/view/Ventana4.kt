package com.example.myapplication.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.databaseCustomer.Customers
import com.example.myapplication.databaseCustomer.CustomersViewModel


@Composable
fun Ventana4 (CustomersViewModel: CustomersViewModel) {
    Column(
    modifier = Modifier
    .fillMaxSize()
    .background(Color(0xFFE5FFC7))
    .padding(16.dp),
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row {
            Text(
                text = "Usuarios",
                style = TextStyle(
                    color = Color(0xFF4CAF50),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
            )
        }

        val itemList = CustomersViewModel.readAllData.observeAsState(arrayListOf())
        Scaffold(modifier = Modifier.height(550.dp),
            backgroundColor = Color(0xFFE5FFC7),
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    backgroundColor = Color(0xFF4BA04E),

                    text = {
                        Text(text = "Producto", color = Color.White)
                    },

                    onClick = {
                        val customer = mutableListOf(
                            "Ana",
                            "Luis",
                            "Wanser",
                            "Lizette",
                            "Fabiola"
                        )
                        val name = customer.random()
                        val customerl = mutableListOf(
                            "Fernandez",
                            "Ordoñez",
                            "Flores",
                            "Herrera",
                            "Aliaga",
                            "Quispe"

                        )
                        val last = customerl.random()
                        val numbers = mutableListOf(5, 1, 2, 3, 4, 6, 9, 7, 10)
                        val edad = numbers.random()
                        CustomersViewModel.addCustomer(
                            Customers(
                                customerName = name,
                                customerLastname = last,
                                customerEdad ="20" ,

                                ),
                        )
                    }, icon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "image",
                            tint = Color.White
                        )
                    })
            },
            content = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        items(
                            items = itemList.value, itemContent = {
                                Row(
                                    modifier = Modifier
                                        .background(Color(0xFFDCFCB8))
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 18.dp), content = {
                                        val color = Color(0xFF4BA04E)
                                        Box(
                                            content = {
                                                Text(
                                                    text = (it.customerName?: "")[0].uppercase(),
                                                    fontSize = 24.sp,
                                                    color = Color(0xFF4BA04E)
                                                )
                                            }, modifier = Modifier
                                                .size(80.dp)
                                                .border(
                                                    width = 1.2.dp,
                                                    color = color,
                                                    shape = CircleShape
                                                ),
                                            contentAlignment = Alignment.Center
                                        )
                                        Spacer(modifier = Modifier.size(16.dp))
                                        Column(
                                            modifier = Modifier.weight(2F),
                                            content = {
                                                Spacer(modifier = Modifier.size(8.dp))
                                                Text(
                                                    text = it.customerName?.uppercase()?: "",
                                                    color = color,
                                                    fontSize = 16.sp,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                                Text(
                                                    text = "${it.customerLastname}",
                                                    color = Color.Black,
                                                    fontSize = 14.6.sp
                                                )
                                                Text(
                                                    text = "${it.customerEdad}",
                                                    color = Color.Gray,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            })

                                        Spacer(modifier = Modifier.size(16.dp))
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "image",
                                            tint = Color(0xFF4BA04E), modifier = Modifier
                                                .size(30.dp)
                                                .clickable(onClick = {
                                                    CustomersViewModel.updateCustomer(it)
                                                })
                                        )

                                        Spacer(modifier = Modifier.size(16.dp))
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "image",
                                            tint = Color(0xFF4BA04E), modifier = Modifier
                                                .size(30.dp)
                                                .clickable(onClick = {
                                                    CustomersViewModel.deleteCustomer(it)
                                                })
                                        )
                                    })
                            })
                    })
            })
    }
}