package com.example.testproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier.fillMaxWidth(0.6f),


    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(painter = painterResource(R.drawable.search), contentDescription = "Search")
            Text(text = "Search everything here")

            Text(text = "New Version",
                style = MaterialTheme.typography.bodyMedium,
                color = _root_ide_package_.androidx.compose.ui.graphics.Color(0xFF7738CF))
            Image(painter = painterResource(R.drawable.resource_switch), contentDescription = null)


        }
    }

}