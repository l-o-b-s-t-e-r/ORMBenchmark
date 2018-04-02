package com.lobster.ormbenchmark.domain.model.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Lobster on 01.04.18.
 */
open class AllergenRealm() : RealmObject() {

    @PrimaryKey
    lateinit var tag: String

    constructor(tag: String) : this() {
        this.tag = tag
    }

    lateinit var names: RealmList<AllergenNameRealm>
}