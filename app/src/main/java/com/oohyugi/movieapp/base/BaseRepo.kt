package com.oohyugi.movieapp.base

import com.oohyugi.movieapp.api.ApiClient


/**
 * Created by oohyugi on 24/10/18.
 * github: https://github.com/oohyugi
 */
open class BaseRepo {
    var mApiClient : ApiClient = ApiClient("http://www.omdbapi.com")
}