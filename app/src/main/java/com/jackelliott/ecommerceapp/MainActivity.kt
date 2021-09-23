package com.jackelliott.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationBarView
import com.jackelliott.ecommerceapp.database.SubscriberDatabase
import com.jackelliott.ecommerceapp.database.SubscriberRepository
import com.jackelliott.ecommerceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.nav_product_list) {
            onBookStoreClicked()
            return true
        } else if (item.itemId == R.id.nav_shopping_cart) {
            onShoppingCartClicked()
            return true
        } else if (item.itemId == R.id.nav_offers) {
            onOffersClicked()
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
            replace(R.id.frame_content, BookStoreFragment())
        }
    }

    private fun onShoppingCartClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, ShoppingCartFragment())
        }
    }

    private fun onOffersClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, OffersFragment())
        }
    }

    private fun onProfileClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, UserProfileFragment())
        }
    }
}