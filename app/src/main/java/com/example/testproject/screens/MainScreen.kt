import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton

import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SnackbarHostState

import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

import com.example.testproject.viewModels.TransactionScreenViewmodel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testproject.DataClass.list
import com.example.testproject.R
import com.example.testproject.Utils.BottomSheet
import com.example.testproject.Utils.CustomScaffold
import com.example.testproject.Utils.BottomAppBar
import com.example.testproject.Utils.ListItem
import com.example.testproject.Utils.SearchBar
import com.example.testproject.Utils.TopAppBar

import com.example.testproject.screens.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: TransactionScreenViewmodel = hiltViewModel()) {

    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val context = LocalContext.current.applicationContext
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val showSheetState by viewModel.isBottomSheetVisible.collectAsState()
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    var capturedImage by remember { mutableStateOf<Bitmap?>(null) }
    var query by remember { mutableStateOf("") }

    // Camera launcher
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
        if (bitmap != null) {
            capturedImage = bitmap
        }
    }
    CustomScaffold(
        navController = navController,
        modifier = Modifier,
        topBar = { TopAppBar(navController) },
        bottomAppBar = { BottomAppBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                   viewModel.showBottomSheet()
                    viewModel.showBottomSheetData()

                }
            ) {
                Image(
                    painter = painterResource(R.drawable.invoice_),
                    contentDescription = "invoice",
                    modifier = Modifier

                )
            }

        },
        snackBar = {}
    ) {
        Column (
        modifier = Modifier.fillMaxSize().padding(it)
    ){
        SearchBar(viewModel = viewModel(), searchQuery = {
            query = it
        })


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)

                    .padding(5.dp)

            ) {


                items(if(query.isBlank()) list else list.filter { it.name.contains(query) }) { item ->

                    ListItem(item)


                }
                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }








        }

    }




    if (showSheetState) {
        ModalBottomSheet(
            onDismissRequest = { viewModel.hideBottomSheet() },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                BottomSheet(viewModel = viewModel)
            }
        }
    }
}

