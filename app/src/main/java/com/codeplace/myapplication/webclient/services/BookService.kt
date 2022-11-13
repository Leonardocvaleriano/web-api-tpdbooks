package com.codeplace.myapplication.webclient.services
import com.codeplace.myapplication.webclient.services.models.BookResponse
import retrofit2.Call
import retrofit2.http.GET

interface BookService {


    @GET("/books")
    //Suspend because our request gonna be made by the courotine
      fun getAllBooks(): Call<List<BookResponse>>

}