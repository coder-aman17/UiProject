package com.example.testproject

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.modifier.ModifierLocal
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {




        var switchState by remember { mutableStateOf(true) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Card(
                modifier = Modifier.weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint =_root_ide_package_.androidx.compose.ui.graphics.Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Search everything here",
                        color = _root_ide_package_.androidx.compose.ui.graphics.Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Card(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 1.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "New Version",
                        color = _root_ide_package_.androidx.compose.ui.graphics.Color.Blue,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        checked = switchState,
                        onCheckedChange = { switchState = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = _root_ide_package_.androidx.compose.ui.graphics.Color.White,

                            uncheckedThumbColor = _root_ide_package_.androidx.compose.ui.graphics.Color.White,
                            uncheckedTrackColor = _root_ide_package_.androidx.compose.ui.graphics.Color.Gray
                        )
                    )
                }
            }
        }
       /* Spacer(modifier = Modifier.height(10.dp))*/

        Card(
            modifier = Modifier.padding( start = 16.dp, end = 16.dp, bottom = 1.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
            shape = RoundedCornerShape(12.dp)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp),

                verticalArrangement = Arrangement.Top



            ){
                Text(text = "Notificaion :",
                    color = _root_ide_package_.androidx.compose.ui.graphics.Color(0xFF04BD6C)
                    )
                Text(text = "We have succesfully recieved your payment. Please retain this notification for your records.",
                    fontSize = 13.sp)


            }


        }

       Spacer(modifier = Modifier.height(10.dp))

       /* Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            Button(
                onClick = {},
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color(
                        0xFF7738CF
                    )

                ),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "STD",
                    style = MaterialTheme.typography.bodySmall)
            }
            Button(
                onClick = {},
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color(
                        0xFF7738CF
                    )

                ),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "MTD",
                    style = MaterialTheme.typography.bodySmall)
            }
            Button(
                onClick = {},
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color(
                        0xFF7738CF
                    )

                ),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "YTD",
                    style = MaterialTheme.typography.bodySmall)
            }
            Button(
                onClick = {},
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = _root_ide_package_.androidx.compose.ui.graphics.Color(
                        0xFF7738CF
                    )

                ),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "+",
                    style = MaterialTheme.typography.bodySmall)

            }



        }*/

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
                        containerColor = androidx.compose.ui.graphics.Color(0xFF7738CF)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp)
                ) {
                    Text(text = title)
                }
            }
        }



    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar()
}