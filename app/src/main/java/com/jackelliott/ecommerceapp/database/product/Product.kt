package com.jackelliott.ecommerceapp.database.product

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.InputStream

@Entity(tableName = "product_data_table")
data class Product (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo (name = "title")
    val title: String,

    @ColumnInfo (name = "price")
    val price: Float,

    @ColumnInfo (name = "description")
    val description: String,

//    @ColumnInfo (name = "category")
//    val category: String,

    @ColumnInfo (name = "image")
    val image: String,

//    @ColumnInfo (name = "rating")
//    val rating: Float,

    @ColumnInfo (name = "quantity")
    var quantity: Int = 0
        )