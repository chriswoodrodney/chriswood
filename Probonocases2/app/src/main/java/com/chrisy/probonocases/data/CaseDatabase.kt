package com.chrisy.probonocases.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The Room database for this app
 */
@Database(entities = [Case::class], version = 1, exportSchema = false)
abstract class CaseDatabase : RoomDatabase() {

    abstract fun caseDao(): CaseDao

    companion object {
        @Volatile
        private var INSTANCE: CaseDatabase? = null

        fun getDatabase(context: Context): CaseDatabase {
            // if the INSTANCE is not null, return it, otherwise create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CaseDatabase::class.java,
                    "case_database"
                )
                    .fallbackToDestructiveMigration() // Wipes and rebuilds instead of migrating if no Migration object
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}