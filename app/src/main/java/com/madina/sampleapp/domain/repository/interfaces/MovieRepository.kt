package com.madina.sampleapp.domain.repository.interfaces

import com.madina.sampleapp.domain.model.MovieDetail
import com.madina.sampleapp.networking.response.MoviesResponse

interface MovieRepository {

//    suspend fun getMovies(listId: Int, page: Int): MoviesResponse
    suspend fun getTopRatedMovies(): MoviesResponse
//    suspend fun getPopularMovies(): MoviesResponse
//    suspend fun getUpcomingMovies(): MoviesResponse
//    suspend fun getMovie(movieId: Int): MovieDetail
//    suspend fun searchMovie(query: String): MoviesResponse
}