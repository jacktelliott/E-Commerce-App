package com.jackelliott.ecommerceapp.database.product.datasource

import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.ProductList
import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getProducts(): Response<List<Product>>
}