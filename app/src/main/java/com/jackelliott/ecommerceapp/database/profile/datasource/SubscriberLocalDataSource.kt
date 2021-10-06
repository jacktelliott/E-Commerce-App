package com.jackelliott.ecommerceapp.database.profile.datasource

import com.jackelliott.ecommerceapp.database.profile.Subscriber

interface SubscriberLocalDataSource {
    suspend fun getSubscribersFromDB(): List<Subscriber>
    suspend fun addSubscribertoDB(subscriber: Subscriber)
    suspend fun removeSubscriberFromDB(subscriber: Subscriber)
}