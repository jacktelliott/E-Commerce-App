package com.jackelliott.ecommerceapp.database.product

import androidx.lifecycle.LiveData
import androidx.room.*

//Dao stands for "Data Access Object"
@Dao
interface ProductDAO {

    @Update
    suspend fun saveProducts(products: List<Product>)

    suspend fun deleteAllProducts()

    @Query("SELECT * FROM product_data_table")
    fun getAllProducts(): List<Product>
}