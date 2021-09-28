package com.jackelliott.ecommerceapp.database.cart

interface ProductLocalDataSource {
    suspend fun getProductsFromDB(): List<Product>
    suspend fun saveProductsToDB(products:List<Product>)
    suspend fun clearAll()
}