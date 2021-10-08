package com.jackelliott.ecommerceapp.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.database.product.api.App
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.databinding.FragmentShoppingCartBinding
import javax.inject.Inject

class ShoppingCartFragment : Fragment() {

    private lateinit var binding: FragmentShoppingCartBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartViewModel: CartViewModel

    @Inject
    lateinit var cartFactory: CartViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_shopping_cart, container, false)
//        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        binding = FragmentShoppingCartBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        recyclerView = binding.recyclerViewShoppingCart
        cartViewModel.getProductsInCart().observe(viewLifecycleOwner, {
            if (it!!.isNotEmpty()) {
                recyclerView.adapter = CartAdapter(
                    it,
                    context,
                    cartViewModel,
                    this,
                    view,
                    savedInstanceState
                )
            } else {
                recyclerView.adapter = CartAdapter(
                    listOf(),
                    context,
                    cartViewModel,
                    this,
                    view,
                    savedInstanceState
                )
            }
        })
    }

    private fun setupViewModel() {
        (activity?.application as App).appComponent
            .scInject(this)
        cartViewModel = ViewModelProvider(this, cartFactory)
            .get(CartViewModel::class.java)
    }

}