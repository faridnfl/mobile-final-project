package com.D121211012.myanimelist.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Jpg(
    @SerialName("image_url")
    val image_url: String?,
    @SerialName("large_image_url")
    val large_image_url: String?,
    @SerialName("small_image_url")
    val small_image_url: String?
) : Parcelable