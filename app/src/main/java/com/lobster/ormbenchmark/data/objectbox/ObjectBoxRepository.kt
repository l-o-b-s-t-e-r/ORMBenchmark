package com.lobster.ormbenchmark.data.objectbox

import android.util.Log
import com.lobster.ormbenchmark.domain.model.objectbox.*
import io.objectbox.BoxStore
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lobster on 01.04.18.
 */
class ObjectBoxRepository(private val box: BoxStore) : IObjectBoxRepository {

    private var savedTaxonomiesCount = 0
    private var classes = mapOf(
            Pair(AdditiveObjectBox::class.java, AdditiveNameObjectBox::class.java),
            Pair(LabelObjectBox::class.java, LabelNameObjectBox::class.java),
            Pair(CountryObjectBox::class.java, CountryNameObjectBox::class.java),
            Pair(AllergenObjectBox::class.java, AllergenNameObjectBox::class.java),
            Pair(CategoryObjectBox::class.java, CategoryNameObjectBox::class.java)
    )

    override fun saveAdditives(additives: List<AdditiveObjectBox>) {
        saveEntities(AdditiveObjectBox::class.java, AdditiveNameObjectBox::class.java, additives)
    }

    override fun saveLabels(labels: List<LabelObjectBox>) {
        saveEntities(LabelObjectBox::class.java, LabelNameObjectBox::class.java, labels)
    }

    override fun saveCountries(countries: List<CountryObjectBox>) {
        saveEntities(CountryObjectBox::class.java, CountryNameObjectBox::class.java, countries)
    }

    override fun saveAllergens(allergens: List<AllergenObjectBox>) {
        saveEntities(AllergenObjectBox::class.java, AllergenNameObjectBox::class.java, allergens)
    }

    override fun saveCategories(categories: List<CategoryObjectBox>) {
        saveEntities(CategoryObjectBox::class.java, CategoryNameObjectBox::class.java, categories)
    }

    private fun <P, C> saveEntities(parentEntityClass: Class<P>, childEntityClass: Class<C>, entities: List<P>) {
        box.boxFor(parentEntityClass).put(entities)

        savedTaxonomiesCount += box.boxFor(parentEntityClass).count().toInt()
        savedTaxonomiesCount += box.boxFor(childEntityClass).count().toInt()
    }

    override fun getSavedTaxonomiesCount(): Single<Int> {
        return Single.just(savedTaxonomiesCount)
    }

    override fun clear() = Completable.fromAction {
        savedTaxonomiesCount = 0

        classes.forEach {
            box.boxFor(it.value).removeAll()
            box.boxFor(it.key).removeAll()
        }
    }
}