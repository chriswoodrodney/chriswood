package com.chrisy.casemanager

import com.chrisy.casemanager.data.*
import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.lazy.items
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
import com.chrisy.casemanager.viewModels.CasesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CasesScreen(
    navController: NavController,
    viewModel: CasesViewModel = viewModel(
        factory = AppViewModelFactory(LocalContext.current.applicationContext as Application)
    )
) {
    val cases by viewModel.caseList.observeAsState(initial = emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Cases") }) },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(cases) { case ->
                    Text("${case.name} - ${case.caseType} - ${case.status}")
                }
            }
        }
    )
}


@Composable
fun Button(onClick: () -> Unit, content: @Composable () -> Unit) {

}
