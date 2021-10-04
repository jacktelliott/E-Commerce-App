package com.jackelliott.ecommerceapp.database.product.datasource

import com.jackelliott.ecommerceapp.database.product.Product

interface ProductLocalDataSource {
    suspend fun getProductsFromDB(): List<Product>
    suspend fun saveProductsToDB(products:List<Product>)
    suspend fun clearAll()
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
}