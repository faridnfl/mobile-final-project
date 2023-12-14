package com.D121211012.myanimelist.data.source.remote

import com.D121211012.myanimelist.data.response.GetAnimeResponse
import retrofit2.http.GET


interface ApiService {

    @GET("v4/anime")
    suspend fun getAnime(): GetAnimeResponse
}