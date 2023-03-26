package com.gb.stopwatch

import android.app.Application
import com.gb.stopwatch.data.di.mainModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule)
        }
    }
}