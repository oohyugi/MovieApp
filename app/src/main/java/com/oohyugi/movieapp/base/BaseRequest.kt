package com.oohyugi.movieapp.base

/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
interface BaseRequest{
    interface LoadDataCallback<T> {

        fun onDataLoaded(data:T)
        fun onDataError(errorMessage:String)
    }
}