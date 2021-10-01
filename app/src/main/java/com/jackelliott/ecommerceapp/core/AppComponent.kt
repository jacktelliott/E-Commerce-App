package com.jackelliott.ecommerceapp.core

import com.jackelliott.ecommerceapp.store.StoreFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
//        AndroidInjectionModule::class,
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

    fun scInject(fragment: StoreFragment)

//    @Component.Builder
//    interface Builder {
//
//        fun build(): AppComponent
//
//        @BindsInstance
//        fun application(application: Application): Builder
//    }
}