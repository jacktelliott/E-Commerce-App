package com.jackelliott.ecommerceapp.database.profile.repository.usecases

import com.jackelliott.ecommerceapp.database.profile.repository.SubscriberRepository

class LoggedInUseCase (private val subscriberRepository: SubscriberRepository) {
    suspend fun execute() = subscriberRepository.loggedIn()
}