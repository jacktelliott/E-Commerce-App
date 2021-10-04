package com.jackelliott.ecommerceapp.core

import android.app.Application
import dagger.Module
import dagger.Provides
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