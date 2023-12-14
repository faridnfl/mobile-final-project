package com.D121211012.myanimelist.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Images(
    @SerialName("jpg")
    val jpg: Jpg?,
) : Parcelable