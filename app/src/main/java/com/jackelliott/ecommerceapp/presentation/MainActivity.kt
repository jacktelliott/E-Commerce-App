package com.jackelliott.ecommerceapp.presentation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.presentation.cart.ShoppingCartFragment
import com.jackelliott.ecommerceapp.databinding.ActivityMainBinding
import com.jackelliott.ecommerceapp.presentation.profile.LoginFragment
import com.jackelliott.ecommerceapp.presentation.profile.ProfileViewModel
import com.jackelliott.ecommerceapp.presentation.profile.UserProfileFragment
import com.jackelliott.ecommerceapp.presentation.store.StoreFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var subscriberViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        application
        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_product_list) {
            onBookStoreClicked()
            return true
        } else if (item.itemId == R.id.nav_shopping_cart) {
            onShoppingCartClicked()
            return true
        } else if (item.itemId == R.id.nav_profile) {
            onProfileClicked()
            return true
        } else {
            return false
        }
    }

    private fun onBookStoreClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, StoreFragment())
        }
    }

    private fun onShoppingCartClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, ShoppingCartFragment())
        }
    }

    private fun onProfileClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, LoginFragment())
        }
    }

}