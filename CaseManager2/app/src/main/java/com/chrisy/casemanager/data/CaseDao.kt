package com.chrisy.casemanager.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CaseDao {
    @Query("SELECT * FROM cases")
    fun getAllCases(): Flow<List<Case>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCase(caseObject: Case)

    @Delete
    suspend fun deleteCase(caseObject: Case)
}
