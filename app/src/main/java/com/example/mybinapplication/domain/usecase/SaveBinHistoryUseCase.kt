package com.example.mybinapplication.domain.usecase

import com.example.mybinapplication.data.local.BinHistory
import com.example.mybinapplication.domain.repository.BinRepository

class SaveBinHistoryUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(binHistory: BinHistory) = repository.saveBinHistory(binHistory)
}