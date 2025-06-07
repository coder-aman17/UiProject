package com.example.testproject

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "Hi Praveen!") },
        
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF7738CF),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White

        ), actions = {
            IconButton(onClick = { Toast.makeText(context,"Camera", Toast.LENGTH_SHORT).show()}) {
                Icon(painter = painterResource(R.drawable.camera), contentDescription = null)
            }
            IconButton(onClick = { Toast.makeText(context,"barcode", Toast.LENGTH_SHORT).show()}) {
                Icon(painter = painterResource(R.drawable.barcode), contentDescription = null)
            }
            IconButton(onClick = { Toast.makeText(context,"Menu", Toast.LENGTH_SHORT).show()}) {
                Icon(painter = painterResource(R.drawable.menu), contentDescription = null)
            }
        }



    )
}


@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    val navController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }


            BottomAppBar (
                containerColor = Color.Transparent
            ) {
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navController.navigate(Screens.SaleScreen.Screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f).size(200.dp)) {
                    Icon(painter = painterResource(R.drawable.menu___home), contentDescription = null,

                    )

                }
                IconButton(onClick = {
                    navController.navigate(Screens.PurchaseScreen.Screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f).size(200.dp)) {
                    Icon(painter = painterResource(R.drawable.purchase), contentDescription = null,
                    )

                }
                IconButton(onClick = {

                    navController.navigate(Screens.Home.Screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f).size(200.dp)) {
                    Image(painter = painterResource(R.drawable.home), contentDescription = "home",
                    )
                }
                IconButton(onClick = {
                    navController.navigate(Screens.ReportScreen.Screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f).size(200.dp)) {
                    Icon(painter = painterResource(R.drawable.report), contentDescription = null,
                    )

                }
                IconButton(onClick = {
                    navController.navigate(Screens.ChatScreen.Screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f).size(200.dp)) {
                    Icon(painter = painterResource(R.drawable.chat), contentDescription = null,
                    )

                }



            }








}
@Composable
fun singleitem(data: Itemss) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(data.Icon),
            contentDescription = null,
            tint = data.color,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.dp, data.color, CircleShape)
                .padding(10.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = data.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = data.desciprtion    )
        }

        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.End
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (data.pinIcon) {
                    Icon(
                        painter = painterResource(R.drawable.pinicon),
                        contentDescription = "pinIcon",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(16.dp)
                            .padding(top = 2.dp)
                    )
                }
                Text(
                    text = data.date,
                    modifier = Modifier.padding(end = if (data.pinIcon) 4.dp else 0.dp)
                )

            }
            Text(
                text = data.price,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
    HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
}

@Composable
fun Items(modifier: Modifier = Modifier) {

   val list =  listOf(
       Itemss(
           name = "To Pay",
           desciprtion = "your total pay",
           Icon = R.drawable.ellipse_rup,
           color = Color(0xFFFF0000),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = true
       ),
       Itemss(
           name = "To Collect",
           desciprtion = "your total Collection",
           Icon = R.drawable.down,
           color = Color(0xFF21A366),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = true
       ),
       Itemss(
           name = " Stock",
           desciprtion = " Stock amount",
           Icon = R.drawable.stockimage,
           color = Color(0xFF7738CF),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = true
       ),
       Itemss(
           name = "DSR",
           desciprtion = "Daily sales report",
           Icon = R.drawable.dsr,
           color = Color(0xFF7738CF),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = false
       ),
       Itemss(
           name = "Cash",
           desciprtion = "Cash in hand",
           Icon = R.drawable.cash,
           color = Color(0xFF21A366),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = false
       ),
       Itemss(
           name = "Bank",
           desciprtion = " Cash in bank",
           Icon = R.drawable.bank,
           color = Color(0xFFF3771E),
           date = "27 May 2025",
           price = "$ 9,800",
           pinIcon = false
       ),
       Itemss(
           name = "Expenses",
           desciprtion = "Daily sales report",
           Icon = R.drawable.expenses,
           color = Color(0xFFFF0000),
           date = "27 May 2025",
           price = "$9,800",
           pinIcon = false
       )





       )

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)

    ){

        items (list){item->
            singleitem(item)



        }
    }
    
}

@Preview
@Composable
private fun SingleItemPreview() {
    BottomAppBar()
}

data class Itemss (
    var name: String,
    var desciprtion: String,
    var Icon: Int,
    var color: Color,
    var date: String,
    var price: String,
    var pinIcon: Boolean

        )
