package com.example.mybinapplication.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybinapplication.presentation.ui.BinHistoryScreen
import com.example.mybinapplication.presentation.ui.BinInputScreen
import com.example.mybinapplication.presentation.viewmodel.BinViewModel

@Composable
fun AppNavigation(viewModel: BinViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "binInput") {
        composable("binInput") {
            BinInputScreen(viewModel, onNavigateToHistory = {
                navController.navigate("binHistory")
            })
        }
        composable("binHistory") {
            BinHistoryScreen(viewModel, onNavigateBack = {
                navController.popBackStack()
            })
        }
    }
}