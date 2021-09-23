package com.jackelliott.ecommerceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jackelliott.ecommerceapp.database.SubscriberDatabase
import com.jackelliott.ecommerceapp.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
}