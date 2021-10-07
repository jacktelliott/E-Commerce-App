package com.jackelliott.ecommerceapp.database.profile.repository

import android.util.Log
import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberCacheDataSource
import com.jackelliott.ecommerceapp.database.profile.datasource.SubscriberLocalDataSource
import java.lang.Exception
import javax.inject.Inject

class SubscriberRepositoryImpl @Inject constructor(
    private val subscriberLocalDataSource: SubscriberLocalDataSource,
    private val subscriberCacheDataSource: SubscriberCacheDataSource
) : SubscriberRepository {

    override suspend fun addSubscriber(subscriber: Subscriber) {
        subscriberCacheDataSource.saveSubscribersToCache(subscriber)
        subscriberLocalDataSource.addSubscriberToDB(subscriber)
    }

    override suspend fun updateSubscriber(subscriber: Subscriber) {
        subscriberCacheDataSource.saveSubscribersToCache(subscriber)
        subscriberLocalDataSource.updateSubscriber(subscriber)
    }

    override suspend fun removeSubscriber(subscriber: Subscriber) {
        subscriberLocalDataSource.removeSubscriberFromDB(subscriber)
    }

    override suspend fun login(email: String, password: String) : Boolean {
        if (subscriberCacheDataSource.getSubscriber().email == email
            && subscriberCacheDataSource.getSubscriber().password == password) {
            return true
        } else {
            var subscribers: List<Subscriber> = getSubscribersFromCache()
            for (subscriber in subscribers) {
                if (subscriber.email == email && subscriber.password == password) {
                    return true
                }
            }
            return false
        }
    }

    suspend fun getSubscribersFromCache(): List<Subscriber> {
        var subscriberList: List<Subscriber> = arrayListOf()
        try {
            subscriberList = getSubscribersFromDB()//subscriberCacheDataSource.getSubscribersFromCache()
            if (subscriberList.isNotEmpty()) {
                return subscriberList
            }
        } catch (exception: Exception) {
            Log.i("getSubscribersFromCache", exception.message.toString())
        }
        return subscriberList
    }

    suspend fun getSubscribersFromDB(): List<Subscriber> {
        var subscriberList: List<Subscriber> = arrayListOf()
        try {
            subscriberList = subscriberLocalDataSource.getSubscribersFromDB()
            if (subscriberList.isNotEmpty()) {
                return subscriberList
            }
        } catch (exception: Exception) {
            Log.i("getsubscribersFromDB", exception.message.toString())
        }
        return subscriberList
    }
}