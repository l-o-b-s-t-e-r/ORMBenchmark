package com.lobster.ormbenchmark.domain.model.objectbox

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

/**
 * Created by Lobster on 01.04.18.
 */
@Entity
data class CategoryObjectBox(
        var tag: String,

        @Id
        var id: Long = 0
) {
    @Backlink(to = "category")
    lateinit var names: ToMany<CategoryNameObjectBox>
}