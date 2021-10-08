package com.jackelliott.ecommerceapp.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.database.product.api.App
import com.jackelliott.ecommerceapp.databinding.FragmentUserProfileBinding
import javax.inject.Inject

class UserProfileFragment(private val email: String, private val password: String) : Fragment() {

    @Inject
    lateinit var profileFactory: ProfileViewModelFactory
    private lateinit var binding: FragmentUserProfileBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_user_profile, container, false)
        binding = FragmentUserProfileBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        profileViewModel.getLoggedInSubscriber(email, password).observe(viewLifecycleOwner, {
            binding.textViewProfileName.text = it.name
            binding.textViewEmail.text = it.email
            binding.textViewPhoneNumber.text = it.number
        })
    }

    private fun setupViewModel() {
        (activity?.application as App).appComponent
            .pInject(this)
        profileViewModel = ViewModelProvider(this, profileFactory)
            .get(ProfileViewModel::class.java)
    }
}