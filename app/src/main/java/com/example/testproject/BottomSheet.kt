package com.example.testproject

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.viewModels.TransactionScreenViewmodel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TransactionScreen( viewModel: TransactionScreenViewmodel) {
    val sections = viewModel.bottomSheetData.collectAsState()
   /* val sections = listOf(
        Section(
            title = "Sale Transaction",
            items = listOf(
                Item("Register", R.drawable.register),
                Item("Monthly invoices", R.drawable.mi),
                Item("Party Ledger", R.drawable.partyledger),
                Item("Payment in", R.drawable.payin),
                Item("Credit Note", R.drawable.creditnotice),
                Item("E-Way", R.drawable.eway),
                Item("E Transaction", R.drawable.etrans),
                Item("MultiRecharge", R.drawable.multi)
            )
        ),
        Section(
            title = "Purchase Transaction",
            items = listOf(
                Item("Register", R.drawable.debit),
                Item("Debit Note", R.drawable.debit),
                Item("Part Ledger", R.drawable.partyledger),
                Item("Payment Out", R.drawable.payout)
            )
        ),
        Section(
            title = "Stock Monitoring",
            items = listOf(
                Item("Stock Register", R.drawable.stockreg),
                Item("FSE", R.drawable.fse),
                Item("DSR Collection", R.drawable.dcr)
            )
        )
    )*/

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        sections.value.forEachIndexed { index, section ->
            Text(
                text = section.title,
                color = Color(0xFF6B46C1),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFE9D8FD), RoundedCornerShape(20.dp))
                    .padding(vertical = 6.dp, horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(12.dp))

            if (section.title == "Stock Monitoring") {
                // Centered the Stock Monitoring section items horizontally
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    section.items.forEach { item ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.name,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = item.name,
                                fontSize = 13.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            } else {
                FlowRow(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    maxItemsInEachRow = 4,
                    verticalArrangement = Arrangement.spacedBy(16.dp),


                    ) {
                    section.items.forEach { item ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)

                            ) {
                            Image(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.name,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = item.name,
                                fontSize = 13.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp),
                                maxLines = 2,
                            )
                        }

                        /* LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.heightIn(max = 250.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    items(section.items) { item ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,

                        ) {
                            Image(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.name,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(
                                text = item.name,
                                fontSize = 13.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }*/
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

            }
        }
    }
}
/*
@Preview
@Composable
fun TransactionScreenTest(modifier: Modifier = Modifier) {
    TransactionScreen(
        modifier = TODO(),
        viewModel = TODO()
    )
}*/
