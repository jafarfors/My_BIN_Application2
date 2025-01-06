package com.example.mybinapplication.data.repository

import com.example.mybinapplication.data.api.BinApi
import com.example.mybinapplication.data.local.BinHistoryDao
import com.example.mybinapplication.domain.model.BinInfo
import com.example.mybinapplication.domain.repository.BinRepository
import com.example.mybinapplication.data.local.BinHistory
import kotlinx.coroutines.flow.Flow

class BinRepositoryImpl(
    private val binApi: BinApi,
    private val binHistoryDao: BinHistoryDao
) : BinRepository {
    override suspend fun getBinInfo(bin: String): BinInfo {
        return binApi.getBinInfo(bin)
    }

    override suspend fun saveBinHistory(binHistory: BinHistory) {
        binHistoryDao.insert(binHistory)
    }

    override fun getBinHistory(): Flow<List<BinHistory>> {
        return binHistoryDao.getAll()
    }
}