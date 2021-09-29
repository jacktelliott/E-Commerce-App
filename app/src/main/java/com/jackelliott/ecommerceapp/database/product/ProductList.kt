package com.jackelliott.ecommerceapp.database.product

import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("products")
    val products: List<Product>
)