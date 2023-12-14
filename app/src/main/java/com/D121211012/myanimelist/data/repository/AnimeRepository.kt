package com.D121211012.myanimelist.data.repository

import com.D121211012.myanimelist.data.response.GetAnimeResponse
import com.D121211012.myanimelist.data.source.remote.ApiService

class AnimeRepository(private val apiService: ApiService) {

    suspend fun getAnime(): GetAnimeResponse {
        return apiService.getAnime()
    }

}