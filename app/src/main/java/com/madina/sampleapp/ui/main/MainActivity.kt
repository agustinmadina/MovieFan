package com.madina.sampleapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.madina.sampleapp.R
import com.madina.sampleapp.domain.model.Movie
import com.madina.sampleapp.ui.adapters.MainAdapter
import com.madina.sampleapp.ui.utils.Status
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var adapter: MainAdapter

//    companion object {
//        fun newInstance(context: Context): Intent {
//            val intent = Intent(context, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            return intent
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        AndroidInjection.inject(this)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun setupObservers() {
        viewModel.getTopRatedMovies().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
                        resource.data?.let { movies -> retrieveList(movies.results) }
                    }
//                    Status.ERROR -> {
//                        recyclerView.visibility = View.VISIBLE
//                        progressBar.visibility = View.GONE
//                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//                    }
//                    Status.LOADING -> {
//                        progressBar.visibility = View.VISIBLE
//                        recyclerView.visibility = View.GONE
                }
            }
        })
    }

    private fun retrieveList(users: List<Movie>) {
        adapter.apply {
            addData(users)
            notifyDataSetChanged()
        }
    }
}