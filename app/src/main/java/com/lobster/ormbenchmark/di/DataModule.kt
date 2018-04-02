package com.lobster.ormbenchmark.di

import android.app.Application
import com.lobster.ormbenchmark.BuildConfig
import com.lobster.ormbenchmark.core.DatabaseHelper
import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.data.TaxonomiesApiService
import com.lobster.ormbenchmark.data.TaxonomiesRepository
import com.lobster.ormbenchmark.data.greendao.GreenDaoRepository
import com.lobster.ormbenchmark.data.greendao.IGreenDaoRepository
import com.lobster.ormbenchmark.data.objectbox.IObjectBoxRepository
import com.lobster.ormbenchmark.data.objectbox.ObjectBoxRepository
import com.lobster.ormbenchmark.data.realm.IRealmRepository
import com.lobster.ormbenchmark.data.realm.RealmRepository
import com.lobster.ormbenchmark.domain.model.greendao.DaoMaster
import com.lobster.ormbenchmark.domain.model.greendao.DaoSession
import com.lobster.ormbenchmark.domain.model.objectbox.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
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
    fun provideObjectBox(application: Application): BoxStore {
        return MyObjectBox.builder().androidContext(application).build()
    }

    @Provides
    @Singleton
    fun provideCategoryNetworkService(retrofit: Retrofit): TaxonomiesApiService {
        return retrofit.create<TaxonomiesApiService>(TaxonomiesApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTaxonomiesRepository(api: TaxonomiesApiService): ITaxonomiesRepository {
        return TaxonomiesRepository(api)
    }

    @Provides
    @Singleton
    fun provideGreenDaoRepository(dao: DaoSession): IGreenDaoRepository {
        return GreenDaoRepository(dao)
    }

    @Provides
    @Singleton
    fun provideObjectBoxRepository(boxStore: BoxStore): IObjectBoxRepository {
        return ObjectBoxRepository(boxStore)
    }

    @Provides
    @Singleton
    fun provideRealmRepository(): IRealmRepository {
        return RealmRepository()
    }
}