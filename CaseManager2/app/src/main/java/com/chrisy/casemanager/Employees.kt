package com.chrisy.casemanager

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chrisy.casemanager.viewModels.AppViewModelFactory
import com.chrisy.casemanager.viewModels.EmployeesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeesScreen(
    navController: NavController,
    viewModel: EmployeesViewModel = viewModel(
        factory = AppViewModelFactory(LocalContext.current.applicationContext as Application)
    )
) {
    val employees by viewModel.employeeList.observeAsState(emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Employees") }) },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(employees) { emp ->
                    Text("${emp.name} - ${emp.role} - ${emp.contact}")
                }
            }
        }
    )
}
