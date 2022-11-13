package com.codeplace.myapplication.webclient.services
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// That's an object because its a singleton
// If you have injection dependency with dagger hilt you don't need this
class RetrofitInstance {

    // Criando o servico para realizar a comunicacao HTTP.

    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl("https://tpbookserver.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val bookService = retrofit.create(BookService::class.java)

}