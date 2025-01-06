package com.example.mybinapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybinapplication.data.local.BinHistory
import com.example.mybinapplication.domain.model.BinInfo
import com.example.mybinapplication.domain.usecase.GetBinHistoryUseCase
import com.example.mybinapplication.domain.usecase.GetBinInfoUseCase
import com.example.mybinapplication.domain.usecase.SaveBinHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BinViewModel(
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val saveBinHistoryUseCase: SaveBinHistoryUseCase,
    private val getBinHistoryUseCase: GetBinHistoryUseCase
) : ViewModel() {

    private val _binInfo = MutableStateFlow<BinInfo?>(null)
    val binInfo: StateFlow<BinInfo?> get() = _binInfo

    private val _binHistory = MutableStateFlow<List<BinHistory>>(emptyList())
    val binHistory: StateFlow<List<BinHistory>> get() = _binHistory.asStateFlow()

    fun loadBinInfo(bin: String) {
        viewModelScope.launch {
            val info = getBinInfoUseCase(bin)
            _binInfo.value = info
            saveBinHistoryUseCase(BinHistory(
                bin = bin,
                country = info.country.name,
                coordinates = "${info.country.latitude}, ${info.country.longitude}",
                cardType = info.scheme ?: "",
                bankName = info.bank.name,
                bankUrl = info.bank.url,
                bankPhone = info.bank.phone,
                bankCity = info.bank.city
            ))
        }
    }

    fun loadBinHistory() {
        viewModelScope.launch {
            getBinHistoryUseCase().collect { history ->
                _binHistory.value = history
            }
        }
    }
}