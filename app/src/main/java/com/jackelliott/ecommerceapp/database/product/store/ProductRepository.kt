package com.jackelliott.ecommerceapp.database.product.store

import com.jackelliott.ecommerceapp.database.product.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>?
    suspend fun updateProducts(): List<Product>?
    suspend fun addProduct(product: Product): List<Product>?
}