package com.oohyugi.movieapp.view.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.oohyugi.movieapp.R
import com.oohyugi.movieapp.base.BaseActivity
import com.oohyugi.movieapp.model.DetailMdl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(),DetailView {
    override fun onShowResult(data: DetailMdl) {
        initData(data)


    }

    private fun initData(data: DetailMdl) {
        Picasso.with(this).load(data.poster).resize(300,300).into(img_detail)
        txt_title.text = data.title
        txt_rat.text = data.genre
        txt_releasedate.text = data.released
        txt_synopsis.text = data.plot

    }

    override fun showLoading() {
    }

    override fun errorLoading(errorMessage: String?) {
    }

    override fun stopLoading() {
    }

    lateinit var mPresenter: DetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mPresenter = DetailPresenter(this)
        mPresenter.callAPiDetailMovie(intent.getStringExtra(TAG_ID))
    }


    companion object {
         val TAG_ID="id"

        fun startThisActivity(context: Context, id:String){
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(TAG_ID,id)
            context.startActivity(intent)
        }
    }
}
