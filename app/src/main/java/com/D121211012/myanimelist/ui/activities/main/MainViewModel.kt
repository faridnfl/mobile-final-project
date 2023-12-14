package com.D121211012.myanimelist.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211012.myanimelist.MyApplication
import com.D121211012.myanimelist.data.models.Anime
import com.D121211012.myanimelist.data.repository.AnimeRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val data: List<Anime>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val animeRepository: AnimeRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getAnime() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = animeRepository.getAnime()
            Log.d("MainViewModel", "getAnime: ${result.data?.size}")
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getAnime error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getAnime()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val animeRepository = application.container.animeRepository
                MainViewModel(animeRepository)
            }
        }
    }

}