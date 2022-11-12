package com.codeplace.myapplication.ui.activitys
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book


class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)


        val book = intent.getParcelableExtra<Book>(MainActivity.INTENT_PARCELABLE)

        val title = findViewById<TextView>(R.id.txt_title_detail)
        val isbn = findViewById<TextView>(R.id.txt_isbn_detail)
        val price = findViewById<TextView>(R.id.txt_price_detail)
        val currencyCode = findViewById<TextView>(R.id.txt_currencyCode_detail)
        val author = findViewById<TextView>(R.id.txt_author_detail)
        val description = findViewById<TextView>(R.id.txt_description_detail)


        title.text = book?.title ?:"null"
        isbn.text = book?.isbn?:"null"
        price.text = book?.price.toString()
        currencyCode.text = book?.currencyCode?:"null"
        author.text = book?.author ?:"null"
        description.text = book?.description?:"null"


        // Providing actionBar display to go back home.
        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //set title action bar and content of: title,
        val iTitle = book?.title
        actionBar.setTitle(iTitle)

    }
}



