package com.example.testproject.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testproject.ApiDataClasses.DataClass
import com.example.testproject.viewModels.PurchaseScreenViewModel

@Composable
fun PurchaseScreen(
    modifier: Modifier = Modifier,
    viewModel: PurchaseScreenViewModel = hiltViewModel()
) {
    val isLoading by viewModel.isLoading.collectAsState()
    var rawResponse: retrofit2.Response<DataClass>? = null
    val errorMessage by viewModel.errorMessage.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAdminHomeData(){
            rawResponse = it
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        when {
            isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            else -> {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(
                        text = "API Response:",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "${rawResponse ?: errorMessage ?: " No response"}",
                        color = if (errorMessage != null) Color.Red else Color.Black,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}
