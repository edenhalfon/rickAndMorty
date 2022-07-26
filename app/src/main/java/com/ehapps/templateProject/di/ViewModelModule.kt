package com.ehapps.templateProject.di

import com.ehapps.templateProject.homePage.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomePageViewModel(get()) }
}