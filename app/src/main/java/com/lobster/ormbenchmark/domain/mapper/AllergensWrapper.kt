package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.AllergensWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.greendao.AllergenGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.AllergenObjectBox
import com.lobster.ormbenchmark.domain.model.realm.AllergenRealm
import com.lobster.ormbenchmark.domain.response.AllergenResponse

@JsonDeserialize(using = AllergensWrapperDeserializer::class)
class AllergensWrapper(val allergens: List<AllergenResponse>) {

    fun mapGreenDao(): List<AllergenGreenDao> = allergens.map { it.mapGreenDao() }

    fun mapObjectBox(): List<AllergenObjectBox> = allergens.map { it.mapObjectBox() }

}
