package com.oohyugi.movieapp.view.detail

import com.oohyugi.movieapp.base.BasePresenter
import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.DetailMdl
import com.oohyugi.movieapp.model.SearchItemMdl
import com.oohyugi.movieapp.repo.detail_movie.DetailMovieRepoImpl
import com.oohyugi.movieapp.repo.search_movie.SearchMovieRepoImpl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
class DetailPresenter(mView:DetailView) : BasePresenter<DetailView>(mView) {

    val mRepo = DetailMovieRepoImpl()

    fun  callAPiDetailMovie(id:String){
        mView.showLoading()
        mRepo.callApiDetail(id,object :BaseRequest.LoadDataCallback<DetailMdl>{
            override fun onDataLoaded(data: DetailMdl) {
                mView.stopLoading()
                mView.onShowResult(data)
            }

            override fun onDataError(errorMessage: String) {
                mView.stopLoading()
                mView.errorLoading(errorMessage)
            }

        })
    }
}