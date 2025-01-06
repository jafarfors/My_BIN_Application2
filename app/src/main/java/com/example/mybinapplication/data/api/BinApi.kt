package com.example.mybinapplication.data.api

import com.example.mybinapplication.domain.model.BinInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfo
}