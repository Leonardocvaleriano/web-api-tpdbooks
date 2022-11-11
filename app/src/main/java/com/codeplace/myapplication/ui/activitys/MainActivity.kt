package com.codeplace.myapplication.ui.activitys
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book
import com.codeplace.myapplication.models.BookDetail
import com.codeplace.myapplication.ui.recyclerview.adapter.CustomAdapter

// init array with books
val authorHead = "by"
val arrayList = ArrayList<Book>()
val arrayListBD = ArrayList<BookDetail>()

class MainActivity : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // getBooksDate
        arrayList.add(Book(
            id = 1,
            title = "The Book Of Eli",
            isbn = "12345-1111",
            price = 233.00,
            author = "$authorHead Leonardo Valeriano",
         ))
        arrayList.add(Book(
            id = 2,
            title = "The Book Of Eli2",
            isbn = "12345-11112",
            price =  200.00,
            author = "$authorHead Valeriano2",
         ))





        // initAdapter
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = CustomAdapter(arrayList, this)

    }

}






