package com.chrisy.probonocases.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chrisy.probonocases.data.Case
import kotlinx.coroutines.launch

class CaseViewModel : ViewModel() {

    private val _filteredCases = MutableLiveData<List<Case>>()
    val filteredCases: LiveData<List<Case>> = _filteredCases

    // Mock data for demonstration
    private val casesList = listOf(
        Case(
            id = "1",
            title = "Smith vs. Jones",
            description = "Civil rights violation case involving workplace discrimination.",
            status = "Pending",
            category = "Civil Rights"
        ),
        Case(
            id = "2",
            title = "Garcia Family Immigration Case",
            description = "Asylum application for a family fleeing violence.",
            status = "Won",
            category = "Immigration"
        ),
        Case(
            id = "3",
            title = "Thompson Medical Malpractice",
            description = "Medical malpractice claim against county hospital.",
            status = "Lost",
            category = "Medical"
        ),
        Case(
            id = "4",
            title = "Davis Housing Dispute",
            description = "Tenant facing illegal eviction from subsidized housing.",
            status = "Pending",
            category = "Housing"
        ),
        Case(
            id = "5",
            title = "Wilson Veterans Benefits",
            description = "Appeal for denied veterans disability benefits.",
            status = "Untouched",
            category = "Veterans Affairs"
        )
    )

    // Fetch all cases
    fun fetchCases() {
        viewModelScope.launch {
            _filteredCases.value = casesList
        }
    }

    // Fetch cases filtered by status
    fun fetchCasesByStatus(status: String) {
        viewModelScope.launch {
            if (status == "All") {
                _filteredCases.value = casesList
            } else {
                _filteredCases.value = casesList.filter { it.status == status }
            }
        }
    }
}