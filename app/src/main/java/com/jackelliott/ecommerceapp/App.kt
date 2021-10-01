package com.jackelliott.ecommerceapp

import android.app.Application
import com.jackelliott.ecommerceapp.core.*
import com.jackelliott.ecommerceapp.database.RetrofitInstance
import retrofit2.converter.gson.GsonConverterFactory.create
import javax.inject.Inject

class App :Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.builder()
//            .appModule(AppModule(applicationContext))
//            .netModule(NetModule(RetrofitInstance.BASE_URL))
//            .remoteDataModule(RemoteDataModule())
//            .build()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this as Application))
            .databaseModule(DatabaseModule(this as Application))
            .build()
    }
//
//    override fun createProductSubComponent(): ProductSubComponent {
//        return appComponent.productSubComponent().create()
//    }

}