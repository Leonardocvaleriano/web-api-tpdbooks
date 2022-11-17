package com.codeplace.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.databinding.BookListBinding
import com.codeplace.myapplication.webclient.services.models.BookListResponse

class BookListAdapter:RecyclerView.Adapter<BookListAdapter.ViewHolder>(){

    private lateinit var binding:BookListBinding
    private lateinit var context:Context

    // This method will be responsable to Hold the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = BookListBinding.inflate(inflater,parent,false)
        context= parent.context
        return ViewHolder()
    }

    // Este metodo irá indicar o momento o qual o adapter está colocando cada uma das views dentro do RecyclerView.
    // Ele encontra todas as views criadas, neste caso: View de id: name, description and value.

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    // get the size
    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    // Here we have access to the book_list views
    // Assign that the views will receive the data content.
    inner class ViewHolder: RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BookListResponse){
            binding.apply {
                txtTitle.text = item.title
                txtAuthor.text = item.author
                txtIsbn.text = item.isbn
                txtPrice.text = item.price.toString()
                txtCurrencyCode.text = item.currencyCode
            }

        }
    }


    private val differCallback= object :DiffUtil.ItemCallback<BookListResponse>(){
        override fun areItemsTheSame(
            oldItem: BookListResponse,
            newItem: BookListResponse
        ): Boolean {
                return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BookListResponse,
            newItem: BookListResponse
        ): Boolean {
            return oldItem == newItem }

    }

    val differ =  AsyncListDiffer(this, differCallback)



}
