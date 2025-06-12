/*
package com.example.testproject.Utils
import android.R.attr.colorPrimary
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import com.example.testproject.R
@Composable
fun EInvoiceGenerateCard() {
    var showDropDown by remember { mutableStateOf(false) }
    val dropDownOptions = listOf("Hold", "Edit", "Generate")
    Column(
        modifier = Modifier
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(.75f),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.home_icon),
                    contentDescription = "Image",
                    modifier = Modifier.size(54.dp)
                )
                Column {
                    Text(
                        text = "Buyer Name",
                        fontSize = 14.sp,
                        color = Color(0xFF2D2A70)
                    )
                    Text(
                        text = "AA1234567890987",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color(0xFF2D2A70)
                    )
                }
            }
            Row(
                modifier = Modifier.weight(.25f),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column {
                    Text(
                        text = "27 May 2025",
                        fontSize = 12.sp,
                        color = Color(0xFF2D2A70)
                    )
                    Text(
                        text = "₹ 9,888",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF2D2A70)
                    )
                }
                Box {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(16.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                                onClick = {
                                    showDropDown = true
                                }
                            ),
                        tint = colorPrimary
                    )
                    DropdownMenu(
                        expanded = showDropDown,
                        onDismissRequest = { showDropDown = false },
                        containerColor = whiteColor
                    ) {
                        dropDownOptions.fastForEach {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = it,

                                        )
                                },
                                onClick = {}
                            )
                        }
                    }
                }
            }
        }

        HorizontalDivider(modifier = Modifier.padding(top = 5.dp, bottom = 3.dp))
    }
}*/
