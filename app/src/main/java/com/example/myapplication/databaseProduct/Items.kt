package com.example.myapplication.databaseProduct

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Items(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var itemId: Int = 0,
    @ColumnInfo(name = "item_name")
    val itemName: String,
    @ColumnInfo(name = "item_descripcion")
    val itemDescripcion: String,
    @ColumnInfo(name = "item_tipo")
    val itemTipo: String,
)