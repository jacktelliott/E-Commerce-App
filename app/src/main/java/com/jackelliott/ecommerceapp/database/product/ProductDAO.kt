package com.jackelliott.ecommerceapp.database.product

import androidx.lifecycle.LiveData
import androidx.room.*

//Dao stands for "Data Access Object"
@Dao
interface ProductDAO {

    @Insert
    suspend fun saveProducts(products: List<Product>)

    @Query("DELETE FROM product_data_table")
    suspend fun deleteAllProducts()

    @Query("SELECT * FROM product_data_table")
    fun getAllProducts(): List<Product>

    @Update
    fun addProduct(product: Product)

    @Update
    fun removeProduct(product: Product)
}