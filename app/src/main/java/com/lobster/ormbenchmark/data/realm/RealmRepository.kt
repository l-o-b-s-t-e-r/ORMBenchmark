package com.lobster.ormbenchmark.data.realm

import com.lobster.ormbenchmark.domain.model.realm.*
import com.lobster.ormbenchmark.domain.response.*
import io.reactivex.Completable
import io.reactivex.Single
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by Lobster on 01.04.18.
 */
class RealmRepository @Inject constructor() : IRealmRepository {

    private var savedTaxonomiesCount = 0
    private var classes = mapOf(
            Pair(AdditiveRealm::class.java, AdditiveNameRealm::class.java),
            Pair(LabelRealm::class.java, LabelNameRealm::class.java),
            Pair(CountryRealm::class.java, CountryNameRealm::class.java),
            Pair(AllergenRealm::class.java, AllergenNameRealm::class.java),
            Pair(CategoryRealm::class.java, CategoryNameRealm::class.java)
    )

    override fun saveLabels(labels: List<LabelResponse>) {
        Realm.getDefaultInstance().apply {
            beginTransaction()
            labels.forEach {
                val label = createObject(LabelRealm::class.java, it.code)
                it.names.entries.forEach {
                    val labelName = createObject(LabelNameRealm::class.java)
                    labelName.languageCode = it.key
                    labelName.name = it.value

                    label.names.add(labelName)
                    savedTaxonomiesCount++
                }
                savedTaxonomiesCount++
            }
            commitTransaction()
            close()
        }
    }

    override fun saveAdditives(additives: List<AdditiveResponse>) {
        Realm.getDefaultInstance().apply {
            beginTransaction()
            additives.forEach {
                val additive = createObject(AdditiveRealm::class.java, it.tag)
                it.names.entries.forEach {
                    val additiveName = createObject(AdditiveNameRealm::class.java)
                    additiveName.languageCode = it.key
                    additiveName.name = it.value

                    additive.names.add(additiveName)
                    savedTaxonomiesCount++
                }
                savedTaxonomiesCount++
            }
            commitTransaction()
            close()
        }
    }

    override fun saveCountries(countries: List<CountryResponse>) {
        Realm.getDefaultInstance().apply {
            beginTransaction()
            countries.forEach {
                val country = createObject(CountryRealm::class.java, it.tag)
                it.names.entries.forEach {
                    val countryName = createObject(CountryNameRealm::class.java)
                    countryName.languageCode = it.key
                    countryName.name = it.value

                    country.names.add(countryName)
                    savedTaxonomiesCount++
                }
                savedTaxonomiesCount++
            }
            commitTransaction()
            close()
        }
    }

    override fun saveAllergens(allergens: List<AllergenResponse>) {
        Realm.getDefaultInstance().apply {
            beginTransaction()
            allergens.forEach {
                val allergen = createObject(AllergenRealm::class.java, it.uniqueAllergenID)
                it.names.entries.forEach {
                    val allergenName = createObject(AllergenNameRealm::class.java)
                    allergenName.languageCode = it.key
                    allergenName.name = it.value

                    allergen.names.add(allergenName)
                    savedTaxonomiesCount++
                }
                savedTaxonomiesCount++
            }
            commitTransaction()
            close()
        }
    }

    override fun saveCategories(categories: List<CategoryResponse>) {
        Realm.getDefaultInstance().apply {
            beginTransaction()
            categories.forEach {
                val category = createObject(CategoryRealm::class.java, it.code)
                it.names.entries.forEach {
                    val categoryName = createObject(CategoryNameRealm::class.java)
                    categoryName.languageCode = it.key
                    categoryName.name = it.value

                    category.names.add(categoryName)
                    savedTaxonomiesCount++
                }
                savedTaxonomiesCount++
            }
            commitTransaction()
            close()
        }
    }

    override fun getSavedTaxonomiesCount(): Single<Int> {
        return Single.just(savedTaxonomiesCount)
    }

    override fun clear() = Completable.fromAction {
        savedTaxonomiesCount = 0

        Realm.getDefaultInstance().apply {
            beginTransaction()
            classes.forEach {
                where(it.value).findAll().deleteAllFromRealm()
                where(it.key).findAll().deleteAllFromRealm()
            }
            commitTransaction()
            close()
        }
    }
}