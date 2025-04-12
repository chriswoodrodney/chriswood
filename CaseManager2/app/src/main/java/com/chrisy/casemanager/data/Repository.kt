package com.chrisy.casemanager.data



class Repository(
    private val caseDao: CaseDao,
    private val employeeDao: EmployeeDao
) {
    val allCases = caseDao.getAllCases()
    val allEmployees = employeeDao.getAllEmployees()

    suspend fun addCase(case: Case) = caseDao.insertCase(case)
    suspend fun addEmployee(employee: Employee) = employeeDao.insertEmployee(employee)
}
