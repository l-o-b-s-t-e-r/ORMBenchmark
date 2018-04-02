package com.lobster.ormbenchmark.domain.usecase

import com.lobster.ormbenchmark.core.UseCaseParameters
import com.lobster.ormbenchmark.core.UseCaseSingle
import com.lobster.ormbenchmark.data.greendao.IGreenDaoRepository
import com.lobster.ormbenchmark.data.objectbox.IObjectBoxRepository
import com.lobster.ormbenchmark.data.realm.IRealmRepository
import com.lobster.ormbenchmark.utils.Orm
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Lobster on 31.03.18.
 */
class GetSavedTaxonomiesCountUseCase @Inject constructor(
        private val greenDaoRepository: IGreenDaoRepository,
        private val objectBoxRepository: IObjectBoxRepository,
        private val realmRepository: IRealmRepository) : UseCaseSingle<Int, GetSavedTaxonomiesCountUseCase.Parameters>() {

    override fun createObservable(params: Parameters): Single<Int> {
        return when (params.type) {
            Orm.GREEN_DAO -> greenDaoRepository.getSavedTaxonomiesCount()
            Orm.OBJECT_BOX -> objectBoxRepository.getSavedTaxonomiesCount()
            else -> realmRepository.getSavedTaxonomiesCount()
        }
    }

    class Parameters(@Orm.Type val type: String) : UseCaseParameters()
}