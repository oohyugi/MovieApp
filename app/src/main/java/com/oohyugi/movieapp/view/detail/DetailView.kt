package com.oohyugi.movieapp.view.detail

import com.oohyugi.movieapp.base.BaseView
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.DetailMdl
import com.oohyugi.movieapp.model.SearchItemMdl

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
interface DetailView:BaseView {
    fun onShowResult(data: DetailMdl)
}