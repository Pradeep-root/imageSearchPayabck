package com.pradeep.payback.data.model

import com.google.gson.annotations.SerializedName

data class ImageResponse(

    @SerializedName("total")
    val total : Int,

    @SerializedName("totalHits")
    val totalHits : Int,

    @SerializedName("hits")
    val hits : MutableList<ImageData>

)