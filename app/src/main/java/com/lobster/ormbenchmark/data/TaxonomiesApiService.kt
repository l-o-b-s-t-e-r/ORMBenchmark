package com.lobster.ormbenchmark.data

import com.lobster.ormbenchmark.domain.response.*
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Lobster on 29.03.18.
 */
interface TaxonomiesApiService {

    @GET("data/taxonomies/labels.json")
    fun getLabels(): Single<LabelsWrapper>

    @GET("data/taxonomies/allergens.json")
    fun getAllergens(): Single<AllergensWrapper>

    @GET("data/taxonomies/additives.json")
    fun getAdditives(): Single<AdditivesWrapper>

    @GET("data/taxonomies/countries.json")
    fun getCountries(): Single<CountriesWrapper>

    @GET("data/taxonomies/categories.json")
    fun getCategories(): Single<CategoriesWrapper>

}