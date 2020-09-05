package com.madina.sampleapp.application

import android.content.Context
import com.madina.sampleapp.ui.utils.ImageUtils
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: SampleApp): Context = application.applicationContext

    @Provides
    fun providesImageHelper(): ImageUtils = ImageUtils()
}