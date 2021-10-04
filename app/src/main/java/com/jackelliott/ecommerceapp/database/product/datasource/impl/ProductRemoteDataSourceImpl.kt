package com.jackelliott.ecommerceapp.database.product.datasource.impl

import com.jackelliott.ecommerceapp.database.FsApiService
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.datasource.ProductRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(private val service: FsApiService) : ProductRemoteDataSource {
    override suspend fun getProducts(): Response<List<Product>> = service.getProducts()
}
