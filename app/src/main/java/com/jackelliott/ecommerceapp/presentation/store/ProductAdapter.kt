package com.jackelliott.ecommerceapp.presentation.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.jackelliott.ecommerceapp.Constants
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.presentation.cart.CartViewModel
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.databinding.ItemProductBinding
import java.text.DecimalFormat

class ProductAdapter(
    private val productList: List<Product>,
    private val context: Context?,
    private val productViewModel: ProductViewModel
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position], context, productViewModel)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding: ItemProductBinding = ItemProductBinding.bind(itemView)

        fun bind(product: Product, context: Context?, productViewModel: ProductViewModel) {
            binding.textViewTitle.text = product.title
            binding.textViewDescription.text = product.description
//            binding.ratingBarProduct.rating = product.rating
            val df = DecimalFormat("#,###.00")
            val roundedPrice = df.format(product.price)
            binding.textViewPrice.text = "$$roundedPrice"
            context?.let { Glide.with(it).load(product.image).into(binding.imageViewProduct) }
            binding.imageButtonAddToCart.setOnClickListener {
                product.quantity++
                productViewModel.addProduct(product)
                Toast.makeText(context, "${product.title} added to cart", Toast.LENGTH_LONG).show()
            }
        }

    }
}