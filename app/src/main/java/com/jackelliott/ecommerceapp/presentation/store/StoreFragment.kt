package com.jackelliott.ecommerceapp.presentation.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.database.product.api.App
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.presentation.cart.CartViewModel
import com.jackelliott.ecommerceapp.presentation.cart.CartViewModelFactory
import com.jackelliott.ecommerceapp.databinding.FragmentStoreBinding
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
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.fragment_store, container, false)
        binding = FragmentStoreBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        recyclerView = binding.root
        productViewModel.getProduct().observe(viewLifecycleOwner, {
            if (it.isEmpty()){
                productViewModel.updateProduct()
            }
            if (it!!.isNotEmpty()) {
                recyclerView.adapter = ProductAdapter(it!!, context, productViewModel)
            }
        })
//        recyclerView.adapter = productViewModel.getProduct().value?.let { ProductEntryAdapter(it, context) }
    }

    private fun setupViewModel() {
        (activity?.application as App).appComponent
            .sInject(this)
        productViewModel= ViewModelProvider(this, productFactory)
            .get(ProductViewModel::class.java)
//        productViewModel.updateProduct()
    }

}