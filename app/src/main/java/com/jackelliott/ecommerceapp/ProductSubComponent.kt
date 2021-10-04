package com.jackelliott.ecommerceapp

import com.jackelliott.ecommerceapp.cart.ShoppingCartFragment
import com.jackelliott.ecommerceapp.core.ProductModule
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