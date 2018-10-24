package com.oohyugi.movieapp.repo.search_movie

import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.SearchItemMdl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
interface SearchMovieRepoReq:BaseRequest {
    fun callApiSearch(title:String,page:Int, callback: BaseRequest.LoadDataCallback<BaseMdl<List<SearchItemMdl>>>)
}