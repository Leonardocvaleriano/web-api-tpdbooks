package com.codeplace.myapplication.ui.activitys
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.codeplace.myapplication.R


class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val title = findViewById<TextView>(R.id.txt_title_detail)
        val author = findViewById<TextView>(R.id.txt_author_detail)
        val description = findViewById<TextView>(R.id.txt_description_detail)

        // Providing actionBar display to go back home.
        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        // After that, set android manifest.


        // get data from putExtra intent
        var intent = intent
        val dTitle = intent.getStringExtra("iTitle")
        val dAuthor = intent.getStringExtra("iAuthor")

        //set title action bar and content of: title, author, description content... in another activity
        actionBar.setTitle(dTitle)
        title.text = dTitle
        author.text = dAuthor
     }
}