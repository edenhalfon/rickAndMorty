package com.ehapps.templateProject

import android.app.Application
import com.ehapps.core.di.cacheModule
import com.ehapps.core.di.networkModule
import com.ehapps.core.di.repoModule
import com.ehapps.core.di.useCaseModule
import com.ehapps.templateProject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                networkModule,
                useCaseModule,
                viewModelModule,
                cacheModule,
                repoModule
            ))
        }
    }
}