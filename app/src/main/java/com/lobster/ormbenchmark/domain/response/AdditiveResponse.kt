package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.Additive
import com.lobster.ormbenchmark.domain.model.AdditiveName

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class AdditiveResponse(private val tag: String, private val names: Map<String, String>) {

    fun map(): Additive {
        val additive = Additive(tag, ArrayList())
        for ((key, value) in names) {
            additive.names.add(AdditiveName(additive.tag, key, value))
        }

        return additive
    }

}
