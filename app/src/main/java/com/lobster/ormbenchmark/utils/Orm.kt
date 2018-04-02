package com.lobster.ormbenchmark.utils

import android.support.annotation.StringDef
import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.domain.model.OrmInfo

/**
 * Created by Lobster on 30.03.18.
 */

object Orm {
    @Retention(AnnotationRetention.SOURCE)
    @StringDef(GREEN_DAO, OBJECT_BOX, REALM)
    annotation class Type

    const val GREEN_DAO = "green_dao"
    const val OBJECT_BOX = "object_box"
    const val REALM = "realm"

    fun list() = listOf(
            OrmInfo(GREEN_DAO, R.string.orm_green_dao),
            OrmInfo(OBJECT_BOX, R.string.orm_object_box),
            OrmInfo(REALM, R.string.orm_realm)
    )
}