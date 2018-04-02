package com.lobster.ormbenchmark.data.objectbox

import com.lobster.ormbenchmark.domain.model.objectbox.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 01.04.18.
 */
interface IObjectBoxRepository {

    fun saveLabels(labels: List<LabelObjectBox>)

    fun saveAdditives(additives: List<AdditiveObjectBox>)

    fun saveCountries(countries: List<CountryObjectBox>)

    fun saveAllergens(allergens: List<AllergenObjectBox>)

    fun saveCategories(categories: List<CategoryObjectBox>)

    fun getSavedTaxonomiesCount(): Single<Int>

    fun clear(): Completable

}