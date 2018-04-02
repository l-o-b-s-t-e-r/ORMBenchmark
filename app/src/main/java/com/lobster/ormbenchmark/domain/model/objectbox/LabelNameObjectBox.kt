package com.lobster.ormbenchmark.domain.model.objectbox

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

/**
 * Created by Lobster on 01.04.18.
 */
@Entity
data class LabelNameObjectBox(
        var languageCode: String = "",

        var name: String = "",

        @Id
        var id: Long = 0
) {
    lateinit var label: ToOne<LabelObjectBox>
}