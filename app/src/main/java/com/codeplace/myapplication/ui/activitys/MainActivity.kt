package com.codeplace.myapplication.ui.activitys
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book
import com.codeplace.myapplication.ui.recyclerview.adapter.BookListAdapter

// init array with books
val authorHead = "by"



class MainActivity : AppCompatActivity()  {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT "
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Book>()

        // getBooksDate
        arrayList.add(Book(
            id = 1,
            title = "The Book Of Eli",
            isbn = "12345-1111",
            price = 233.00,
            currencyCode = "EUR",
            author = "$authorHead Leonardo Valeriano",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
         ))
        arrayList.add(Book(
            id = 2,
            title = "The Book Of Eli2",
            isbn = "12345-11112",
            price =  200.00,
            currencyCode = "GBP",
            author = "$authorHead Valeriano2",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
            )

        )


        // initAdapter
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = BookListAdapter(arrayList, this){
                val intent = Intent(this, BookDetailActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)

             }

    }

}






