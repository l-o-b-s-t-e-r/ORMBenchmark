package com.lobster.ormbenchmark.view.main.di

import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.di.FragmentScope
import com.lobster.ormbenchmark.domain.usecase.ClearGreenDaoUseCase
import com.lobster.ormbenchmark.domain.usecase.GetSavedTaxonomiesCountUseCase
import com.lobster.ormbenchmark.domain.usecase.LoadTaxonomiesUseCase
import com.lobster.ormbenchmark.domain.usecase.SaveTaxonomiesUseCase
import com.lobster.ormbenchmark.utils.MockData
import com.lobster.ormbenchmark.view.main.OrmListAdapter
import com.lobster.ormbenchmark.view.main.mvp.IMainPresenter
import com.lobster.ormbenchmark.view.main.mvp.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Lobster on 30.03.18.
 */

@Module
class MainModule {

    @Provides
    @FragmentScope
    fun provideMainPresenter(loadTaxonomiesUseCase: LoadTaxonomiesUseCase,
                             saveTaxonomiesUseCase: SaveTaxonomiesUseCase,
                             getSavedTaxonomiesCountUseCase: GetSavedTaxonomiesCountUseCase,
                             clearGreenDaoUseCase: ClearGreenDaoUseCase,
                             data: MockData): IMainPresenter.Actions {
        return MainPresenter(
                loadTaxonomiesUseCase,
                saveTaxonomiesUseCase,
                getSavedTaxonomiesCountUseCase,
                clearGreenDaoUseCase,
                data
        )
    }

    @Provides
    @FragmentScope
    fun provideAdapter() = OrmListAdapter()
}