package com.jackelliott.ecommerceapp.database.product.datasource

import com.jackelliott.ecommerceapp.database.product.Product

interface ProductCacheDataSource {
    suspend fun getProductsFromCache(): List<Product>
    suspend fun saveProductsToCache(products: List<Product>)
}