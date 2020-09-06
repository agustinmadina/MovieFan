package com.madina.sampleapp.ui.moviedetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.madina.sampleapp.R
import com.madina.sampleapp.ui.utils.Status
import com.madina.sampleapp.ui.utils.loadImageFromOtherRepo
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_activity.main_text
import kotlinx.android.synthetic.main.main_activity.progressBar
import kotlinx.android.synthetic.main.movie_detail_activity.*
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MovieDetailViewModel

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
        fun newInstance(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)
        AndroidInjection.inject(this)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        supportActionBar?.title = "Movie detail"
    }

    private fun setupObservers() {
        viewModel.getMovie(intent.getIntExtra(EXTRA_MOVIE_ID, 0)).observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.let { movie ->
                            main_text.text = movie.title
                            secondary_text.text = movie.overview
                            movie.posterPath?.let { movie_detail_thumb.loadImageFromOtherRepo((movie.posterPath)) }
                        }
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}