package com.jackelliott.ecommerceapp.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.room.PrimaryKey
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.database.product.api.App
import com.jackelliott.ecommerceapp.database.profile.Subscriber
import com.jackelliott.ecommerceapp.databinding.FragmentCreateNewAccountBinding
import javax.inject.Inject

class CreateNewAccountFragment : Fragment() {

    @Inject
    lateinit var profileFactory: ProfileViewModelFactory
    private lateinit var binding: FragmentCreateNewAccountBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_create_new_account, container, false)
        binding = FragmentCreateNewAccountBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        binding.buttonCreateNewAccount.setOnClickListener {
            if (
                binding.editTextInputEmail.equals("")
                || binding.editTextInputPassword.equals("")
                || binding.editTextInputName.equals("")
                || binding.editTextInputNumber.equals("")
            ) {
                Toast.makeText(this.activity, "Must input all values!", Toast.LENGTH_LONG).show()
            } else {
                var subscriber: Subscriber = Subscriber(
                    binding.editTextInputName.text.toString(),
                    binding.editTextInputEmail.text.toString(),
                    binding.editTextInputPassword.text.toString(),
                    binding.editTextInputNumber.text.toString()
                )
                profileViewModel.addSubscriber(subscriber)
                Toast.makeText(this.activity, "New Account Created!", Toast.LENGTH_LONG).show()
                this.activity?.supportFragmentManager?.commit {
                    replace(R.id.frame_content, LoginFragment())
                }
            }
        }
    }

    private fun setupViewModel() {
        (activity?.application as App).appComponent
            .caInject(this)
        profileViewModel = ViewModelProvider(this, profileFactory)
            .get(ProfileViewModel::class.java)
    }
}