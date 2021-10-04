package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.presentation.cart.ShoppingCartFragment
import com.jackelliott.ecommerceapp.presentation.store.StoreFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        FactoryModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

//    fun productSubComponent(): ProductSubComponent.Factory

    fun sInject(fragment: StoreFragment)
    fun scInject(fragment: ShoppingCartFragment)

//    @Component.Builder
//    interface Builder {
//
//        fun build(): AppComponent
//
//        @BindsInstance
//        fun application(application: Application): Builder
//    }
}