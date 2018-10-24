package com.oohyugi.movieapp.model

import com.google.gson.annotations.SerializedName

data class SearchItemMdl(@SerializedName("Type")
                      val type: String = "",
                         @SerializedName("Year")
                      val year: String = "",
                         @SerializedName("imdbID")
                      val imdbID: String = "",
                         @SerializedName("Poster")
                      val poster: String = "",
                         @SerializedName("Title")
                      val title: String = "")