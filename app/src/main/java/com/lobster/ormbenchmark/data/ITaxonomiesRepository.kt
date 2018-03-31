package com.lobster.ormbenchmark.data

import com.lobster.ormbenchmark.domain.model.*
import io.reactivex.Single

/**
 * Created by Lobster on 30.03.18.
 */
interface ITaxonomiesRepository {

    fun getLabels(): Single<List<Label>>

    fun getAllergens(): Single<List<Allergen>>

    fun getAdditives(): Single<List<Additive>>

    fun getCountries(): Single<List<Country>>

    fun getCategories(): Single<List<Category>>

    fun saveLabels(labels: List<Label>)

    fun saveAdditives(additives: List<Additive>)

    fun saveCountries(countries: List<Country>)

    fun saveAllergens(allergens: List<Allergen>)

    fun saveCategories(categories: List<Category>)

}