package com.madina.sampleapp.ui.moviedetail

import com.madina.sampleapp.domain.repository.RepositoryModule
import com.madina.sampleapp.networking.NetworkingModule
import dagger.Module

@Module(
    includes = [
        RepositoryModule::class,
        NetworkingModule::class
    ]
)
abstract class MovieDetailModule 