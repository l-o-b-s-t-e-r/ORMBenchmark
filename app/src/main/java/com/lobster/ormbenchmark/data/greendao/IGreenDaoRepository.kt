package com.lobster.ormbenchmark.data.greendao

import com.lobster.ormbenchmark.domain.model.greendao.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 01.04.18.
 */
interface IGreenDaoRepository {

    fun saveLabels(labels: List<LabelGreenDao>)

    fun saveAdditives(additives: List<AdditiveGreenDao>)

    fun saveCountries(countries: List<CountryGreenDao>)

    fun saveAllergens(allergens: List<AllergenGreenDao>)

    fun saveCategories(categories: List<CategoryGreenDao>)

    fun saveLabelsOld(labels: List<LabelGreenDao>)

    fun saveAdditivesOld(additives: List<AdditiveGreenDao>)

    fun saveCountriesOld(countries: List<CountryGreenDao>)

    fun saveAllergensOld(allergens: List<AllergenGreenDao>)

    fun saveCategoriesOld(categories: List<CategoryGreenDao>)

    fun getSavedTaxonomiesCount(): Single<Int>

    fun clear(): Completable

}