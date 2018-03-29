package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.Country
import com.lobster.ormbenchmark.domain.model.CountryName

import java.util.ArrayList

/**
 * Created by Lobster on 04.03.18.
 */

class CountryResponse(private val tag: String, private val names: Map<String, String>) {

    fun map(): Country {
        val country = Country(tag, ArrayList())
        for ((key, value) in names) {
            country.names.add(CountryName(country.tag, key, value))
        }

        return country
    }

}
