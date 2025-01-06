package com.example.mybinapplication.domain.usecase

import com.example.mybinapplication.data.local.BinHistory
import com.example.mybinapplication.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow

class GetBinHistoryUseCase(private val repository: BinRepository) {
    operator fun invoke(): Flow<List<BinHistory>> = repository.getBinHistory()
}