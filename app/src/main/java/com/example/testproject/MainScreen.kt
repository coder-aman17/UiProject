import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testproject.BottomAppBar
import com.example.testproject.ChatScreen
import com.example.testproject.Home
import com.example.testproject.Items
import com.example.testproject.PurchaseScreen
import com.example.testproject.R
import com.example.testproject.ReportScreen
import com.example.testproject.SaleScreen
import com.example.testproject.Screens
import com.example.testproject.TopAppBar
import com.example.testproject.TransactionScreen
import kotlinx.coroutines.flow.combine

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val context = LocalContext.current.applicationContext
    var sheetState = rememberModalBottomSheetState()
    var showSheetState by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showSheetState = true

            }) {
                Image(painter = painterResource(R.drawable.invoice_), contentDescription = "invoice")

            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.Screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.SaleScreen.Screen) { SaleScreen() }
            composable(Screens.PurchaseScreen.Screen) { PurchaseScreen() }
            composable(Screens.Home.Screen) { Home() }
            composable(Screens.ReportScreen.Screen) { ReportScreen() }
            composable(Screens.ChatScreen.Screen) { ChatScreen() }
            composable(Screens.TransactionScreen.Screen) { TransactionScreen() }

        }
    }

    if(showSheetState){
        ModalBottomSheet(onDismissRequest = {showSheetState = false},
            sheetState = sheetState) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ){
                TransactionScreen()
//                BottomSheetItem(Icon = Icons.Default.Info, title = "Show Details") {
//                    showSheetState = false
//                    Toast.makeText(context, "Navigating to Transaction Screen", Toast.LENGTH_SHORT)
//                        .show()
//                    navController.navigate(Screens.TransactionScreen.Screen)
//                }
            }



        }
    }

}


