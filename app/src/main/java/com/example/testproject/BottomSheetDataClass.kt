package com.example.testproject

import androidx.compose.ui.graphics.Color

data class Item(
    var name: String,
    var iconRes: Int,


)

data class Section(
    val title: String,
    val items: List<Item>

)

