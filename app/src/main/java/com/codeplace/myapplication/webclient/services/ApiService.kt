package com.codeplace.myapplication.webclient.services

import com.codeplace.myapplication.ui.activitys.BookDetailActivity
import com.codeplace.myapplication.webclient.services.models.BookDetails
import com.codeplace.myapplication.webclient.services.models.BooksListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    // Patch of the url which the data will be get. @GET("/books")
    // Getting the list of books*
    @GET("books")
    // Preparing the method to fetching data from the server
    fun getListBook():Call<MutableList<BooksListResponse>>

    @GET("book/{books_id}")
    fun getBookDetail(@Path("books_id")id:Int):Call<BookDetails>

    @PUT("book/id")
    fun

}