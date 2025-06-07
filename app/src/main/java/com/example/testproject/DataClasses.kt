package com.example.testproject

import kotlinx.serialization.Serializable

sealed class Screens(val Screen: String ){
    data object SaleScreen: Screens("sale")
    data object PurchaseScreen: Screens("purchase")
    data object Home: Screens("home")
    data object ReportScreen: Screens("report")
    data object ChatScreen: Screens("chat")

}