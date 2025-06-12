/*
package com.example.testproject.Utils

          Scaffold(
        topBar = { TopAppBar() },
        bottomBar = { BottomAppBar(navController) },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    val result = snackBarHostState
                        .showSnackbar(
                            message = "Snackbar",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Indefinite
                        )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            Toast.makeText(context, "Action performed", Toast.LENGTH_SHORT).show()
                        }
                        SnackbarResult.Dismissed -> {
                            Toast.makeText(context, "Snackbar dismissed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }) {
                Image(
                    painter = painterResource(R.drawable.invoice_),
                    contentDescription = "invoice",
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                viewModel.showBottomSheet()
                                viewModel.showBottomSheetData()
                            }
                        )
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
            composable(Screens.Home.Screen) { Home() }
            composable(Screens.ReportScreen.Screen) { ReportScreen() }
            composable(Screens.ChatScreen.Screen) { ChatScreen() }
            composable(Screens.TransactionScreen.Screen) { TransactionScreen(viewModel = viewModel) }

        }
    }
*/
