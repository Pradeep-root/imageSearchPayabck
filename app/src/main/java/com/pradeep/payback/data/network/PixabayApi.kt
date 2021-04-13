package com.pradeep.payback.data.network

import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun searchImages(
        @Query("key")
        key : String = API_KEY,
        @Query("q")
        searchText : String
    ): Response<ImageResponse>

    @GET("/api/")
    suspend fun getDetails(
        @Query("key")
        key : String = API_KEY,
        @Query("id")
        imgId : Int
    ): Response<ImageResponse>
}