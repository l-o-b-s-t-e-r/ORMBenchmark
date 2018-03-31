package com.lobster.ormbenchmark.view.main.di

import com.lobster.ormbenchmark.di.FragmentScope
import com.lobster.ormbenchmark.view.main.MainFragment
import dagger.Subcomponent

/**
 * Created by Lobster on 30.03.18.
 */

@Subcomponent(modules = [MainModule::class])
@FragmentScope
interface MainComponent {
    fun inject(fragment: MainFragment)
}