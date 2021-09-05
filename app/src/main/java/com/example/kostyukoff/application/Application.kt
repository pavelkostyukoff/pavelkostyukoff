package com.example.kostyukoff.application

import android.app.Application
import com.example.kostyukoff.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

class Application : Application(), KoinComponent {
    val DEVLIFE_URL = "http://developerslife.ru"
    val COMMENTS_PATH = "comments/entry"
    val RANDOM_PATH = "random"

    val PAGE_SIZE_PARAM = "pageSize"
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(listOf(module))
            koin.createRootScope()
        }
    }
}