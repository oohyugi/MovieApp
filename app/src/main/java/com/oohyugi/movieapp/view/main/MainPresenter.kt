package com.oohyugi.movieapp.view.main

import com.oohyugi.movieapp.base.BasePresenter
import com.oohyugi.movieapp.base.BaseRequest
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.SearchItemMdl
import com.oohyugi.movieapp.repo.search_movie.SearchMovieRepoImpl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
class MainPresenter(mView: MainView) : BasePresenter<MainView>(mView) {

    val mRepo = SearchMovieRepoImpl()

    fun  callAPiSearchMovie(title:String,page:Int){
        mView.showLoading()
        mRepo.callApiSearch(title,page,object :BaseRequest.LoadDataCallback<BaseMdl<List<SearchItemMdl>>>{
            override fun onDataLoaded(data: BaseMdl<List<SearchItemMdl>>) {
                mView.stopLoading()
                mView.onShowListResult(data)
            }

            override fun onDataError(errorMessage: String) {
                mView.stopLoading()
                mView.errorLoading(errorMessage)
            }

        })
    }
}