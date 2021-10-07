package com.jackelliott.ecommerceapp.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private lateinit var binding: FragmentUserProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.fragment_user_profile, container, false)

//        val dao = SubscriberDatabase.getInstance(this.requireContext()).subscriberDAO
//        val repository = SubscriberRepository(dao)
//        val factory = ProfileViewModelFactory(repository)
//        profileViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
        binding = FragmentUserProfileBinding.bind(view)
        return binding.root
    }
}