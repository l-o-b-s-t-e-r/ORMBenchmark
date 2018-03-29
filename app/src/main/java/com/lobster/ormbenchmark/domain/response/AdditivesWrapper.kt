package com.lobster.ormbenchmark.domain.response

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.AdditivesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.Additive

import java.util.ArrayList


/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = AdditivesWrapperDeserializer::class)
class AdditivesWrapper(val additives: List<AdditiveResponse>) {

    fun map(): List<Additive> = additives.map { it.map() }

}
