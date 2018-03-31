package com.lobster.ormbenchmark

import android.app.Application
import com.lobster.ormbenchmark.di.AppComponent
import com.lobster.ormbenchmark.di.AppModule
import com.lobster.ormbenchmark.di.DaggerAppComponent

/**
 * Created by Lobster on 29.03.18.
 */
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}