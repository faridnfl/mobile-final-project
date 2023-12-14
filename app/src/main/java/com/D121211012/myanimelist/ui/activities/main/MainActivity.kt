package com.D121211012.myanimelist.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211012.myanimelist.data.models.Anime
import com.D121211012.myanimelist.ui.activities.detail.DetailActivity
import com.D121211012.myanimelist.ui.theme.D121211012FaridNaufalAfiqTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211012FaridNaufalAfiqTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "List Anime") },
                            )
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                            ListAnimeScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListAnimeScreen(mainUiState: MainUiState) {
        when(mainUiState) {
            is MainUiState.Success -> ListAnime(mainUiState.data)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    private fun ListAnime(data: List<Anime>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(data) { anime ->
                AnimeCard(anime = anime)
            }
        }
    }

    @Composable
    private fun AnimeCard(anime: Anime) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("ANIME", anime)
                    startActivity(intent)
                }
        ){
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(anime.images?.jpg?.image_url)
                    .crossfade(true)
                    .build(),
                contentDescription = "Ini gambar",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = anime.title ?: "Ini title")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Episode: ${anime.episodes ?: "N/A"} | Season: ${anime.season ?: "N/A"} | Year: ${anime.year ?: "N/A"}")
        }
    }

}