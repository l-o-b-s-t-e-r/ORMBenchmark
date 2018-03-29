package com.lobster.ormbenchmark.domain.response

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.AllergensWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.Allergen

@JsonDeserialize(using = AllergensWrapperDeserializer::class)
class AllergensWrapper(val allergens: List<AllergenResponse>) {

    fun map(): List<Allergen> = allergens.map { it.map() }

}
