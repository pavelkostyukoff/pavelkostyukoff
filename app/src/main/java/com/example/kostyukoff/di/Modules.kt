package com.example.kostyukoff.di

import com.example.kostyukoff.model.LatestsDataSource
import com.example.kostyukoff.ui.latest.GetLatestsUseCase
import com.example.kostyukoff.ui.latest.LatestViewModel
import com.example.kostyukoff.repostitory.LatestsRepository
import com.example.kostyukoff.repostitory.LatestsRepositoryImpl
import com.example.kostyukoff.ui.main.PageViewModel
import com.example.local.LocalDataSource
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val module =  module {
    viewModel { LatestViewModel(get()) }
    single { LocalDataSource(get()) } bind LatestsDataSource::class

    single { LatestsRepositoryImpl(get()) } bind LatestsRepository::class


    viewModel { PageViewModel(get()) }
    factory { GetLatestsUseCase(get()) }
}