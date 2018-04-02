package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.greendao.AdditiveGreenDao
import com.lobster.ormbenchmark.domain.model.greendao.AdditiveNameGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.AdditiveNameObjectBox
import com.lobster.ormbenchmark.domain.model.objectbox.AdditiveObjectBox
import com.lobster.ormbenchmark.domain.model.realm.AdditiveNameRealm
import com.lobster.ormbenchmark.domain.model.realm.AdditiveRealm
import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class AdditiveResponse(val tag: String, val names: Map<String, String>) {

    fun mapGreenDao(): AdditiveGreenDao {
        val additive = AdditiveGreenDao(tag, ArrayList())
        for ((key, value) in names) {
            additive.names.add(AdditiveNameGreenDao(additive.tag, key, value))
        }

        return additive
    }

    fun mapObjectBox(): AdditiveObjectBox {
        val additive = AdditiveObjectBox(tag)
        for ((key, value) in names) {
            additive.names.add(AdditiveNameObjectBox(key, value))
        }

        return additive
    }
}
