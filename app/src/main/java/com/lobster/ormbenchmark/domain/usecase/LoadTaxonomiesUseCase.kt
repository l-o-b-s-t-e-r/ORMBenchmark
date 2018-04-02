package com.lobster.ormbenchmark.domain.usecase

import com.lobster.ormbenchmark.core.UseCaseParameters
import com.lobster.ormbenchmark.core.UseCaseSingle
import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.domain.mapper.*
import com.lobster.ormbenchmark.domain.model.greendao.*
import io.reactivex.Single
import io.reactivex.functions.Function5
import javax.inject.Inject

/**
 * Created by Lobster on 31.03.18.
 */
class LoadTaxonomiesUseCase @Inject constructor(private val repository: ITaxonomiesRepository) : UseCaseSingle<TaxonomiesWrapper, UseCaseParameters>() {

    override fun createObservable(params: UseCaseParameters): Single<TaxonomiesWrapper> {
        return Single.zip(
                repository.getLabels(),
                repository.getAllergens(),
                repository.getCountries(),
                repository.getAdditives(),
                repository.getCategories(),
                Function5<LabelsWrapper, AllergensWrapper, CountriesWrapper, AdditivesWrapper, CategoriesWrapper, TaxonomiesWrapper> { labels, allergens, countries, additives, categories ->
                    TaxonomiesWrapper(allergens, additives, labels, countries, categories)
                })
    }
}