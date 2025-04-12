package com.chrisy.casemanager
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }
        composable(Screen.Cases.route) {
            CasesScreen(navController)
        }
        composable(Screen.Employees.route) {
            EmployeesScreen(navController)
        }
    }
}
