package com.chrisy.probonocases.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CaseViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CaseViewModel::class.java)) {
            return CaseViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}