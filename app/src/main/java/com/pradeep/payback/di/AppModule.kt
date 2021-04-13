package com.pradeep.payback.di

import android.content.Context
import com.pradeep.payback.data.network.PixabayApi
import com.pradeep.payback.utils.ConnectivityInterceptor
import com.pradeep.payback.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun providesOkHttp(@ApplicationContext context : Context) = OkHttpClient.Builder()
        .addInterceptor(ConnectivityInterceptor(context))
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun providesPixabayApi(retrofit: Retrofit) = retrofit.create(PixabayApi::class.java)

}