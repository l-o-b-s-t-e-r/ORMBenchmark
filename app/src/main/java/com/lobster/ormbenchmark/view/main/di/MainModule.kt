package com.lobster.ormbenchmark.view.main.di

import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.di.FragmentScope
import com.lobster.ormbenchmark.domain.usecase.LoadAndSaveTaxonomiesUseCase
import com.lobster.ormbenchmark.view.main.mvp.IMainPresenter
import com.lobster.ormbenchmark.view.main.mvp.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Lobster on 30.03.18.
 */

@Module
class MainModule {

    /*@Provides
    @FragmentScope
    fun provideMainPresenter(useCase: LoadAndSaveTaxonomiesUseCase): IMainPresenter.Actions {
        return MainPresenter(useCase)
    }*/

}