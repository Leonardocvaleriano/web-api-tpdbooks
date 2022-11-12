package com.codeplace.myapplication.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book

class BookListAdapter(
     val arrayList: ArrayList<Book>,
     val context: Context,
     val listener:(Book) -> Unit
) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val title: TextView = itemView.findViewById(R.id.txt_title)
            val isbn: TextView = itemView.findViewById(R.id.txt_isbn)
            val price: TextView = itemView.findViewById(R.id.txt_price)
            val currencyCode: TextView = itemView.findViewById(R.id.txt_currencyCode)
            val author: TextView = itemView.findViewById(R.id.txt_author)


            fun bindItens(book: Book, listener: (Book) -> Unit){
                title.text = book.title
                isbn.text = book.isbn
                price.text = book.price.toString()
                author.text = book.author
                currencyCode.text = book.currencyCode

                itemView.setOnClickListener{ listener(book) }
             }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.book_list,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItens(arrayList[position], listener)

      }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
