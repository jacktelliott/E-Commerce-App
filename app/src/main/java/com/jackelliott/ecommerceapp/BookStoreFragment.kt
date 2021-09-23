package com.jackelliott.ecommerceapp

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.databinding.FragmentBookStoreBinding
import com.jackelliott.ecommerceapp.databinding.ItemBookBinding

class BookStoreFragment : Fragment(){

    private lateinit var binding: FragmentBookStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookStoreBinding.inflate(inflater, container, false)
        setupView()
        setupOnClickListener(container)
        return binding.root
    }

    private fun setupOnClickListener(container: ViewGroup?) {
        val view:View = LayoutInflater.from(container?.context).inflate(R.layout.item_book, container, false)
        var binding: ItemBookBinding = ItemBookBinding.bind(view)
        binding.imageButtonAddToCart.setOnClickListener {

        }
    }

    private fun setupView() {
        var recyclerView: RecyclerView = binding.recyclerViewBookStore
        recyclerView.adapter = BookEntryAdapter()
    }

}