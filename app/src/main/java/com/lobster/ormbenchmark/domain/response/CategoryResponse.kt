package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.Category
import com.lobster.ormbenchmark.domain.model.CategoryName

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class CategoryResponse(private val code: String, private val names: Map<String, String>) {

    fun map(): Category {
        val category = Category(code, ArrayList())
        for ((key, value) in names) {
            category.names.add(CategoryName(category.tag, key, value))
        }

        return category
    }

}
