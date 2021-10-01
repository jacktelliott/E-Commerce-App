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
import com.jackelliott.ecommerceapp.databinding.FragmentStoreBinding
import com.jackelliott.ecommerceapp.databinding.ItemProductBinding
import javax.inject.Inject

class StoreFragment : Fragment(){

    private lateinit var binding: FragmentStoreBinding
    private lateinit var productViewModel: ProductViewModel
    @Inject
    lateinit var factory: ProductViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        setupView()
        setupOnClickListener(container)
        return binding.root
    }

    private fun setupOnClickListener(container: ViewGroup?) {
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.item_product, container, false)
        var binding: ItemProductBinding = ItemProductBinding.bind(view)

    }

    private fun setupView() {
        var recyclerView: RecyclerView = binding.recyclerViewBookStore
//        recyclerView.adapter = ProductEntryAdapter()

        (activity?.application as App).appComponent
            .scInject(this)
        productViewModel= ViewModelProvider(this, factory)
            .get(ProductViewModel::class.java)
        productViewModel.updateProduct().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            //display the products
            recyclerView.adapter = it?.let { it1 -> ProductEntryAdapter(it1) }
        })
    }

}