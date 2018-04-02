package com.lobster.ormbenchmark.domain.model

import com.lobster.ormbenchmark.utils.Orm

/**
 * Created by Lobster on 01.04.18.
 */

class OrmInfo(@Orm.Type val type: String, val nameRes: Int, var savedNumber: Int = 0, var totalNumber: Int = 0, var currentTime: Long = 0L) {
    fun calculatePercent() = if (totalNumber == 0) 0.0f else Math.floor(savedNumber * 100.0 / totalNumber).toFloat()
}