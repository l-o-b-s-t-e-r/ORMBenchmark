package com.lobster.ormbenchmark.data

import com.lobster.ormbenchmark.core.TaxonomiesApiService
import com.lobster.ormbenchmark.domain.model.*
import io.reactivex.Single

/**
 * Created by Lobster on 30.03.18.
 */
class TaxonomiesRepository(
        private val api: TaxonomiesApiService,
        private val dao: DaoSession) : ITaxonomiesRepository {

    override fun getLabels(): Single<List<Label>> {
        return api.getLabels()
                .map { it.map() }
    }

    override fun getAllergens(): Single<List<Allergen>> {
        return api.getAllergens()
                .map { it.map() }
    }

    override fun getCountries(): Single<List<Country>> {
        return api.getCountries()
                .map { it.map() }
    }

    override fun getCategories(): Single<List<Category>> {
        return api.getCategories()
                .map { it.map() }
    }

    override fun getAdditives(): Single<List<Additive>> {
        return api.getAdditives()
                .map { it.map() }
    }

    @Synchronized
    override fun saveLabels(labels: List<Label>) {
        for (label in labels) {
            dao.labelDao.insertOrReplaceInTx(label)
            for (labelName in label.getNames()) {
                dao.labelNameDao.insertOrReplace(labelName)
            }
        }
    }

    @Synchronized
    override fun saveAllergens(allergens: List<Allergen>) {
        for (allergen in allergens) {
            dao.allergenDao.insertOrReplaceInTx(allergen)
            for (allergenName in allergen.getNames()) {
                dao.allergenNameDao.insertOrReplace(allergenName)
            }
        }
    }

    @Synchronized
    override fun saveAdditives(additives: List<Additive>) {
        for (additive in additives) {
            dao.additiveDao.insertOrReplaceInTx(additive)
            for (additiveName in additive.getNames()) {
                dao.additiveNameDao.insertOrReplace(additiveName)
            }
        }
    }

    @Synchronized
    override fun saveCountries(countries: List<Country>) {
        for (country in countries) {
            dao.countryDao.insertOrReplaceInTx(country)
            for (countryName in country.getNames()) {
                dao.countryNameDao.insertOrReplace(countryName)
            }
        }
    }

    @Synchronized
    override fun saveCategories(categories: List<Category>) {
        for (category in categories) {
            dao.categoryDao.insertOrReplaceInTx(category)
            for (categoryName in category.getNames()) {
                dao.categoryNameDao.insertOrReplace(categoryName)
            }
        }
    }

}