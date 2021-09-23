package com.jackelliott.ecommerceapp

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jackelliott.ecommerceapp.database.Subscriber
import com.jackelliott.ecommerceapp.database.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        repository.insert(subscriber)
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

}