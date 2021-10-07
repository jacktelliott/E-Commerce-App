package com.jackelliott.ecommerceapp.database.profile.datasource

import com.jackelliott.ecommerceapp.database.profile.Subscriber

interface SubscriberCacheDataSource {
    suspend fun saveSubscribersToCache(subscriber: Subscriber)
    suspend fun getSubscriber(): Subscriber
}