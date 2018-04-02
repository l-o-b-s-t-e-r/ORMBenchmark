package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.LabelsWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.greendao.LabelGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.LabelObjectBox
import com.lobster.ormbenchmark.domain.model.realm.LabelRealm
import com.lobster.ormbenchmark.domain.response.LabelResponse

/**
 * Created by Lobster on 03.03.18.
 */

@JsonDeserialize(using = LabelsWrapperDeserializer::class)
class LabelsWrapper(val labels: List<LabelResponse>) {

    fun mapGreenDao(): List<LabelGreenDao> = labels.map { it.mapGreenDao() }

    fun mapObjectBox(): List<LabelObjectBox> = labels.map { it.mapObjectBox() }

}
