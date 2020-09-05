package com.madina.sampleapp.networking.helpers

import com.madina.sampleapp.BuildConfig
import com.madina.sampleapp.application.SampleApp
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class RetrofitHelper(
    private val application: SampleApp
) {

    companion object {
        const val HEADER_AUTH = "Authorization"
    }

    val retrofit: Retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .cache(cache)
            .addInterceptor(provideHeaderInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        val httpClient = okHttpClient.build()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    private fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val newRequest = request
                .newBuilder()
                .addHeader(HEADER_AUTH, "Bearer " + BuildConfig.READ_ACCESS_TOKEN)
                .build()

            chain.proceed(newRequest)
        }
    }

    private val cache: Cache by lazy {
        Cache(File(application.cacheDir, "http-cache"), (10 * 1024 * 1024).toLong())
    }
}