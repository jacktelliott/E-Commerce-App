package com.jackelliott.ecommerceapp.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.App
import com.jackelliott.ecommerceapp.databinding.FragmentShoppingCartBinding
import com.jackelliott.ecommerceapp.store.ProductViewModel
import com.jackelliott.ecommerceapp.store.ProductViewModelFactory
import javax.inject.Inject

class ShoppingCartFragment : Fragment() {

    private lateinit var binding: FragmentShoppingCartBinding
    private lateinit var cartViewModel: CartViewModel
    @Inject lateinit var cartFactory: CartViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        setupList()

        //possibly move to Shopping Cart
//        (activity as Injector).createProductSubComponent()
//            .inject(this)
//        (activity?.application as App).appComponent
//            .scInject(this)
//        productViewModel=ViewModelProvider(this, factory)
//            .get(ProductViewModel::class.java)
//        productViewModel.updateProduct().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//        })



        return binding.root
    }

    private fun setupList() {
        var recyclerView: RecyclerView = binding.recyclerViewShoppingCart

        (activity?.application as App).appComponent
            .scInject(this)
        cartViewModel= ViewModelProvider(this, cartFactory)
            .get(CartViewModel::class.java)
    }

}