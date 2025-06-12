package com.example.testproject.Utils

import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testproject.R
import com.example.testproject.Utils.DropDownMenuList
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavController) {
    var showMenuBar by remember { mutableStateOf(false) }
    var capturedImage by remember { mutableStateOf<Bitmap?>(null) }
    var animation by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    // Camera launcher
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        if (bitmap != null) {
            capturedImage = bitmap
        }
    }
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text(text = "Hi Praveen!") },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF7738CF),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White

        ), actions = {
            IconButton(onClick = { cameraLauncher.launch(null) }) {
                Icon(painter = painterResource(R.drawable.camera), contentDescription = null)
            }
            IconButton(onClick = {
                Toast.makeText(context, "barcode", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(R.drawable.barcode), contentDescription = null)
            }
            IconButton(onClick = { showMenuBar = !showMenuBar }) {
                Icon(painter = painterResource(R.drawable.menu), contentDescription = null)
            }



            DropdownMenu(
                expanded = showMenuBar,
                onDismissRequest = { showMenuBar = false }
            ) {

                var isExpanded by remember { mutableStateOf(false) }

                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        isExpanded = !isExpanded
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = "Profile"
                        )
                    }

                )
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = slideInVertically {
                        with(density) { -40.dp.roundToPx() }
                    } + expandVertically(
                        expandFrom = Alignment.Top
                    ) + fadeIn(
                        initialAlpha = 0.3f
                    ),
                    exit = slideOutHorizontally() + shrinkVertically() + fadeOut()


                ) {
                    Column(
                        modifier = Modifier,

                        ) {
                        DropDownMenuList.forEach { item ->

                            Text(
                                text = item.name,
                                /*  textAlign = TextAlign.Center,*/
                                modifier = Modifier.padding(start = 17.dp),
                                fontFamily = FontFamily.SansSerif,
                                style = MaterialTheme.typography.bodyMedium

                            )


                        }

                    }


                }






                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        Toast.makeText(context, "Settings Item", Toast.LENGTH_SHORT).show()
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = "Settings"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Outlined.Favorite,
                            contentDescription = "Favorite"
                        )
                    }

                )
                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("Feedback") },
                    onClick = {
                        Toast.makeText(context, "Feedback Item", Toast.LENGTH_SHORT).show()
                    },
                    leadingIcon = {
                        Icon(
                            Icons.AutoMirrored.Outlined.Send,
                            contentDescription = "Feeddback"
                        )
                    },

                    )
                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("About") },
                    onClick = {
                        Toast.makeText(context, "About item", Toast.LENGTH_SHORT).show()
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = "About"
                        )
                    },


                    )
                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("Help") },
                    onClick = {
                        Toast.makeText(context, "Help item", Toast.LENGTH_SHORT).show()
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Call,
                            contentDescription = "Help"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = null
                        )
                    },


                    )
            }


        })
}



