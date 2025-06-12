package com.example.testproject.Utils

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.testproject.R
import com.example.testproject.viewModels.NotificationViewModel


@Composable
fun SearchBar( searchQuery: (String) -> Unit,viewModel: NotificationViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier

    ) {
        var switchState by remember { mutableStateOf(true) }
        val height = LocalConfiguration.current.screenHeightDp.dp
        val showNotification by viewModel.showNotification.collectAsState()
        var query by remember { mutableStateOf("") }





        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
                OutlinedTextField(
                    value = query,
                    onValueChange = {
                        query = it
                        searchQuery(it)
                                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    placeholder = { Text("you want search...") },
                    singleLine = true,
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFF1F3F4),
                        focusedContainerColor = Color(0xFFF1F3F4),
                        disabledContainerColor = Color(0xFFF1F3F4),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 8.dp)
                        .height(56.dp)
                )
            Card(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 1.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New Version",
                        color = Color.Blue,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = switchState,
                        onCheckedChange = { switchState = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,

                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color.Gray
                        )
                    )
                }
            }
        }

        if (showNotification) {
            Card(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 1.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp),



                ) {
                    Image(
                        painter = painterResource(R.drawable.cross), contentDescription = null,
                        modifier = Modifier
                            .padding(start = 310.dp)
                            .clickable {
                                viewModel.hideNotification()
                            })

                    Text(
                        text = "Notificaion :",
                        color = Color(0xFF04BD6C)
                    )
                    Text(text = "We have succesfully recieved your payment. Please retain this notification for your records.",
                        fontSize = 13.sp)





                }


            }
        }

       Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val buttonTitles = listOf("STD", "MTD", "YTD", "+")
            buttonTitles.forEach { title ->
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7738CF)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                ) {
                    Text(text = title)
                }
            }
        }



    }
}
@Preview
@Composable
fun funcPreview(modifier: Modifier = Modifier) {

    SearchBar(
        searchQuery = { /*TODO*/ },
        viewModel = NotificationViewModel()
    )
}
