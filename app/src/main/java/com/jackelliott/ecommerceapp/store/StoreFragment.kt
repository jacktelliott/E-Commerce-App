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

    private lateinit var storeBinding: FragmentStoreBinding
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
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.fragment_store, container, false)
        storeBinding = FragmentStoreBinding.bind(view)
        return storeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        recyclerView = storeBinding.root
        productViewModel.getProduct().observe(viewLifecycleOwner, {
            if (it!!.isNotEmpty()) {
                recyclerView.adapter = ProductEntryAdapter(it!!, context)
            }
        })
//        recyclerView.adapter = productViewModel.getProduct().value?.let { ProductEntryAdapter(it, context) }
    }

    private fun setupView() {
        (activity?.application as App).appComponent
            .sInject(this)
        productViewModel= ViewModelProvider(this, productFactory)
            .get(ProductViewModel::class.java)
        productViewModel.updateProduct()
    }

}