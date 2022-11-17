package com.codeplace.myapplication.webclient.services.models

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// Interceptors -> Is a powerfull mechanism that can monitor rewrite and retry our calls

class ApiClient {

   private lateinit var retrofit:Retrofit

    // Defining the intercetors
    // STEP 1 BUILD HTTP WORK **
    // STEP 2 OK HTTP USE LEAST TRACK IN INTERCEPTOR AND CALL INTERCEPTOR IN ORDER **
    // STEP 3 CREATE A FUNCTION TO GET CLIENT **

    // STEP 1 **
    // chain proccede request  is a crucial part of each interceptor implementation.
    // This simple method is where all the http works happen, producing a response to satisfy the request.
    private val requestInterceptor = Interceptor{ chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .build()

        val request=chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)
    }

    // STEP2 **
    // Now Ok, Https use least track in interceptor and interceptors are called in order.
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    fun getClient():Retrofit{
        retrofit=Retrofit.Builder()
            .baseUrl("http://tpbookserver.herokuapp.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}

