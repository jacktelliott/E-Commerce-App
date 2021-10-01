package com.jackelliott.ecommerceapp.core

import android.app.Application
import android.content.Context
import com.jackelliott.ecommerceapp.App
import com.jackelliott.ecommerceapp.ProductSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

//    @Inject
//    lateinit var application: Application

    @Singleton
    @Provides
    fun providesApplication(): Application {
        return application
    }


}