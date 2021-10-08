package com.jackelliott.ecommerceapp.database.product

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.ProductDAO


@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO

}