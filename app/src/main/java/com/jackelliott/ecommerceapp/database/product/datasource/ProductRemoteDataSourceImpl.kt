package com.jackelliott.ecommerceapp.database.product.datasource

import com.jackelliott.ecommerceapp.database.Service
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.database.product.ProductList
import retrofit2.Response

class ProductRemoteDataSourceImpl(private val service: Service) : ProductRemoteDataSource {
    override suspend fun getProducts(): Response<ProductList> = service.getProducts()
}
