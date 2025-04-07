package com.example.expensetracker.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.ui.screens.DashboardScreen
import com.example.expensetracker.ui.screens.AddTransactionScreen
import com.example.expensetracker.ui.screens.CategorySelectionScreen

@Composable
fun ExpenseTrackerApp(windowSizeClass: WindowSizeClass) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { 
            DashboardScreen(
                onAddTransaction = { navController.navigate("add_transaction") },
                windowSizeClass = windowSizeClass
            )
        }
        composable("add_transaction") { 
            AddTransactionScreen(
                onBack = { navController.popBackStack() },
                onSelectCategory = { navController.navigate("select_category") }
            )
        }
        composable("select_category") { 
            CategorySelectionScreen(
                onBack = { navController.popBackStack() },
                onCategorySelected = { navController.popBackStack() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExpenseTrackerApp() {
    ExpenseTrackerApp(windowSizeClass = WindowSizeClass())
}