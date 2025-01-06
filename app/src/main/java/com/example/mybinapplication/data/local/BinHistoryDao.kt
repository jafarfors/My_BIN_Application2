package com.example.mybinapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinHistoryDao {
    @Insert
    suspend fun insert(binHistory: BinHistory)

    @Query("SELECT * FROM bin_history ORDER BY bin DESC")
    fun getAll(): Flow<List<BinHistory>>
}