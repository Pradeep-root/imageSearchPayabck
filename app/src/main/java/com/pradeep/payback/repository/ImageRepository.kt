package com.pradeep.payback.repository

interface ImageRepository {

    suspend fun searchImage(searchText : String)

    suspend fun getDetails(imgId : Int)
}