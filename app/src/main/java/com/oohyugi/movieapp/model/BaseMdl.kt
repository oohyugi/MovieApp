package com.oohyugi.movieapp.model

import com.google.gson.annotations.SerializedName

data class BaseMdl<T>(@SerializedName("Response")
                   val response: String = "",
                   @SerializedName("totalResults")
                   val totalResults: String = "",
                   @SerializedName("Search")
                   val searchMdls: T)