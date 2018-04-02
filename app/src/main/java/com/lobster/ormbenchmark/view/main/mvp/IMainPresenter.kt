package com.lobster.ormbenchmark.view.main.mvp

import com.lobster.ormbenchmark.domain.model.OrmInfo
import com.lobster.ormbenchmark.utils.Orm
import com.lobster.ormbenchmark.view.base.mvp.IBasePresenter

/**
 * Created by Lobster on 30.03.18.
 */
interface IMainPresenter {

    interface View : IBasePresenter.View {
        fun showUpdatedOrmInfo(savedNumber: Int, time: Long)

        fun showFinalResult()

        fun showOrmInfo(ormList: List<OrmInfo>)

        fun resetAdapter()
    }

    abstract class Actions : IBasePresenter.Actions<IMainPresenter.View>() {
        abstract fun loadOrmInfo()

        abstract fun loadTaxonomies(@Orm.Type type: String)
    }

}