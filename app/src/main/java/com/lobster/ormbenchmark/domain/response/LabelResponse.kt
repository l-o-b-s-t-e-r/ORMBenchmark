package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.Label
import com.lobster.ormbenchmark.domain.model.LabelName

import java.util.ArrayList

/**
 * Created by Lobster on 03.03.18.
 */

class LabelResponse(var code: String, var names: Map<String, String>) {

    fun map(): Label {
        val label = Label(code, ArrayList<LabelName>())
        for ((key, value) in names) {
            label.names.add(LabelName(label.tag, key, value))
        }

        return label
    }
}
