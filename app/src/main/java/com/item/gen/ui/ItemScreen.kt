package com.item.gen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.item.gen.view.ImageViewModel

@Composable
fun ImageScreen() {
    val viewModel: ImageViewModel = viewModel()
    val imageData by viewModel.imageData.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { viewModel.fetchImageData() }) {
            Text("Load Image Data")
        }

        Spacer(modifier = Modifier.height(16.dp))

        imageData?.let { data ->
            Text(text = data.title, modifier = Modifier.padding(8.dp))
            Text(text = data.description, modifier = Modifier.padding(8.dp))
            Image(
                painter = rememberImagePainter(data.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                colorFilter = ColorFilter.tint(Color.Gray) // можно убрать фильтр
            )
        } ?: Text(text = "No data loaded", color = Color.Red)
    }
}
