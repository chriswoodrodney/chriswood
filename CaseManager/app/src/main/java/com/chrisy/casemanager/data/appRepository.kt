
// Repository.kt
package com.chrisy.casemanager.data

import AppDao
import kotlinx.coroutines.flow.Flow

class AppRepository(private val dao: AppDao) {
    val allCases: Unit = dao.getAllCases()
    val allEmployees: Flow<List<Employee>> = dao.getAllEmployees()

    suspend fun addCase(case: Case) = dao.insertCase(case)
    suspend fun addEmployee(employee: Employee) = dao.insertEmployee(employee)
}
