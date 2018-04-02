package com.lobster.ormbenchmark.domain.model.realm

import io.realm.RealmObject

/**
 * Created by Lobster on 01.04.18.
 */
open class LabelNameRealm(var languageCode: String = "",
                     var name: String = "") : RealmObject() {
}