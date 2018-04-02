package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.CountriesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.greendao.CountryGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.CountryObjectBox
import com.lobster.ormbenchmark.domain.model.realm.CountryRealm
import com.lobster.ormbenchmark.domain.response.CountryResponse

/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = CountriesWrapperDeserializer::class)
class CountriesWrapper(var countries: List<CountryResponse>) {

    fun mapGreenDao(): List<CountryGreenDao> = countries.map { it.mapGreenDao() }

    fun mapObjectBox(): List<CountryObjectBox> = countries.map { it.mapObjectBox() }

}
