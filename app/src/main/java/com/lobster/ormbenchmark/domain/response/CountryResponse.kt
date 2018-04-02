package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.greendao.CountryGreenDao
import com.lobster.ormbenchmark.domain.model.greendao.CountryNameGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.CountryNameObjectBox
import com.lobster.ormbenchmark.domain.model.objectbox.CountryObjectBox
import com.lobster.ormbenchmark.domain.model.realm.CountryNameRealm
import com.lobster.ormbenchmark.domain.model.realm.CountryRealm

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class CountryResponse(val tag: String, val names: Map<String, String>) {

    fun mapGreenDao(): CountryGreenDao {
        val country = CountryGreenDao(tag, ArrayList())
        for ((key, value) in names) {
            country.names.add(CountryNameGreenDao(country.tag, key, value))
        }

        return country
    }

    fun mapObjectBox(): CountryObjectBox {
        val country = CountryObjectBox(tag)
        for ((key, value) in names) {
            country.names.add(CountryNameObjectBox(key, value))
        }

        return country
    }
}
