package com.example.testproject.Utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testproject.R
import com.example.testproject.DataClass.Screens

@Composable
fun BottomAppBar(navController: NavController) {
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }


    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        IconButton(
            onClick = {
                selected.value = Icons.Default.Home
                navController.navigate(Screens.SaleScreen.Screen) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .weight(1f)
                .size(200.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.menu___home), contentDescription = null,

                )
        }
        IconButton(
            onClick = {
                navController.navigate(Screens.PurchaseScreen.Screen) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .weight(1f)
                .size(200.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.purchase), contentDescription = null,
            )

        }
        IconButton(
            onClick = {

                navController.navigate(Screens.Home.Screen) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .weight(1f)
                .size(200.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.home), contentDescription = "home",
            )
        }
        IconButton(
            onClick = {
                navController.navigate(Screens.ReportScreen.Screen) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .weight(1f)
                .size(200.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.report), contentDescription = null,
            )

        }
        IconButton(
            onClick = {
                navController.navigate(Screens.ChatScreen.Screen) {
                    popUpTo(0)
                }
            }, modifier = Modifier
                .weight(1f)
                .size(200.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.chat), contentDescription = null,
            )

        }


    }








}