package com.lobster.ormbenchmark.data

import com.lobster.ormbenchmark.domain.mapper.*
import com.lobster.ormbenchmark.domain.model.greendao.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 30.03.18.
 */
interface ITaxonomiesRepository {

    fun getLabels(): Single<LabelsWrapper>

    fun getAllergens(): Single<AllergensWrapper>

    fun getAdditives(): Single<AdditivesWrapper>

    fun getCountries(): Single<CountriesWrapper>

    fun getCategories(): Single<CategoriesWrapper>

}