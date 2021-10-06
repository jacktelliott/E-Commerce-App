package com.jackelliott.ecommerceapp.presentation.profile

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.database.profile.SubscriberRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: SubscriberRepository) : ViewModel() {

//    val subscribers = repository.subscribers
//
//    val inputName = MutableLiveData<String>()
//
//    val inputEmail = MutableLiveData<String>()
//
//    val inputPassword = MutableLiveData<String>()
//
//    fun insert(subscriber: Subscriber) = viewModelScope.launch {
//        repository.insert(subscriber)
//    }
//
//    fun update(subscriber: Subscriber) = viewModelScope.launch {
//        repository.update(subscriber)
//    }
//
//    fun delete(subscriber: Subscriber) = viewModelScope.launch {
//        repository.delete(subscriber)
//    }

}