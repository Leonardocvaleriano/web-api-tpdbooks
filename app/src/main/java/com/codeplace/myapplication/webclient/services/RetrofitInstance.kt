package com.codeplace.myapplication.webclient.services
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// That's an object because its a singleton
// If you have injection dependency with dagger hilt you don't need this
object RetrofitInstance {

    // lazy that just means it won't be initialize righ away, instead it will be initialized when we first acess this api
    val api: BookService by lazy {
            Retrofit.Builder()
                .baseUrl("https://tpbookserver.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookService::class.java)
    }
}