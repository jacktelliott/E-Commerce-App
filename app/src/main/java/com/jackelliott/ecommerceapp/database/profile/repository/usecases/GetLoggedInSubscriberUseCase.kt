package com.jackelliott.ecommerceapp.database.profile.repository.usecases

import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.repository.SubscriberRepository
import javax.inject.Inject

class GetLoggedInSubscriberUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute(email: String, password: String) = subscriberRepository.getLoggedInSubscriber(email, password)
}