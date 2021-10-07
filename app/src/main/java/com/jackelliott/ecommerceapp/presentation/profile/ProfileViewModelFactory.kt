package com.jackelliott.ecommerceapp.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.profile.repository.AddSubscriberUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.LoginUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.RemoveSubscriberUseCase
import com.jackelliott.ecommerceapp.database.profile.repository.UpdateSubscriberUseCase

class ProfileViewModelFactory(
    private val addSubscriberUseCase: AddSubscriberUseCase,
    private val removeSubscriberUseCase: RemoveSubscriberUseCase,
    private val updateSubscriberUseCase: UpdateSubscriberUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            addSubscriberUseCase,
            removeSubscriberUseCase,
            updateSubscriberUseCase,
            loginUseCase
        ) as T
    }

}