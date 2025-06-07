package com.example.testproject

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.search), contentDescription = "Search",
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Search everything here",
                        color = _root_ide_package_.androidx.compose.ui.graphics.Color(0xFF9DB2CE)
                    )
                }

                Text(
                    text = "New Version",
                    color = _root_ide_package_.androidx.compose.ui.graphics.Color(0xFF9DB2CE),
                    fontSize = 8.sp
                )

                Image(
                    painter = painterResource(R.drawable.toggle),
                    contentDescription = "toggleIcon"
                )

            }
        }
       /* Spacer(modifier = Modifier.height(10.dp))*/

        Card(
            modifier = Modifier.padding( start = 16.dp, end = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
            shape = RoundedCornerShape(12.dp)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),

                verticalArrangement = Arrangement.Top



            ){
                Text(text = "Notificaion :",
                    color = _root_ide_package_.androidx.compose.ui.graphics.Color(0xFF04BD6C)
                    )
                Text(text = "We have succesfully recieved your payment. Please retain this notification for your records.")


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