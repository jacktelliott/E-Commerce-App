package com.jackelliott.ecommerceapp.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jackelliott.ecommerceapp.databinding.FragmentShoppingCartBinding
import com.jackelliott.ecommerceapp.store.BookEntry
import java.util.*

class ShoppingCartFragment : Fragment() {

    private lateinit var binding: FragmentShoppingCartBinding
    lateinit var shoppingList: Hashtable<BookEntry, Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        setupList()
        return binding.root
    }

    private fun setupList() {
    }

}