package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.CountriesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.Country
import com.lobster.ormbenchmark.domain.response.CountryResponse

/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = CountriesWrapperDeserializer::class)
class CountriesWrapper(var countries: List<CountryResponse>) {

    fun map(): List<Country> = countries.map { it.map() }

}
