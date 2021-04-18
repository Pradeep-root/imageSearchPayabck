package com.pradeep.payback.repository

import android.util.Log
import com.backbase.assignment.util.Resource
import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.data.network.PixabayApi
import java.io.IOException
import javax.inject.Inject


class ImageRepositoryImpl @Inject constructor(val pixabayApi: PixabayApi) : ImageRepository {


    override suspend fun searchImage(searchText: String) : Resource<ImageResponse> {
        return try {
            val response = pixabayApi.searchImages(searchText = searchText)
            val result = response.body()

            if(response.isSuccessful && result != null){
                Resource.success(result)
            }else{
                Resource.error(response.message(), null)
            }
        }catch (e : IOException){
           Resource.error(e.message.toString(), null)
        }
    }

}