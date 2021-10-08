package com.jackelliott.ecommerceapp.database.profile.repository.usecases

import com.jackelliott.ecommerceapp.database.profile.repository.SubscriberRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val subscriberRepository: SubscriberRepository) {
    suspend fun execute(email: String, password: String) =
        subscriberRepository.login(email, password)
}