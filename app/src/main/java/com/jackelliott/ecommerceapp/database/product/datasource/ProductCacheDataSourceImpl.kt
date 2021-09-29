package com.jackelliott.ecommerceapp.database.product.datasource

import com.jackelliott.ecommerceapp.database.product.Product

class ProductCacheDataSourceImpl : ProductCacheDataSource {

    private var productList = ArrayList<Product>()

    override suspend fun getProductsFromCache(): List<Product> {
        return productList
    }

    override suspend fun saveProductsToCache(products: List<Product>) {
        productList.clear()
        productList = ArrayList(products)
    }
}