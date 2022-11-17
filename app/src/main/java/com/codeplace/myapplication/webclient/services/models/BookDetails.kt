package com.codeplace.myapplication.webclient.services.models

data class BookDetails(
    val author: String?,
    val currencyCode: String?,
    val description: String?,
    val id: Int?,
    val isbn: String?,
    val price: Double?,
    val title: String?
)