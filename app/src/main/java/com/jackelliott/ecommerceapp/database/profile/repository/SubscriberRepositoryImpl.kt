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

    override suspend fun login(email: String, password: String): Boolean {
        var subscribers: List<Subscriber> = getSubscribersFromCache()
        for (subscriber in subscribers) {
            if (subscriber.email == email && subscriber.password == password) {
                subscriberCacheDataSource.setLoggedIn(true)
                return true
            }
        }
        return false
    }

    override suspend fun getLoggedInSubscriber(email: String, password: String): Subscriber {
        var subscribers: List<Subscriber> = getSubscribersFromCache()
        for (subscriber in subscribers) {
            if (subscriber.email == email && subscriber.password == password) {
                return subscriber
            }
        }
        Log.i("getLoggedInSubscriber", "Logged in a subscriber that doesn't exist")
        return Subscriber("", email, password, "")
    }

    override suspend fun logout() {
        subscriberCacheDataSource.setLoggedIn(false)
    }

    override suspend fun loggedIn(): Boolean {
        return subscriberCacheDataSource.getLoggedIn()
    }

    suspend fun getSubscribersFromCache(): List<Subscriber> {
        var subscriberList: List<Subscriber> = arrayListOf()
        try {
            subscriberList =
                getSubscribersFromDB()//subscriberCacheDataSource.getSubscribersFromCache()
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