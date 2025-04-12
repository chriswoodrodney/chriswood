package com.chrisy.probonocases.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CaseDao {
    // Change parameter name from 'case' to 'caseEntity'
    // 'case' is a Java keyword, which is likely causing the code generation issue
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCase(caseEntity: Case)

    // Keep these as is
    @Query("SELECT * FROM case_table")
    suspend fun getAllCases(): List<Case>

    @Query("SELECT * FROM case_table WHERE status = :status")
    suspend fun getCasesByStatus(status: String): List<Case>

    @Query("SELECT * FROM case_table WHERE category = :category")
    suspend fun getCasesByCategory(category: String): List<Case>

    @Query("SELECT * FROM case_table LIMIT :limit OFFSET :offset")
    suspend fun getPaginatedCases(limit: Int, offset: Int): List<Case>

    @Query("SELECT * FROM case_table ORDER BY title ASC")
    suspend fun getAllCasesSortedByTitle(): List<Case>

    @Query("SELECT * FROM case_table WHERE status = :status AND category = :category")
    suspend fun getCasesByStatusAndCategory(status: String, category: String): List<Case>
}