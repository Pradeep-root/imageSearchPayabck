package com.pradeep.payback.ui

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.pradeep.payback.R
import com.pradeep.payback.utils.hide


@BindingAdapter("largeImageUrl", "thumbnailUrl", "progress")
fun loadImage(view: ImageView, largeImageUrl: String, thumbnailUrl: String, progress: View) {
    Glide.with(view.context)
        .load(largeImageUrl)
        .thumbnail(Glide.with(view.context).load(thumbnailUrl))
        .listener(object : RequestListener<Drawable> {
            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progress.hide()
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progress.hide()
                return false
            }
        })
        .into(view)
}


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