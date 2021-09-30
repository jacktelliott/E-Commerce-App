package com.jackelliott.ecommerceapp.database.product.datasource.impl

import com.jackelliott.ecommerceapp.database.Service
import com.jackelliott.ecommerceapp.database.product.ProductList
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val service: Service) : ProductRemoteDataSource {
    override suspend fun getProducts(): Response<ProductList> = service.getProducts()
}
