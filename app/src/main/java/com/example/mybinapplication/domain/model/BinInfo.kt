package com.example.mybinapplication.domain.model

data class BinInfo(
    val number: Map<String, String>?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: Country,
    val bank: Bank
)

data class Country(
    val name: String,
    val latitude: Double,
    val longitude: Double
)

data class Bank(
    val name: String,
    val url: String?,
    val phone: String?,
    val city: String?
)