package com.lobster.ormbenchmark.domain.usecase

import com.lobster.ormbenchmark.core.UseCaseCompletable
import com.lobster.ormbenchmark.core.UseCaseParameters
import com.lobster.ormbenchmark.data.ITaxonomiesRepository
import com.lobster.ormbenchmark.data.greendao.IGreenDaoRepository
import com.lobster.ormbenchmark.data.objectbox.IObjectBoxRepository
import com.lobster.ormbenchmark.data.realm.IRealmRepository
import com.lobster.ormbenchmark.utils.Orm
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Lobster on 01.04.18.
 */
class ClearGreenDaoUseCase @Inject constructor(
        private val greenDaoRepository: IGreenDaoRepository,
        private val objectBoxRepository: IObjectBoxRepository,
        private val realmRepository: IRealmRepository) : UseCaseCompletable<ClearGreenDaoUseCase.Parameters>() {

    override fun createObservable(params: Parameters): Completable {
        return when (params.type) {
            Orm.GREEN_DAO -> greenDaoRepository.clear()
            Orm.OBJECT_BOX -> objectBoxRepository.clear()
            else -> realmRepository.clear()
        }
    }

    class Parameters(@Orm.Type val type: String) : UseCaseParameters()
}