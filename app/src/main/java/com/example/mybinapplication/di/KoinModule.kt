package com.example.mybinapplication.di

import com.example.mybinapplication.data.api.BinApi
import com.example.mybinapplication.data.local.AppDatabase
import com.example.mybinapplication.data.local.BinHistoryDao
import com.example.mybinapplication.data.repository.BinRepositoryImpl
import com.example.mybinapplication.domain.repository.BinRepository
import com.example.mybinapplication.domain.usecase.GetBinHistoryUseCase
import com.example.mybinapplication.domain.usecase.GetBinInfoUseCase
import com.example.mybinapplication.domain.usecase.SaveBinHistoryUseCase
import com.example.mybinapplication.presentation.viewmodel.BinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // Retrofit и BinApi
    single {
        Retrofit.Builder()
            .baseUrl("https://binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinApi::class.java)
    }

    // Room Database
    single {
        AppDatabase.getDatabase(androidContext())
    }

    // BinRepository
    single<BinRepository> {
        BinRepositoryImpl(
            binApi = get<BinApi>(), // Явно указываем тип BinApi
            binHistoryDao = get<AppDatabase>().binHistoryDao() // Явно указываем тип AppDatabase
        )
    }

    // UseCases
    single { GetBinInfoUseCase(get()) }
    single { SaveBinHistoryUseCase(get()) }
    single { GetBinHistoryUseCase(get()) }

    // ViewModel
    viewModel { BinViewModel(get(), get(), get()) }
}