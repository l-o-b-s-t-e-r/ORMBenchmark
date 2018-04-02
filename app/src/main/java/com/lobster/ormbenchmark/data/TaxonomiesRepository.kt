package com.lobster.ormbenchmark.data

import com.lobster.ormbenchmark.domain.mapper.*
import io.reactivex.Single


/**
 * Created by Lobster on 30.03.18.
 */
class TaxonomiesRepository(private val api: TaxonomiesApiService) : ITaxonomiesRepository {

    private var labels: LabelsWrapper? = null
    private var allergens: AllergensWrapper? = null
    private var additives: AdditivesWrapper? = null
    private var categories: CategoriesWrapper? = null
    private var countries: CountriesWrapper? = null

    override fun getLabels(): Single<LabelsWrapper> {
        return if (labels == null) {
            api.getLabels()
                    .map {
                        labels = it
                        labels
                    }
        } else {
            Single.just(labels)
        }
    }

    override fun getAllergens(): Single<AllergensWrapper> {
        return if (allergens == null) {
            api.getAllergens()
                    .map {
                        allergens = it
                        allergens
                    }
        } else {
            Single.just(allergens)
        }
    }

    override fun getCountries(): Single<CountriesWrapper> {
        return if (countries == null) {
            api.getCountries()
                    .map {
                        countries = it
                        countries
                    }
        } else {
            Single.just(countries)
        }
    }

    override fun getCategories(): Single<CategoriesWrapper> {
        return if (categories == null) {
            api.getCategories()
                    .map {
                        categories = it
                        categories
                    }
        } else {
            Single.just(categories)
        }
    }

    override fun getAdditives(): Single<AdditivesWrapper> {
        return if (additives == null) {
            api.getAdditives()
                    .map {
                        additives = it
                        additives
                    }
        } else {
            Single.just(additives)
        }
    }
}