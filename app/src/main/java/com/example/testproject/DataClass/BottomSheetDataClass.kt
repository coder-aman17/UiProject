package com.example.testproject.DataClass

data class Item(
    var name: String,
    var iconRes: Int,


)

data class Section(
    val title: String,
    val items: List<Item>

)

