package com.item.gen.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.item.gen.data.ImageData
import com.item.gen.network.RetrofitInstance
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ImageViewModel : ViewModel() {
    private val _imageData = MutableStateFlow<ImageData?>(null)
    val imageData: StateFlow<ImageData?> = _imageData

    fun fetchImageData() {
        viewModelScope.launch {
            try {
                val data = RetrofitInstance.api.getImageData()
                _imageData.value = data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
