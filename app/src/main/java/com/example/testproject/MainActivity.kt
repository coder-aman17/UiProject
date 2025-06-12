package com.example.testproject

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.testproject.DataClass.searchResults
import com.example.testproject.Utils.CustomTextItem
import com.example.testproject.Utils.SearchWithFilterList
import com.example.testproject.ui.theme.TestProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestProjectTheme {

                MainScreen()

            }
        }
    }
}

