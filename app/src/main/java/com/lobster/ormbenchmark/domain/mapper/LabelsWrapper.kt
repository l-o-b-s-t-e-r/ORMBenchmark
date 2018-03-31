package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.LabelsWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.Label
import com.lobster.ormbenchmark.domain.response.LabelResponse

/**
 * Created by Lobster on 03.03.18.
 */

@JsonDeserialize(using = LabelsWrapperDeserializer::class)
class LabelsWrapper(val labels: List<LabelResponse>) {

    fun map(): List<Label> = labels.map { it.map() }

}
