package com.jackelliott.ecommerceapp.database.cart

import retrofit2.Response

interface ProductRemoteDataSource {
    suspend fun getProducts(): Response<List<Product>>
}