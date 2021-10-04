package com.jackelliott.ecommerceapp.database.product.cart

import com.jackelliott.ecommerceapp.database.product.Product
import dagger.Provides

interface CartRepository {
    suspend fun removeProduct(product: Product): List<Product>?
    suspend fun getProductsInCart(): List<Product>?
}