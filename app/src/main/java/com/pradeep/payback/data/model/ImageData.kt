package com.pradeep.payback.data.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.pradeep.payback.R
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

