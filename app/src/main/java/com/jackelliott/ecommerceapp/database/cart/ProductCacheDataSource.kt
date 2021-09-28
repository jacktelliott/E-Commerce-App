package com.jackelliott.ecommerceapp.database.cart

interface ProductCacheDataSource {
    suspend fun getProductsFromCache(): List<Product>
    suspend fun saveProductsToCache(products: List<Product>)
}