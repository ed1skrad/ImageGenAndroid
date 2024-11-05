package com.item.gen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(0.6f))

        imageData?.let { data ->
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data.pictureUrl),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = data.title,
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp
            )
            Text(
                text = data.description,
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        } ?: Text(text = "No data loaded", color = Color.Red)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { viewModel.fetchImageData() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFA2A2FF))
        ) {
            Text("Load Image Data")
        }
    }
}
