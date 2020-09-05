package com.madina.sampleapp.domain.repository

import com.madina.sampleapp.domain.repository.implementation.MovieRepositoryImpl
import com.madina.sampleapp.domain.repository.interfaces.MovieRepository
import com.madina.sampleapp.networking.MovieService
import com.madina.sampleapp.networking.NetworkingModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        NetworkingModule::class
    ]
)
class RepositoryModule {

    @Provides
    fun provideSampleRepository(
        movieService: MovieService
    ): MovieRepository = MovieRepositoryImpl(movieService)
}