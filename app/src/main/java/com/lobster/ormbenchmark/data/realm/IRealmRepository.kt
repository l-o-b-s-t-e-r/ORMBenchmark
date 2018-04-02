package com.lobster.ormbenchmark.data.realm

import com.lobster.ormbenchmark.domain.model.realm.*
import com.lobster.ormbenchmark.domain.response.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 01.04.18.
 */
interface IRealmRepository {

    fun saveLabels(labels: List<LabelResponse>)

    fun saveAdditives(additives: List<AdditiveResponse>)

    fun saveCountries(countries: List<CountryResponse>)

    fun saveAllergens(allergens: List<AllergenResponse>)

    fun saveCategories(categories: List<CategoryResponse>)

    fun getSavedTaxonomiesCount(): Single<Int>

    fun clear(): Completable

}