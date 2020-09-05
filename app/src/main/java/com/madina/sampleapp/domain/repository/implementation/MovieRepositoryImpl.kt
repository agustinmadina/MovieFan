package com.madina.sampleapp.domain.repository.implementation

import com.madina.sampleapp.domain.repository.interfaces.MovieRepository
import com.madina.sampleapp.networking.MovieService

class MovieRepositoryImpl(
    private val movieService: MovieService,
) : MovieRepository {

//    override suspend fun getMovies(listId: Int, page: Int) = movieService.getMovies(listId, page, API_KEY)

    override suspend fun getTopRatedMovies() = movieService.getTopRatedMovies(null)

//    override suspend fun getPopularMovies() = movieService.getPopularMovies(API_KEY)
//
//    override suspend fun getUpcomingMovies() = movieService.getUpcomingMovies(API_KEY)
//
//    override suspend fun getMovie(movieId: Int) = movieService.getMovie(movieId, API_KEY)
//
//    override suspend fun searchMovie(query: String) = movieService.searchMovie(API_KEY, query)
}