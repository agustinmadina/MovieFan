package com.madina.sampleapp.networking

import com.madina.sampleapp.application.SampleApp
import com.madina.sampleapp.networking.helpers.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule {

    @Provides
    fun provideRetrofitHelper(application: SampleApp): RetrofitHelper =
        RetrofitHelper(application)

    @Provides
    fun provideSampleServer(retrofitHelper: RetrofitHelper): MovieService {
        return retrofitHelper.retrofit.create(MovieService::class.java)
    }
}