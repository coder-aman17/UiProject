package com.example.testproject.Utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testproject.DataClass.Screens.ChatScreen
import com.example.testproject.DataClass.Screens.PurchaseScreen
import com.example.testproject.DataClass.Screens.ReportScreen
import com.example.testproject.DataClass.Screens.SaleScreen
import com.example.testproject.DataClass.Screens
import com.example.testproject.screens.ChatScreen
import com.example.testproject.screens.PurchaseScreen
import com.example.testproject.screens.ReportScreen
import com.example.testproject.screens.SaleScreen

@Composable
fun CustomScaffold(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    bottomAppBar: @Composable ()-> Unit,
    floatingActionButton: @Composable () -> Unit,
    topBar: @Composable () -> Unit,
    snackBar: @Composable () -> Unit,
    content: @Composable ((PaddingValues) -> Unit),
) {
    Scaffold (
        modifier = modifier.background(color = Color.White),
        topBar =  topBar ,
        bottomBar = bottomAppBar,
        snackbarHost = snackBar,
        floatingActionButton = floatingActionButton


    ){ paddingValues->
        content(paddingValues)
        NavHost(
            navController = navController,
            startDestination = Screens.Home.Screen,
            modifier = Modifier
        ) {
            composable(SaleScreen.Screen) { SaleScreen() }
            composable(PurchaseScreen.Screen) { PurchaseScreen() }
            composable(Screens.Home.Screen) {  }
            composable(ReportScreen.Screen) { ReportScreen() }
            composable(ChatScreen.Screen) { ChatScreen() }
            composable(Screens.TransactionScreen.Screen) { BottomSheet(viewModel()) }


        }


    }


}
