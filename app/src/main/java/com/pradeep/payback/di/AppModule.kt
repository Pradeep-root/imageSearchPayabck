package com.pradeep.payback.di

import android.content.Context
import com.pradeep.payback.data.interceptors.CachingInterceptor
import com.pradeep.payback.data.interceptors.ConnectivityInterceptor
import com.pradeep.payback.data.network.PixabayApi
import com.pradeep.payback.repository.ImageRepository
import com.pradeep.payback.repository.ImageRepositoryImpl
import com.pradeep.payback.utils.Constants.Companion.BASE_URL
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
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    private const val cacheSize = (5 * 1024 * 1024).toLong()

    @Singleton
    @Provides
    fun providesOkHttp(@ApplicationContext context : Context) = OkHttpClient.Builder()
        .cache(Cache(context.cacheDir, cacheSize))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
        .addNetworkInterceptor(CachingInterceptor())
        .addInterceptor(ConnectivityInterceptor(context))
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesPixabayApi(retrofit: Retrofit) = retrofit.create(PixabayApi::class.java)

    @Singleton
    @Provides
    fun providesImageRepository(pixabayApi: PixabayApi) = ImageRepositoryImpl(pixabayApi) as ImageRepository

}