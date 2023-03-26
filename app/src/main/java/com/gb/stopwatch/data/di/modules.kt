package com.gb.stopwatch.data.di

import com.gb.stopwatch.presentation.viewModel.MainActivityViewModel
import com.gb.stopwatch.presentation.viewModel.MainActivityViewModelContract
import org.koin.dsl.module

val mainModule = module {
    single<MainActivityViewModelContract.ViewModel> { MainActivityViewModel() }
}