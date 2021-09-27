package com.jackelliott.ecommerceapp.database.profile

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jackelliott.ecommerceapp.database.profile.Subscriber

//Dao stands for "Data Access Object"
@Dao
interface SubscriberDAO {

    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber)

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers(): LiveData<List<Subscriber>>

}