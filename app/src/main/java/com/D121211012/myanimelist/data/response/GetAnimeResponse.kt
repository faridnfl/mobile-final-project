package com.D121211012.myanimelist.data.response

import com.D121211012.myanimelist.data.models.Anime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GetAnimeResponse(
    @SerialName("data")
    val data: List<Anime>?
)