package com.madina.sampleapp.application

import com.madina.sampleapp.ui.main.MainActivity
import com.madina.sampleapp.ui.main.MainModule
import com.madina.sampleapp.ui.utils.RuntimeScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @RuntimeScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

}