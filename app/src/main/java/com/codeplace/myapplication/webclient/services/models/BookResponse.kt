package com.codeplace.myapplication.webclient.services.models

import com.codeplace.myapplication.models.Book

class BookResponse(
    val author: String,
    val currencyCode: String,
    val id: Int,
    val isbn: String,
    val price: Double,
    val title: String
) {
    val book: Book get() = Book(
        author = author,
        currencyCode = currencyCode,
        id = id,
        isbn = isbn,
        price = price,
        title = title,
        description = null
    )
}