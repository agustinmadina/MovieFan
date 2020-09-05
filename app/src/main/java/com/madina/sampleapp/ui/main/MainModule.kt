package com.madina.sampleapp.ui.main

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import com.madina.sampleapp.domain.repository.RepositoryModule
import com.madina.sampleapp.domain.repository.implementation.MovieRepositoryImpl
import com.madina.sampleapp.domain.repository.interfaces.MovieRepository
import com.madina.sampleapp.networking.NetworkingModule
import com.madina.sampleapp.ui.adapters.MainAdapter
import com.madina.sampleapp.ui.utils.RuntimeScoped
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        RepositoryModule::class,
        NetworkingModule::class
    ]
)
abstract class MainModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @RuntimeScoped
        fun provideMovieListener(activity: MainActivity) = activity as MainAdapter.MovieListener
    }


    @RuntimeScoped
    abstract fun provideActivity(activity: MainActivity): Activity
}