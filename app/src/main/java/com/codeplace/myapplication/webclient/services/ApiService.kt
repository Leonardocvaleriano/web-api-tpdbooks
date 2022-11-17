package com.codeplace.myapplication.webclient.services

import com.codeplace.myapplication.ui.adapter.BookListAdapter
import com.codeplace.myapplication.webclient.services.models.BookListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    // Patch of the url which the data will be get. @GET("/books")

    @GET("books")
    // Getting the list of books*
    // Preparing the method to fetching data from the server
    fun getListBook():Call<MutableList<BookListResponse>>
}