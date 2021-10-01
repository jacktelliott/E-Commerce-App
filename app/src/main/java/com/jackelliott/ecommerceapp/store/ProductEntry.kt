package com.jackelliott.ecommerceapp.store

import androidx.annotation.DrawableRes

class ProductEntry(
    var title: String,
    var description: String,
    var rating: Float,
    var price: Float,
    @DrawableRes var image: Int
) {

}