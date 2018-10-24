package com.oohyugi.movieapp.repo.search_movie

import com.oohyugi.movieapp.api.BaseCallBack
import com.oohyugi.movieapp.base.BaseRepo
import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.SearchItemMdl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
class SearchMovieRepoImpl:BaseRepo(),SearchMovieRepoReq {
    override fun callApiSearch(title: String,page:Int, callback: BaseRequest.LoadDataCallback<BaseMdl<List<SearchItemMdl>>>) {
        mApiClient.mApiServices.searchMovie(title,page,"769e5f4").enqueue(object :BaseCallBack<BaseMdl<List<SearchItemMdl>>>(){
            override fun onError(errorMessage: String) {
                callback.onDataError(errorMessage)
            }

            override fun onSuccess(response: BaseMdl<List<SearchItemMdl>>) {
                callback.onDataLoaded(response)
            }

        })
    }

}