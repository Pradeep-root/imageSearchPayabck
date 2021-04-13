package com.pradeep.payback.repository

import com.pradeep.payback.data.network.PixabayApi
import javax.inject.Inject


class ImageRepositoryImpl @Inject constructor(val pixabayApi: PixabayApi) : ImageRepository {
    override suspend fun searchImage(searchText: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getDetails(imgId: Int) {
        TODO("Not yet implemented")
    }
}