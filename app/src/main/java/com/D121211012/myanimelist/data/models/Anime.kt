package com.D121211012.myanimelist.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Anime(
    @SerialName("episodes")
    val episodes: Int?,
    @SerialName("images")
    val images: Images?,
    @SerialName("mal_id")
    val mal_id: Int?,
    @SerialName("rank")
    val rank: Int?,
    @SerialName("season")
    val season: String?,
    @SerialName("synopsis")
    val synopsis: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("year")
    val year: Int?
) : Parcelable