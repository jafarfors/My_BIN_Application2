package com.example.mybinapplication.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mybinapplication.presentation.viewmodel.BinViewModel

@Composable
fun BinInputScreen(viewModel: BinViewModel, onNavigateToHistory: () -> Unit) {
    var bin by remember { mutableStateOf("") }
    val binInfo by viewModel.binInfo.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = bin,
            onValueChange = { bin = it },
            label = { Text("Введите BIN") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.loadBinInfo(bin) }) {
            Text("Загрузить информацию")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToHistory) {
            Text("Перейти к истории")
        }
        binInfo?.let { info ->
            Spacer(modifier = Modifier.height(16.dp))
            Text("Страна: ${info.country.name}")
            Text("Координаты: ${info.country.latitude}, ${info.country.longitude}")
            Text("Тип карты: ${info.scheme}")
            Text("Банк: ${info.bank.name}")
            Text("URL: ${info.bank.url}")
            Text("Телефон: ${info.bank.phone}")
            Text("Город: ${info.bank.city}")
        }
    }
}