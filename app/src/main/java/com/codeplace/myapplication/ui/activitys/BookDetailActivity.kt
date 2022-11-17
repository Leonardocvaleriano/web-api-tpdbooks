package com.codeplace.myapplication.ui.activitys
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.codeplace.myapplication.R
import com.codeplace.myapplication.databinding.ActivityBookDetailBinding
import com.codeplace.myapplication.databinding.ActivityMainBinding


class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Providing actionBar display to go back home.
        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        //set title action bar and content of: title,


        //val iTitle = book?.title
        //actionBar.setTitle(iTitle)

    }
}



