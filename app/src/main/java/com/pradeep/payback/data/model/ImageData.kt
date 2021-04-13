package com.pradeep.payback.data.model

import com.google.gson.annotations.SerializedName

data class ImageData(

    @SerializedName("id")
    val id : Int?,

    @SerializedName("previewURL")
    val previewURL : String?,

    @SerializedName("largeImageURL")
    val largeImageURL : String?,

    @SerializedName("user")
    val user : String?,

    @SerializedName("favorites")
    val favorites : Double?,

    @SerializedName("likes")
    val likes : Double?,

    @SerializedName("comments")
    val comments : Double?

)