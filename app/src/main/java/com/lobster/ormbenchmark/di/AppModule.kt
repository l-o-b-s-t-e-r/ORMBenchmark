package com.lobster.ormbenchmark.di

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Lobster on 29.03.18.
 */
@Module
class AppModule(private val application: Application) {

    companion object {
        val CONNECT_TIMEOUT = 5000L;
        val READ_TIMEOUT = 30000L;
        val WRITE_TIMEOUT = 30000L;
    }

    @Provides
    @Singleton
    fun provideApplication() = application
}