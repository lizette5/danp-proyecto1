package com.example.myapplication.databaseCustomer


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customers(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var customerId: Int = 0,
    @ColumnInfo(name = "customer_name")
    val customerName: String,
    @ColumnInfo(name = "customer_lastname")
    val customerLastname: String,
    @ColumnInfo(name = "customer_edad")
    val customerEdad: String,
)