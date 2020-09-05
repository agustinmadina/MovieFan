package com.madina.sampleapp.application

import com.madina.sampleapp.ui.main.MainActivity
import com.madina.sampleapp.ui.main.MainModule
import com.madina.sampleapp.ui.moviedetail.MovieDetailActivity
import com.madina.sampleapp.ui.moviedetail.MovieDetailModule
import com.madina.sampleapp.ui.utils.RuntimeScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @RuntimeScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

    @RuntimeScoped
    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun movieDetailActivity(): MovieDetailActivity
}