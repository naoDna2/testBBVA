package com.naomi.pruebabbva.infrastructure.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.naomi.pruebabbva.BuildConfig
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaApi
import com.naomi.pruebabbva.infrastructure.data.remote.apis.BbvaImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpCache(@ApplicationContext appContext: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(appContext.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val interceptorLogger = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .connectTimeout(BuildConfig.NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(BuildConfig.NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(BuildConfig.NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(interceptorLogger)
            .build()
    }

    private fun provideRetrofit(urlBase: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
            .client(okHttpClient)
            .baseUrl(urlBase)
            .build()
    }

    @Provides
    @Singleton
    fun provideBbvaApi(okHttpClient: OkHttpClient): BbvaApi {
        val api: BbvaApi = provideRetrofit(BuildConfig.URL_BBVA_LOGIN, okHttpClient).create(BbvaApi::class.java)
        return api
    }

    @Provides
    @Singleton
    fun provideBbvaImagesApi(okHttpClient: OkHttpClient): BbvaImagesApi {
        val api: BbvaImagesApi = provideRetrofit(BuildConfig.URL_BBVA_IMAGES, okHttpClient).create(BbvaImagesApi::class.java)
        return api
    }
}