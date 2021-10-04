package com.jackelliott.ecommerceapp.database

import com.jackelliott.ecommerceapp.database.product.Product
import retrofit2.Response
import retrofit2.http.GET

interface FsApiService {

    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>
}