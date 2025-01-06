package com.example.mybinapplication.domain.repository

import com.example.mybinapplication.domain.model.BinInfo
import com.example.mybinapplication.data.local.BinHistory
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun getBinInfo(bin: String): BinInfo
    suspend fun saveBinHistory(binHistory: BinHistory)
    fun getBinHistory(): Flow<List<BinHistory>>
}