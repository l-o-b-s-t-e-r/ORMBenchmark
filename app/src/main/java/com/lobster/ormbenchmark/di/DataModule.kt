package com.lobster.ormbenchmark.di

import android.app.Application
import com.lobster.ormbenchmark.BuildConfig
import com.lobster.ormbenchmark.core.DatabaseHelper
import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.core.TaxonomiesApiService
import com.lobster.ormbenchmark.data.TaxonomiesRepository
import com.lobster.ormbenchmark.domain.model.DaoMaster
import com.lobster.ormbenchmark.domain.model.DaoSession
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Lobster on 30.03.18.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDaoSession(application: Application): DaoSession {
        val helper = DatabaseHelper(application, BuildConfig.DATABASE_NAME)
        return DaoMaster(helper.writableDb).newSession()
    }

    @Provides
    @Singleton
    fun provideCategoryNetworkService(retrofit: Retrofit): TaxonomiesApiService {
        return retrofit.create<TaxonomiesApiService>(TaxonomiesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTaxonomiesRepository(api: TaxonomiesApiService, daoSession: DaoSession): ITaxonomiesRepository {
        return TaxonomiesRepository(api, daoSession)
    }

}