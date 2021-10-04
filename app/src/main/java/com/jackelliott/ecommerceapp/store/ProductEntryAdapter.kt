package com.jackelliott.ecommerceapp.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.jackelliott.ecommerceapp.Constants
import com.jackelliott.ecommerceapp.MainActivity
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.cart.CartViewModel
import com.jackelliott.ecommerceapp.database.product.Product
import com.jackelliott.ecommerceapp.databinding.ItemProductBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.DecimalFormat

class ProductEntryAdapter(
    private val productList: List<Product>,
    private val context: Context?
) : RecyclerView.Adapter<ProductEntryAdapter.BookEntryViewHolder>() {

    private lateinit var productEntryList: List<ProductEntry>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookEntryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return BookEntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookEntryViewHolder, position: Int) {
        convertPlToPel()
        holder.bind(productEntryList[position], context)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    private fun convertPlToPel(): List<ProductEntry> {
        for (product in productList) {
            productEntryList[product.id].title = product.title
            productEntryList[product.id].description = product.description
            productEntryList[product.id].price = product.price
            productEntryList[product.id].image = product.image
            productEntryList[product.id].rating = product.rating
        }
        return productEntryList
    }

    class BookEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding: ItemProductBinding = ItemProductBinding.bind(itemView)

        fun bind(product: ProductEntry, context: Context?) {
//            binding.textViewBookTitle.text = book.title
//            binding.textViewAuthor.text = book.author
//            binding.ratingBarBook.rating = book.rating
//            val df = DecimalFormat("#,###.00")
//            val roundedPrice = df.format(book.price)
//            binding.textViewPrice.text = "$$roundedPrice"
//            binding.imageViewBook.setImageResource(book.image)
            binding.textViewTitle.text = product.title
            binding.textViewDescription.text = product.description
            binding.ratingBarProduct.rating = product.rating
            val df = DecimalFormat("#,###.00")
            val roundedPrice = df.format(product.price)
            binding.textViewPrice.text = "$$roundedPrice"
            context?.let { Glide.with(it).load(product.image).into(binding.imageViewProduct) }
            binding.imageButtonAddToCart.setOnClickListener {

                Toast.makeText(context, "${product.title} added to cart", Toast.LENGTH_LONG).show()
            }
        }

    }
}