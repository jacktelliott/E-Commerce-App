package com.jackelliott.ecommerceapp.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackelliott.ecommerceapp.Constants
import com.jackelliott.ecommerceapp.R
import com.jackelliott.ecommerceapp.databinding.ItemBookBinding
import java.text.DecimalFormat

class BookEntryAdapter () : RecyclerView.Adapter<BookEntryAdapter.BookEntryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookEntryViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return  BookEntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookEntryViewHolder, position: Int) {
        holder.bind(Constants.BOOKS_IN_STOCK[position])
    }

    override fun getItemCount(): Int {
        return Constants.BOOKS_IN_STOCK.size
    }


    class BookEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var binding: ItemBookBinding = ItemBookBinding.bind(itemView)

        fun bind(book: BookEntry) {
            binding.textViewBookTitle.text = book.title
            binding.textViewAuthor.text = book.author
            binding.ratingBarBook.rating = book.rating
            val df = DecimalFormat("#,###.00")
            val roundedPrice = df.format(book.price)
            binding.textViewPrice.text = "$$roundedPrice"
            binding.imageViewBook.setImageResource(book.image)
        }

    }
}