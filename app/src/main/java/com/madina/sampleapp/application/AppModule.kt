package com.madina.sampleapp.application

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: SampleApp): Context = application.applicationContext
}