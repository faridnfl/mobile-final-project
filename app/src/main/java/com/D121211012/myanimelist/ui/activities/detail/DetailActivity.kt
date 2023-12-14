package com.D121211012.myanimelist.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211012.myanimelist.data.models.Anime
import com.D121211012.myanimelist.ui.theme.D121211012FaridNaufalAfiqTheme

class DetailActivity : ComponentActivity() {

    private var selectedAnime: Anime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedAnime = intent.getParcelableExtra("ANIME")
        setContent {
            D121211012FaridNaufalAfiqTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailScreen() {
        LazyColumn {
            item {
                selectedAnime?.let { anime ->
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .padding(16.dp)
                    ) {
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
                        Text(text = anime.title ?: "Ini title", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = anime.synopsis ?: "No synopsis available")
                    }
                }
            }
        }
    }

}