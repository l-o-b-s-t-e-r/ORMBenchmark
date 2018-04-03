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

    const val GREEN_DAO_OLD = "green_dao_old"
    const val GREEN_DAO = "green_dao"
    const val OBJECT_BOX = "object_box"
    const val REALM = "realm"
}