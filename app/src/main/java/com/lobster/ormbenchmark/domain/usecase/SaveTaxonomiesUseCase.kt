package com.lobster.ormbenchmark.domain.usecase

import com.lobster.ormbenchmark.core.UseCaseCompletable
import com.lobster.ormbenchmark.core.UseCaseParameters
import com.lobster.ormbenchmark.data.greendao.IGreenDaoRepository
import com.lobster.ormbenchmark.data.objectbox.IObjectBoxRepository
import com.lobster.ormbenchmark.data.realm.IRealmRepository
import com.lobster.ormbenchmark.domain.mapper.TaxonomiesWrapper
import com.lobster.ormbenchmark.utils.Orm
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Lobster on 30.03.18.
 */
class SaveTaxonomiesUseCase @Inject constructor(
        private val greenDaoRepository: IGreenDaoRepository,
        private val objectBoxRepository: IObjectBoxRepository,
        private val realmRepository: IRealmRepository) : UseCaseCompletable<SaveTaxonomiesUseCase.Parameters>() {

    override fun createObservable(params: Parameters): Completable {
        return when (params.type) {
            Orm.GREEN_DAO -> Completable.merge(
                    params.taxonomiesWrapper.let {
                        listOf(Completable.fromAction { greenDaoRepository.saveLabels(it.labels.mapGreenDao()) },
                                Completable.fromAction { greenDaoRepository.saveAllergens(it.allergens.mapGreenDao()) },
                                Completable.fromAction { greenDaoRepository.saveCountries(it.countries.mapGreenDao()) },
                                Completable.fromAction { greenDaoRepository.saveAdditives(it.additives.mapGreenDao()) },
                                Completable.fromAction { greenDaoRepository.saveCategories(it.categories.mapGreenDao()) })
                    })
            Orm.OBJECT_BOX -> Completable.merge(
                    params.taxonomiesWrapper.let {
                        listOf(Completable.fromAction { objectBoxRepository.saveAdditives(it.additives.mapObjectBox()) },
                                Completable.fromAction { objectBoxRepository.saveAllergens(it.allergens.mapObjectBox()) },
                                Completable.fromAction { objectBoxRepository.saveCountries(it.countries.mapObjectBox()) },
                                Completable.fromAction { objectBoxRepository.saveLabels(it.labels.mapObjectBox()) },
                                Completable.fromAction { objectBoxRepository.saveCategories(it.categories.mapObjectBox()) })
                    })
            else -> Completable.merge(
                    params.taxonomiesWrapper.let {
                        listOf(Completable.fromAction { realmRepository.saveAdditives(it.additives.additives) },
                                Completable.fromAction { realmRepository.saveAllergens(it.allergens.allergens) },
                                Completable.fromAction { realmRepository.saveCountries(it.countries.countries) },
                                Completable.fromAction { realmRepository.saveLabels(it.labels.labels) },
                                Completable.fromAction { realmRepository.saveCategories(it.categories.categories) })
                    })
        }
    }

    class Parameters(@Orm.Type val type: String, val taxonomiesWrapper: TaxonomiesWrapper) : UseCaseParameters()
}