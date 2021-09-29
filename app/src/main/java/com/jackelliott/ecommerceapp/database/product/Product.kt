package com.jackelliott.ecommerceapp.database.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_data_table")
data class Product (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    val id: Int,

    @ColumnInfo (name = "product_name")
    val name: String,

    @ColumnInfo (name = "product_quantity")
    val quantity: Int,
        )