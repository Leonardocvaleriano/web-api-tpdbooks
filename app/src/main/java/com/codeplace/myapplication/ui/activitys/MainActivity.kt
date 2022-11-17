package com.codeplace.myapplication.ui.activitys
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeplace.myapplication.databinding.ActivityMainBinding
import com.codeplace.myapplication.ui.adapter.BookListAdapter
import com.codeplace.myapplication.webclient.services.ApiClient
import com.codeplace.myapplication.webclient.services.ApiService
import com.codeplace.myapplication.webclient.services.models.BooksListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity()  {

    // BUILDFUTURE BINDING EXPLANATION **
    // Initializing the binding Added as true in build.gradle

    // ** LATEINIT VAR EXPLANATION **
    // The late init keyWord allow us to avoid initializing a property when an object is constructed,
    // so it make your property be initialized as soon as possible.
    lateinit var binding:ActivityMainBinding

    // ** LAZY PROPERTY EXPLANATION **
    // lazy is mainly used when you want to access some read-only property because the same object is accessed.

    val bookListAdapter by lazy { BookListAdapter() }

    // Initializing the retrofit
    private val api: ApiService by lazy {
        ApiClient().getClient().create(ApiService::class.java)
    }

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           binding = ActivityMainBinding.inflate(layoutInflater)
           setContentView(binding.root)

            binding.apply {

                // Doing the progress bar going on.
                progressbarListBook.visibility = View.VISIBLE


                val callMovieApi = api.getListBook()
                callMovieApi.enqueue(object  : Callback<MutableList<BooksListResponse>>{
                    override fun onResponse(
                        call: Call<MutableList<BooksListResponse>>,
                        response: Response<MutableList<BooksListResponse>>
                    ) {
                        progressbarListBook.visibility = View.GONE
                        when(response.code()){
                            in 200..299 -> {
                                Log.d("Response Code", "Success message: ${response.code()}")
                                response.body()?.let { itBody ->
                                    if (itBody.isNotEmpty()){
                                        bookListAdapter.differ.submitList(itBody)
                                        //Recycler
                                        recyclerView.apply {
                                            layoutManager = LinearLayoutManager(this@MainActivity)
                                            adapter = bookListAdapter
                                        }
                                    }

                                }

                            }
                            in 300..399 -> {
                                Log.d("Response Code", "Redirection message: ${response.code()}")
                            }
                            in 400..499 ->{
                                Log.d("Response Code", "Client error message: ${response.code()}")
                            }
                            in 500..599 ->{
                                Log.d("Response code", "Server error responses ${response.code()}")
                            }
                        }

                    }

                    override fun onFailure(
                        call: Call<MutableList<BooksListResponse>>,
                        t: Throwable
                    ) {
                        progressbarListBook.visibility = View.GONE
                        Log.d("on failure", "Err: ${t.message}")
                    }


                })


            }


       }


}



