package com.codeplace.myapplication.ui.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book
import com.codeplace.myapplication.ui.activitys.BookDetailActivity

class CustomAdapter(
     val arrayList: ArrayList<Book>,
     val context: Context
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

            fun bindItens(book: Book){

                val id = itemView.findViewById<TextView>(R.id.txt_id)
                val title = itemView.findViewById<TextView>(R.id.txt_title)
                val isbn  = itemView.findViewById<TextView>(R.id.txt_isbn)
                val price = itemView.findViewById<TextView>(R.id.txt_price)
                val author = itemView.findViewById<TextView>(R.id.txt_author)

                title.text = book.title
                isbn.text = book.isbn
                price.text = book.price.toString()
                author.text = book.author
             }
    }

    /**
     * Cria uma view Exclusiva
     * Chama e segura todas as views do arquivo de layout individualemnte,
    realizando o process de binding.
     *
     */


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.book_list,parent,false)
        return ViewHolder(view)
    }

    /**
     * Chama todas as views de book_list individualmente e mantem suas posicoes.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItens(arrayList[position])
            holder.itemView.setOnClickListener{

                // get position of the card selected
                val book = arrayList.get(position)

                // get title and author of selected item with intent
                val gTitle: String? = book.title
                val gAuthor: String? = book.author

                //Create intent
                val intent = Intent(context, BookDetailActivity::class.java)
                intent.putExtra("iTitle", gTitle)
                intent.putExtra("iAuthor", gAuthor)

                // Start another activity
                context.startActivity(intent)
            }


      }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
