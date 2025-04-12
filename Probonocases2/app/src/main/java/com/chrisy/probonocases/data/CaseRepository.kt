package com.chrisy.probonocases.data

class CaseRepository(private val caseDao: CaseDao) {
    suspend fun getAllCases(): List<Case> = caseDao.getAllCases()
    suspend fun getCasesByStatus(status: String): List<Case> = caseDao.getCasesByStatus(status)
    suspend fun getCasesByCategory(category: String): List<Case> = caseDao.getCasesByCategory(category)
}