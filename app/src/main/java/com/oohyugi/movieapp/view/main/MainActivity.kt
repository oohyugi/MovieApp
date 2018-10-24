package com.oohyugi.movieapp.view.main

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.google.gson.Gson
import com.oohyugi.movieapp.R
import com.oohyugi.movieapp.model.BaseMdl
import com.oohyugi.movieapp.model.SearchItemMdl
import com.oohyugi.movieapp.view.EndlessNestedScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_state.*
import kotlinx.android.synthetic.main.progress_dialog.*

class MainActivity : AppCompatActivity(),MainView {
    override fun onShowListResult(data: BaseMdl<List<SearchItemMdl>>) {
        Log.e("data",Gson().toJson(data))
        mListMovie.addAll(data.searchMdls)
        mAdapterMovie.notifyItemInserted(mListMovie.size-1)
    }

    override fun showLoading() {
        progress_dialog.visibility=View.VISIBLE
        empty_state.visibility=View.GONE

    }

    override fun errorLoading(errorMessage: String?) {
        Log.e("error",errorMessage)
        empty_state.visibility=View.VISIBLE
        tvEmpty.text = errorMessage
    }

    override fun stopLoading() {
        progress_dialog.visibility=View.GONE

    }

    lateinit var mainPresenter: MainPresenter
    lateinit var mAdapterMovie: AdapterMovie
    var mListMovie:MutableList<SearchItemMdl> = mutableListOf()
    var mTitle:String="Batman"
    var mPage:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter(this)


        setupList()
        etSearch.imeOptions= EditorInfo.IME_ACTION_SEARCH
        etSearch.setOnEditorActionListener(object: TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                mTitle = etSearch.text.toString()
                if (p1 == EditorInfo.IME_ACTION_SEARCH){
                    mListMovie.clear()

                    mainPresenter.callAPiSearchMovie(mTitle,mPage)
                }
                return false
            }

        })
        mainPresenter.callAPiSearchMovie(mTitle,mPage)
    }

    private fun setupList() {
        val mLayoutManager = LinearLayoutManager(this)
        rvMovie.layoutManager = mLayoutManager
        mAdapterMovie = AdapterMovie(this,mListMovie)
        rvMovie.adapter = mAdapterMovie
        nested.setOnScrollChangeListener(object : EndlessNestedScrollListener(mLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
               mPage = page+1

                if (mPage<=4){
                    mainPresenter.callAPiSearchMovie(mTitle,page)
                }


            }
        })
        mAdapterMovie.notifyDataSetChanged()

    }
}
