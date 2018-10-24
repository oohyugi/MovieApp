package com.oohyugi.movieapp.repo.detail_movie

import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.DetailMdl
import com.oohyugi.movieapp.model.SearchItemMdl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
interface DetailMovieRepoReq:BaseRequest {
    fun callApiDetail(id:String, callback: BaseRequest.LoadDataCallback<DetailMdl>)
}