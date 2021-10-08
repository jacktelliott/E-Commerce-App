package com.jackelliott.ecommerceapp.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.database.product.api.App
import com.jackelliott.ecommerceapp.databinding.FragmentLoginBinding
import com.jackelliott.ecommerceapp.presentation.cart.CartViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var profileFactory: ProfileViewModelFactory
    private lateinit var binding: FragmentLoginBinding
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        profileViewModel.loggedIn().observe(viewLifecycleOwner, {
            if (it) {
                this.activity?.supportFragmentManager?.commit {
                    replace(R.id.frame_content, UserProfileFragment(email, password))
                }
            } else {
                setupButtonListeners()
            }
        })
    }

    private fun setupButtonListeners() {
        binding.buttonLogin.setOnClickListener {
            email = binding.editTextInputEmail.text.toString()
            password = binding.editTextInputPassword.text.toString()
            profileViewModel.login(
                binding.editTextInputEmail.text.toString(),
                binding.editTextInputPassword.text.toString()
            ).observe(viewLifecycleOwner, {
                Toast.makeText(this.context, "Logged In", Toast.LENGTH_LONG).show()
                this.activity?.supportFragmentManager?.commit {
                    replace(
                        R.id.frame_content,
                        UserProfileFragment(
                            binding.editTextInputEmail.text.toString(),
                            binding.editTextInputPassword.text.toString()
                        )
                    )
                }
            })
        }
        binding.buttonCreateNewAccount.setOnClickListener {
            this.activity?.supportFragmentManager?.commit {
                replace(R.id.frame_content, CreateNewAccountFragment())
            }
        }
    }

    private fun setupViewModel() {
        (activity?.application as App).appComponent
            .lInject(this)
        profileViewModel = ViewModelProvider(this, profileFactory)
            .get(ProfileViewModel::class.java)
    }
}

//****Goes in the onViewCreate method if there is a problem with the observer****

//            if (profileViewModel.login(
//                    binding.editTextInputEmail.text.toString(),
//                    binding.editTextInputPassword.text.toString()
//                )
//            ) {
////                val intent: Intent = Intent(this.context, UserProfileFragment::class.java)
//                Toast.makeText(this.context, "Logged In", Toast.LENGTH_LONG).show()
////                startActivity(intent)
//                this.activity?.supportFragmentManager?.commit {
//                    replace(
//                        R.id.frame_content,
//                        UserProfileFragment(
//                            binding.editTextInputEmail.text.toString(),
//                            binding.editTextInputPassword.text.toString()
//                        )
//                    )
//                }
//            }