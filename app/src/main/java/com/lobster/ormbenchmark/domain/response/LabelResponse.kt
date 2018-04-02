package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.greendao.LabelGreenDao
import com.lobster.ormbenchmark.domain.model.greendao.LabelNameGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.LabelNameObjectBox
import com.lobster.ormbenchmark.domain.model.objectbox.LabelObjectBox
import com.lobster.ormbenchmark.domain.model.realm.CountryNameRealm
import com.lobster.ormbenchmark.domain.model.realm.CountryRealm
import com.lobster.ormbenchmark.domain.model.realm.LabelNameRealm
import com.lobster.ormbenchmark.domain.model.realm.LabelRealm

import java.util.ArrayList

/**
 * Created by Lobster on 03.03.18.
 */

class LabelResponse(var code: String, var names: Map<String, String>) {

    fun mapGreenDao(): LabelGreenDao {
        val label = LabelGreenDao(code, ArrayList<LabelNameGreenDao>())
        for ((key, value) in names) {
            label.names.add(LabelNameGreenDao(label.tag, key, value))
        }

        return label
    }

    fun mapObjectBox(): LabelObjectBox {
        val label = LabelObjectBox(code)
        for ((key, value) in names) {
            label.names.add(LabelNameObjectBox(key, value))
        }

        return label
    }
}
