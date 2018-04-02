package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.greendao.AllergenGreenDao
import com.lobster.ormbenchmark.domain.model.greendao.AllergenNameGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.AllergenNameObjectBox
import com.lobster.ormbenchmark.domain.model.objectbox.AllergenObjectBox
import com.lobster.ormbenchmark.domain.model.realm.AdditiveRealm
import com.lobster.ormbenchmark.domain.model.realm.AllergenNameRealm
import com.lobster.ormbenchmark.domain.model.realm.AllergenRealm

import java.util.ArrayList

class AllergenResponse(var uniqueAllergenID: String, var names: Map<String, String>) {

    fun mapGreenDao(): AllergenGreenDao {
        val allergen = AllergenGreenDao(uniqueAllergenID, ArrayList())
        for ((key, value) in names) {
            allergen.names.add(AllergenNameGreenDao(allergen.tag, key, value))
        }

        return allergen
    }

    fun mapObjectBox(): AllergenObjectBox {
        val allergen = AllergenObjectBox(uniqueAllergenID)
        for ((key, value) in names) {
            allergen.names.add(AllergenNameObjectBox(key, value))
        }

        return allergen
    }
}
