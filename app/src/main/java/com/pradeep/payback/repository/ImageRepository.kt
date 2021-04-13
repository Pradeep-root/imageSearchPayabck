package com.pradeep.payback.repository

import com.backbase.assignment.util.Resource
import com.pradeep.payback.data.model.ImageResponse

interface ImageRepository {

    suspend fun searchImage(searchText : String) : Resource<ImageResponse>

    suspend fun getDetails(imgId : Int) : Resource<ImageResponse>
}