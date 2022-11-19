package com.codeplace.myapplication.ui.activitys
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.codeplace.myapplication.databinding.ActivityBookDetailBinding
import com.codeplace.myapplication.webclient.services.ApiClient
import com.codeplace.myapplication.webclient.services.ApiService
import com.codeplace.myapplication.webclient.services.models.BookDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookDetailBinding
    private val api: ApiService by lazy {
        ApiClient().getClient().create(ApiService::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookId = intent.getIntExtra("ID", 1)
        binding.apply {
            val callDetailBookApi = api.getBookDetail(bookId)
            callDetailBookApi.enqueue(object :Callback<BookDetails>{
                override fun onResponse(call: Call<BookDetails>, response: Response<BookDetails>) {
                    when(response.code()) {

                                in 200..299 -> {
                            Log.d("Response code", "success message:${response.code()}")
                            response.body()?.let { itBody ->

                                txtTitleDetail.text = itBody.title
                                txtAuthorDetail.text = itBody.author
                                txtIsbnDetail.text = itBody.isbn
                                txtPriceDetail.text = itBody.price.toString()
                                txtCurrencyCodeDetail.text = itBody.currencyCode
                                txtDescriptionDetail.text = itBody.description


//                                val actionBar : ActionBar? = supportActionBar
//                                actionBar!!.setDisplayHomeAsUpEnabled(true)
//                                actionBar?.setDisplayShowHomeEnabled(true)
//                                actionBar?.setTitle(txtTitleDetail.text)

                            }

                        }

                        in 300..399 -> {
                            Log.d("Response code","Redirection message:${response.code()}")
                        }
                        in 400..499 -> {
                            Log.d("Response code","Client error message:${response.code()}")
                        }
                        in 500..599 ->{
                            Log.d("Response code", "Server error responses:${response.code()}")
                        }
                    }
                }

                override fun onFailure(call: Call<BookDetails>, t: Throwable) {
                    Log.d("on failure", "Err: ${t.message}")                }


            })

        }



    }
}



