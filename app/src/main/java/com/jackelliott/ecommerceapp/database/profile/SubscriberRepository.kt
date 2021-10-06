package com.jackelliott.ecommerceapp.database.profile

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.SubscriberDAO

interface SubscriberRepository { //(private val dao: SubscriberDAO) {

    suspend fun addSubscriber(subscriber: Subscriber)
    suspend fun updateSubscriber(subscriber: Subscriber)
    suspend fun removeSubscriber(subscriber: Subscriber)


//    val subscribers = dao.getAllSubscribers()
//
//    suspend fun insert(subscriber: Subscriber) {
//        dao.insertSubscriber(subscriber)
//    }
//
//    suspend fun update(subscriber: Subscriber) {
//        dao.updateSubscriber(subscriber)
//    }
//
//    suspend fun delete(subscriber: Subscriber) {
//        dao.deleteSubscriber(subscriber)
//    }
}