package com.example.mybinapplication.domain.usecase

import com.example.mybinapplication.domain.repository.BinRepository

class GetBinInfoUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(bin: String) = repository.getBinInfo(bin)
}