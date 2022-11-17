package com.codeplace.myapplication.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class Book(
    val id:Int?,
    val title:String?,
    val isbn:String?,
    val price: Double?,
    val currencyCode:String?,
    val author:String?,
    val description:String?
 )

