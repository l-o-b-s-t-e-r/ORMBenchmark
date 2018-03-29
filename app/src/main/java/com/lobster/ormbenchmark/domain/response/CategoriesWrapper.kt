package com.lobster.ormbenchmark.domain.response

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.CategoriesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.Category

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = CategoriesWrapperDeserializer::class)
class CategoriesWrapper(val categories: List<CategoryResponse>) {

    fun map(): List<Category> = categories.map { it.map() }

}
