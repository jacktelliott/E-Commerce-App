package com.jackelliott.ecommerceapp.presentation

import com.jackelliott.ecommerceapp.presentation.cart.ShoppingCartFragment
import com.jackelliott.ecommerceapp.database.product.core.ProductModule
import dagger.Subcomponent

@ProductScope
@Subcomponent(modules = [ProductModule::class])
interface ProductSubComponent {

    //maybe use main activity instead of fragment if problems occur
    fun inject(fragment: ShoppingCartFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProductSubComponent
    }

}