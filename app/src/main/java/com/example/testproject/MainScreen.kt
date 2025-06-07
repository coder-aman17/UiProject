import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testproject.BottomAppBar
import com.example.testproject.ChatScreen
import com.example.testproject.Items
import com.example.testproject.PurchaseScreen
import com.example.testproject.ReportScreen
import com.example.testproject.SaleScreen
import com.example.testproject.Screens
import com.example.testproject.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val context = LocalContext.current.applicationContext

    Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { Toast.makeText(context,"FloatingActionButton", Toast.LENGTH_SHORT).show()}) {
                Icon(Icons.Default.Add, contentDescription = null,
                )
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
            composable(Screens.Home.Screen) { Items() } // Your LazyColumn
            composable(Screens.ReportScreen.Screen) { ReportScreen() }
            composable(Screens.ChatScreen.Screen) { ChatScreen() }
        }
    }
}