package com.lobster.ormbenchmark.domain.mapper

import com.lobster.ormbenchmark.domain.model.greendao.*

/**
 * Created by Lobster on 31.03.18.
 */
class TaxonomiesWrapper(
        val allergens: AllergensWrapper,
        val additives: AdditivesWrapper,
        val labels: LabelsWrapper,
        val countries: CountriesWrapper,
        val categories: CategoriesWrapper
) {
    fun getTotalFieldsCount(): Int {
        var count = 0

        count += allergens.allergens.size
        allergens.allergens.forEach {
            count += it.names.size
        }

        count += additives.additives.size
        additives.additives.forEach {
            count += it.names.size
        }

        count += categories.categories.size
        categories.categories.forEach {
            count += it.names.size
        }

        count += countries.countries.size
        countries.countries.forEach {
            count += it.names.size
        }

        count += labels.labels.size
        labels.labels.forEach {
            count += it.names.size
        }

        return count
    }
}