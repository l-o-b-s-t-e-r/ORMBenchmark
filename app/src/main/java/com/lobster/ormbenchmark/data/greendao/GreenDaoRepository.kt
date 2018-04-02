package com.lobster.ormbenchmark.data.greendao

import com.lobster.ormbenchmark.domain.model.greendao.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 01.04.18.
 */
class GreenDaoRepository(private val dao: DaoSession): IGreenDaoRepository {

    private var savedTaxonomiesCount = 0

    private var classes = mapOf(
            Pair(AdditiveGreenDao::class.java, AdditiveNameGreenDao::class.java),
            Pair(LabelGreenDao::class.java, LabelNameGreenDao::class.java),
            Pair(CountryGreenDao::class.java, CountryNameGreenDao::class.java),
            Pair(AllergenGreenDao::class.java, AllergenNameGreenDao::class.java),
            Pair(CategoryGreenDao::class.java, CategoryNameGreenDao::class.java)
    )

    private val additiveDao = dao.additiveGreenDaoDao
    private val additiveNameDao = dao.additiveNameGreenDaoDao
    private val allergenDao = dao.allergenGreenDaoDao
    private val allergenNameDao = dao.allergenNameGreenDaoDao
    private val countryDao = dao.countryGreenDaoDao
    private val countryNameDao = dao.countryNameGreenDaoDao
    private val categoryDao = dao.categoryGreenDaoDao
    private val categoryNameDao = dao.categoryNameGreenDaoDao
    private val labelDao = dao.labelGreenDaoDao
    private val labelNameDao = dao.labelNameGreenDaoDao

    @Synchronized
    override fun saveLabels(labels: List<LabelGreenDao>) {
        val db = dao.database
        db.beginTransaction()
        try {
            labels.forEach { label ->
                labelDao.insertOrReplace(label)
                savedTaxonomiesCount++
                label.names.forEach { labelName ->
                    labelNameDao.insertOrReplace(labelName)
                    savedTaxonomiesCount++
                }
            }

            db.setTransactionSuccessful()
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            db.endTransaction()
        }
    }

    @Synchronized
    override fun saveAllergens(allergens: List<AllergenGreenDao>) {
        val db = dao.database
        db.beginTransaction()
        try {
            allergens.forEach { allergen ->
                allergenDao.insertOrReplace(allergen)
                savedTaxonomiesCount++
                allergen.names.forEach { allergenName ->
                    allergenNameDao.insertOrReplace(allergenName)
                    savedTaxonomiesCount++
                }
            }

            db.setTransactionSuccessful()
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            db.endTransaction()
        }
    }

    @Synchronized
    override fun saveAdditives(additives: List<AdditiveGreenDao>) {
        val db = dao.database
        db.beginTransaction()
        try {
            additives.forEach { additive ->
                additiveDao.insertOrReplace(additive)
                savedTaxonomiesCount++
                additive.names.forEach { additiveName ->
                    additiveNameDao.insertOrReplace(additiveName)
                    savedTaxonomiesCount++
                }
            }

            db.setTransactionSuccessful()
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            db.endTransaction()
        }
    }

    @Synchronized
    override fun saveCountries(countries: List<CountryGreenDao>) {
        val db = dao.database
        db.beginTransaction()
        try {
            countries.forEach { country ->
                countryDao.insertOrReplace(country)
                savedTaxonomiesCount++
                country.names.forEach { countryName ->
                    countryNameDao.insertOrReplace(countryName)
                    savedTaxonomiesCount++
                }
            }

            db.setTransactionSuccessful()
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            db.endTransaction()
        }
    }

    @Synchronized
    override fun saveCategories(categories: List<CategoryGreenDao>) {
        val db = dao.database
        db.beginTransaction()
        try {
            categories.forEach { category ->
                categoryDao.insertOrReplace(category)
                savedTaxonomiesCount++

                category.names.forEach { categoryName ->
                    categoryNameDao.insertOrReplace(categoryName)
                    savedTaxonomiesCount++
                }
            }

            db.setTransactionSuccessful()
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            db.endTransaction()
        }
    }

    override fun getSavedTaxonomiesCount(): Single<Int> {
        return Single.just(savedTaxonomiesCount)
    }

    override fun clear() = Completable.fromAction {
        dao.apply {
            savedTaxonomiesCount = 0

            classes.forEach {
                deleteAll(it.value)
                deleteAll(it.key)
            }

            clear()
        }
    }

}