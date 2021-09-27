package com.jackelliott.ecommerceapp.store

import androidx.annotation.DrawableRes

class BookEntry(
    var title: String,
    var author: String,
    var rating: Float,
    var price: Float,
    @DrawableRes var image: Int
) {

}