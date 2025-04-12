package com.chrisy.casemanager.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.chrisy.casemanager.data.AppDatabase

class CasesViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    val caseList = db.caseDao().getAllCases().asLiveData()
}