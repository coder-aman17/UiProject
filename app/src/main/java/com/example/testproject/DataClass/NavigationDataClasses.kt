package com.example.testproject.DataClass

sealed class Screens(val Screen: String ){
    data object SaleScreen: Screens("sale")
    data object PurchaseScreen: Screens("purchase")
    data object Home: Screens("home")
    data object ReportScreen: Screens("report")
    data object ChatScreen: Screens("chat")
    data object TransactionScreen: Screens("transaction")


}