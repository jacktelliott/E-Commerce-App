package com.jackelliott.ecommerceapp.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.jackelliott.ecommerceapp.FsApiDatabase
import com.jackelliott.ecommerceapp.database.product.ProductDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideProductDatabase() : FsApiDatabase {
        return Room.databaseBuilder(application, FsApiDatabase::class.java, "product_data_table")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideProductDao(fsApiDatabase: FsApiDatabase): ProductDAO {
        return fsApiDatabase.productDao()
    }

}