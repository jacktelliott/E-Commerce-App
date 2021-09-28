package com.jackelliott.ecommerceapp.database.cart

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jackelliott.ecommerceapp.database.profile.Subscriber

//Dao stands for "Data Access Object"
@Dao
interface ProductDAO {

    @Update
    suspend fun addProduct(product: Product)

    suspend fun removeProduct(Product: Product)

    @Query("SELECT * FROM product_data_table")
    fun getAllProducts(): LiveData<List<Product>>
}