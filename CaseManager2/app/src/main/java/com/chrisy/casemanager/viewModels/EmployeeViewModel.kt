package com.chrisy.casemanager.viewModels
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.chrisy.casemanager.data.AppDatabase

class EmployeesViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    val employeeList = db.employeeDao().getAllEmployees().asLiveData()
}
