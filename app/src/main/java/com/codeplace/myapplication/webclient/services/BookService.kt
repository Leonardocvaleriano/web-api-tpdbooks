package com.codeplace.myapplication.webclient.services

import retrofit2.Response
import retrofit2.http.GET

interface BookService {

    @GET("/books")
    //Suspend because our request gonna be made by the courotine
    suspend fun getBooks(): Response<List<BookResponse>>

}