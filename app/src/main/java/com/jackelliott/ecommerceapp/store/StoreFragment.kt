package com.jackelliott.ecommerceapp.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.App
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.cart.CartViewModel
import com.jackelliott.ecommerceapp.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.databinding.FragmentStoreBinding
import com.jackelliott.ecommerceapp.databinding.ItemProductBinding
import javax.inject.Inject

class StoreFragment : Fragment(){

    private lateinit var binding: FragmentStoreBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var productViewModel: ProductViewModel
    private lateinit var cartViewModel: CartViewModel
    @Inject
    lateinit var productFactory: ProductViewModelFactory
    @Inject
    lateinit var cartFactory: CartViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewStore
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.item_product, container, false)
        var binding: ItemProductBinding = ItemProductBinding.bind(view)
        setupView()
        recyclerView.adapter = productViewModel.getProduct().value?.let { ProductEntryAdapter(it, context) }
        return binding.root
    }

    private fun setupView() {
        (activity?.application as App).appComponent
            .sInject(this)
        productViewModel= ViewModelProvider(this, productFactory)
            .get(ProductViewModel::class.java)
        productViewModel.updateProduct()
    }

}