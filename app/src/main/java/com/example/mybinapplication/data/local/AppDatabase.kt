package com.example.mybinapplication.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(entities = [BinHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun binHistoryDao(): BinHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bin_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}