package com.jackelliott.ecommerceapp.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_user_profile, container, false)
        binding = FragmentLoginBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
            if (profileViewModel.login(
                    binding.editTextInputEmail.text.toString(),
                    binding.editTextInputPassword.text.toString()
                )
            ) {
//                val intent: Intent = Intent.
                Toast.makeText(this.context, "Logged In", Toast.LENGTH_LONG).show()
            }
        }
    }
}