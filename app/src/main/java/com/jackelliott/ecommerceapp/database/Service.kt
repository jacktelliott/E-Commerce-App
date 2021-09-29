package com.jackelliott.ecommerceapp.database

import com.jackelliott.ecommerceapp.database.product.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("/products")
    suspend fun getProducts(): Response<ProductList>
}