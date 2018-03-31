package com.lobster.ormbenchmark.di

import com.lobster.ormbenchmark.view.main.di.MainComponent
import com.lobster.ormbenchmark.view.main.di.MainModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Lobster on 29.03.18.
 */

@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
@Singleton
interface AppComponent {

    fun plusMainComponent(mainModule: MainModule): MainComponent

}