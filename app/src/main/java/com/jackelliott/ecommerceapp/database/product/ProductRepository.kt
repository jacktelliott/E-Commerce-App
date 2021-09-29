package com.jackelliott.ecommerceapp.database.product

interface ProductRepository {
    suspend fun getProducts(): List<Product>?
    suspend fun updateProducts(): List<Product>?
}