package com.madina.sampleapp.ui.main

import android.app.Activity
import com.madina.sampleapp.domain.repository.RepositoryModule
import com.madina.sampleapp.networking.NetworkingModule
import com.madina.sampleapp.ui.adapters.MainAdapter
import com.madina.sampleapp.ui.utils.RuntimeScoped
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        RepositoryModule::class,
        NetworkingModule::class
    ]
)
class MainModule {

    @Provides
    @RuntimeScoped
    fun provideMovieListener(activity: MainActivity) = activity as MainAdapter.MovieListener

    @RuntimeScoped
    @Provides
    fun provideActivity(activity: MainActivity): Activity {
        return activity
    }
}