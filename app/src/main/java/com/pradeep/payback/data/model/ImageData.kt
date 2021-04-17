package com.pradeep.payback.data.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.pradeep.payback.R

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
    val comments : Double?,

    @SerializedName("userImageURL")
    val userImageURL : String?,

    @SerializedName("tags")
    val tags : String?

)

@BindingAdapter("app:thumbNail")
fun loadImage(imgView : ImageView, thumbNail : String ){
        Glide.with(imgView.context).load(thumbNail)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.ic_baseline_image_24).into(imgView)
}

@BindingAdapter("app:avatarUrl")
fun loadAvatar(imgView: ImageView, avatarUrl: String){
       Glide.with(imgView.context).load(avatarUrl)
            .fitCenter()
            .apply(RequestOptions().transform(CircleCrop()))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.ic_avatar_48dp).into(imgView)
}


@BindingAdapter(value = ["url", "defaultImage", "placeholder", "circleCrop"], requireAll = false)
fun loadImage(imgView: ImageView, url: String, default: Drawable? = null,
                placeholder: Drawable? = null, circleCrop: Boolean = false) {
            Glide.with(imgView.context).load(url)

}