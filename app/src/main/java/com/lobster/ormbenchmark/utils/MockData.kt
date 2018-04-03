package com.lobster.ormbenchmark.utils

import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.domain.model.OrmInfo
import javax.inject.Inject

/**
 * Created by Lobster on 01.04.18.
 */
class MockData @Inject constructor() {

    val ormMap = mapOf(
            Pair(Orm.GREEN_DAO_OLD, OrmInfo(Orm.GREEN_DAO_OLD, R.string.orm_green_dao_old)),
            Pair(Orm.GREEN_DAO, OrmInfo(Orm.GREEN_DAO, R.string.orm_green_dao)),
            Pair(Orm.OBJECT_BOX, OrmInfo(Orm.OBJECT_BOX, R.string.orm_object_box)),
            Pair(Orm.REALM, OrmInfo(Orm.REALM, R.string.orm_realm))
    )

    fun getOrmByType(@Orm.Type type: String) = ormMap[type]

    fun getOrmList() = ormMap.values.toMutableList()
}