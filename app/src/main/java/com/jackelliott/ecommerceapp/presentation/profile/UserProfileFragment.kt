package com.jackelliott.ecommerceapp.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.database.profile.SubscriberDatabase
import com.jackelliott.ecommerceapp.database.profile.SubscriberRepository
import com.jackelliott.ecommerceapp.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)

        val dao = SubscriberDatabase.getInstance(this.requireContext()).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = ProfileViewModelFactory(repository)
        profileViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)

        return binding.root
    }
}