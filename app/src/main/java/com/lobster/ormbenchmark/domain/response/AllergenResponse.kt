package com.lobster.ormbenchmark.domain.response

import com.lobster.ormbenchmark.domain.model.Allergen
import com.lobster.ormbenchmark.domain.model.AllergenName

import java.util.ArrayList

class AllergenResponse(var uniqueAllergenID: String, var names: Map<String, String>) {

    fun map(): Allergen {
        val allergen = Allergen(uniqueAllergenID, ArrayList())
        for ((key, value) in names) {
            allergen.names.add(AllergenName(allergen.tag, key, value))
        }

        return allergen
    }

}
