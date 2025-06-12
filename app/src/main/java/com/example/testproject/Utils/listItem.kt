package com.example.testproject.Utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testproject.DataClass.Itemss
import com.example.testproject.R

@Composable
fun ListItem(data: Itemss) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
                .background(color = Color.White)
                .padding(1.dp),
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
                Text(text = data.desciprtion)
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
}

@Composable
fun userData(values: PaddingValues) {

}
val list = listOf(
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