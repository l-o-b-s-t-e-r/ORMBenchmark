package com.lobster.ormbenchmark.domain.mapper

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.lobster.ormbenchmark.domain.deserializer.AdditivesWrapperDeserializer
import com.lobster.ormbenchmark.domain.model.greendao.AdditiveGreenDao
import com.lobster.ormbenchmark.domain.model.objectbox.AdditiveObjectBox
import com.lobster.ormbenchmark.domain.model.realm.AdditiveRealm
import com.lobster.ormbenchmark.domain.response.AdditiveResponse


/**
 * Created by Lobster on 04.03.18.
 */

@JsonDeserialize(using = AdditivesWrapperDeserializer::class)
class AdditivesWrapper(val additives: List<AdditiveResponse>) {

    fun mapGreenDao(): List<AdditiveGreenDao> = additives.map { it.mapGreenDao() }

    fun mapObjectBox(): List<AdditiveObjectBox> = additives.map { it.mapObjectBox() }

}
