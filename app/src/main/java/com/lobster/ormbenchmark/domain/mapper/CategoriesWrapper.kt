package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.CategoriesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.greendao.CategoryGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.CategoryObjectBox
import com.lobster.ormbenchmark.domain.model.realm.CategoryRealm
import com.lobster.ormbenchmark.domain.response.CategoryResponse

/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = CategoriesWrapperDeserializer::class)
class CategoriesWrapper(val categories: List<CategoryResponse>) {

    fun mapGreenDao(): List<CategoryGreenDao> = categories.map { it.mapGreenDao() }

    fun mapObjectBox(): List<CategoryObjectBox> = categories.map { it.mapObjectBox() }

}
