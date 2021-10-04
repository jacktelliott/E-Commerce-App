package com.jackelliott.ecommerceapp.presentation.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.databinding.ItemCartBinding
import java.text.DecimalFormat

class CartAdapter(
    private val productList: List<Product>,
    private val context: Context?,
    private val cartViewModel: CartViewModel
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(productList[position], context, cartViewModel)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class CartViewHolder(cartView: View) : RecyclerView.ViewHolder(cartView) {

        private var binding: ItemCartBinding = ItemCartBinding.bind(cartView)

        fun bind(product: Product, context: Context?, cartViewModel: CartViewModel) {
            binding.textViewTitle.text = product.title
            binding.textViewDescription.text = product.description
//            binding.ratingBarProduct.rating = product.rating
            val df = DecimalFormat("#,###.00")
            val roundedPrice = df.format(product.price)
            binding.textViewPrice.text = "$$roundedPrice"
            context?.let { Glide.with(it).load(product.image).into(binding.imageViewProduct) }
            binding.imageButtonRemoveFromCart.setOnClickListener {
                product.quantity--
                cartViewModel.removeProduct(product)
                Toast.makeText(context, "${product.title} removed from cart", Toast.LENGTH_LONG).show()
            }
        }
    }
}