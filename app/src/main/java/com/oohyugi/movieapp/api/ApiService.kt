package com.oohyugi.movieapp.api


import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.DetailMdl
import com.oohyugi.movieapp.model.SearchItemMdl
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
interface ApiService {

    @GET("/")
    fun searchMovie(@Query("s") search:String, @Query("page")page:Int, @Query("apikey") apiKey:String): Call<BaseMdl<List<SearchItemMdl>>>

    @GET("/")
    fun detailMovie(@Query("i") id:String,  @Query("apikey") apiKey:String): Call<DetailMdl>

}
