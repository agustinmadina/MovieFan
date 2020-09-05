package com.madina.sampleapp.ui.moviedetail

import android.app.Activity
import com.madina.sampleapp.domain.repository.RepositoryModule
import com.madina.sampleapp.networking.NetworkingModule
import com.madina.sampleapp.ui.adapters.MainAdapter
import com.madina.sampleapp.ui.main.MainActivity
import com.madina.sampleapp.ui.utils.RuntimeScoped
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        RepositoryModule::class,
        NetworkingModule::class
    ]
)
abstract class MovieDetailModule {

    @RuntimeScoped
    abstract fun provideActivity(activity: MovieDetailActivity): Activity
}