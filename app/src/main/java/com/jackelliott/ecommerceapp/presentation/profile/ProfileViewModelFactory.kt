package com.jackelliott.ecommerceapp.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.profile.repository.usecases.*

class ProfileViewModelFactory(
    private val addSubscriberUseCase: AddSubscriberUseCase,
    private val removeSubscriberUseCase: RemoveSubscriberUseCase,
    private val updateSubscriberUseCase: UpdateSubscriberUseCase,
    private val loginUseCase: LoginUseCase,
    private val getLoggedInSubscriberUseCase: GetLoggedInSubscriberUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val loggedInUseCase: LoggedInUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            addSubscriberUseCase,
            removeSubscriberUseCase,
            updateSubscriberUseCase,
            loginUseCase,
            getLoggedInSubscriberUseCase,
            logoutUseCase,
            loggedInUseCase
        ) as T
    }

}