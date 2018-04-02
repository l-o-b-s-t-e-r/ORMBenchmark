package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.greendao.CategoryGreenDao
import com.lobster.ormbenchmark.domain.model.greendao.CategoryNameGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.CategoryNameObjectBox
import com.lobster.ormbenchmark.domain.model.objectbox.CategoryObjectBox
import com.lobster.ormbenchmark.domain.model.realm.CategoryNameRealm
import com.lobster.ormbenchmark.domain.model.realm.CategoryRealm

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class CategoryResponse(val code: String, val names: Map<String, String>) {

    fun mapGreenDao(): CategoryGreenDao {
        val category = CategoryGreenDao(code, ArrayList())
        for ((key, value) in names) {
            category.names.add(CategoryNameGreenDao(category.tag, key, value))
        }

        return category
    }

    fun mapObjectBox(): CategoryObjectBox {
        val category = CategoryObjectBox(code)
        for ((key, value) in names) {
            category.names.add(CategoryNameObjectBox(key, value))
        }

        return category
    }
}
