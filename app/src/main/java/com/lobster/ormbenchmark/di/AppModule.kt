package com.lobster.ormbenchmark.di

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.support.annotation.RequiresApi
import dagger.Module
import dagger.Provides
import org.jetbrains.anko.notificationManager
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

    @Provides
    @Singleton
    fun provideNotificationChannel(): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("app_channel_1", "global_channel", NotificationManager.IMPORTANCE_MAX)
            application.notificationManager.createNotificationChannel(notificationChannel)

            return notificationChannel.id
        } else {
            return ""
        }
    }
}