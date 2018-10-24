package com.oohyugi.movieapp.repo.detail_movie

import com.oohyugi.movieapp.api.BaseCallBack
import com.oohyugi.movieapp.base.BaseRepo
import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.DetailMdl
import com.oohyugi.movieapp.model.SearchItemMdl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
class DetailMovieRepoImpl:BaseRepo(),DetailMovieRepoReq {
    override fun callApiDetail(id: String, callback: BaseRequest.LoadDataCallback<DetailMdl>) {
        mApiClient.mApiServices.detailMovie(id,"769e5f4").enqueue(object :BaseCallBack<DetailMdl>(){
            override fun onError(errorMessage: String) {
                callback.onDataError(errorMessage)
            }

            override fun onSuccess(response: DetailMdl) {
                callback.onDataLoaded(response)
            }

        })
    }



}