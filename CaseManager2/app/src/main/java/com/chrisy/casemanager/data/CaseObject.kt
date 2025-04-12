package com.chrisy.casemanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cases")
data class Case(
    @PrimaryKey(autoGenerate = true) val caseId: Int = 0,
    val name: String,
    val caseType: String,
    val date: String,
    val lawyer: String,
    val judge: String,
    val status: String
)
