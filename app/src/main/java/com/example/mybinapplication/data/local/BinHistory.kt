package com.example.mybinapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_history")
data class BinHistory(
    @PrimaryKey val bin: String,
    val country: String,
    val coordinates: String,
    val cardType: String,
    val bankName: String,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?
)