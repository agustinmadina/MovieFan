package com.madina.sampleapp.application

import android.content.Context
import com.madina.sampleapp.ui.utils.implementation.ImageHelperImpl
import com.madina.sampleapp.ui.utils.interfaces.ImageHelper
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: SampleApp): Context = application.applicationContext

    @Provides
    fun providesImageHelper(context: SampleApp): ImageHelper = ImageHelperImpl(context)
}