package com.codeplace.myapplication.webclient.services

data class BookResponse(
    val author: String,
    val currencyCode: String,
    val id: Int,
    val isbn: String,
    val price: Double,
    val title: String
)