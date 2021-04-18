package com.pradeep.payback.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val favorites : Long?,

    @SerializedName("likes")
    val likes : Long?,

    @SerializedName("comments")
    val comments : Long?,

    @SerializedName("userImageURL")
    val userImageURL : String?,

    @SerializedName("tags")
    val tags : String?

): Parcelable

