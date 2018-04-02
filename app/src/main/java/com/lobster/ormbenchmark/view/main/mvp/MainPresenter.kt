package com.lobster.ormbenchmark.view.main.mvp

import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.core.CustomCompletableObserver
import com.lobster.ormbenchmark.core.CustomSingleObserver
import com.lobster.ormbenchmark.domain.mapper.TaxonomiesWrapper
import com.lobster.ormbenchmark.domain.usecase.ClearGreenDaoUseCase
import com.lobster.ormbenchmark.domain.usecase.GetSavedTaxonomiesCountUseCase
import com.lobster.ormbenchmark.domain.usecase.LoadTaxonomiesUseCase
import com.lobster.ormbenchmark.domain.usecase.SaveTaxonomiesUseCase
import com.lobster.ormbenchmark.utils.MockData
import com.lobster.ormbenchmark.utils.Orm
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

/**
 * Created by Lobster on 30.03.18.
 */
class MainPresenter(private val loadTaxonomiesUseCase: LoadTaxonomiesUseCase,
                    private val saveTaxonomiesUseCase: SaveTaxonomiesUseCase,
                    private val getSavedTaxonomiesCountUseCase: GetSavedTaxonomiesCountUseCase,
                    private val clearGreenDaoUseCase: ClearGreenDaoUseCase,
                    private val data: MockData) : IMainPresenter.Actions() {

    var timerDisposable: Disposable? = null

    override fun loadOrmInfo() {
        view?.showOrmInfo(data.getOrmList())
    }

    override fun loadTaxonomies(@Orm.Type type: String) {
        loadTaxonomiesUseCase.execute<IMainPresenter.View>(object : CustomSingleObserver<TaxonomiesWrapper>() {
            override fun onSuccess(taxonomies: TaxonomiesWrapper) {
                data.getOrmByType(type)?.totalNumber = taxonomies.getTotalFieldsCount()
                startTimer(type)
                saveTaxonomies(type, taxonomies)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                if (e is UnknownHostException) {
                    view?.showToast(R.string.toast_network_error)
                } else {
                    view?.showToast(R.string.toast_common_error)
                }

                view?.resetAdapter()
            }
        }, view)
    }

    private fun saveTaxonomies(@Orm.Type type: String, taxonomiesWrapper: TaxonomiesWrapper) {
        saveTaxonomiesUseCase.execute(object : CustomCompletableObserver() {
            override fun onComplete() {
                data.getOrmByType(type)?.apply {
                    savedNumber = totalNumber
                }

                timerDisposable?.dispose()
                view?.showFinalResult()
                clearGreenDao(type)
            }
        }, SaveTaxonomiesUseCase.Parameters(type, taxonomiesWrapper))
    }

    private fun updateInfo(@Orm.Type type: String, time: Long) {
        getSavedTaxonomiesCountUseCase.execute(object : CustomSingleObserver<Int>() {
            override fun onSuccess(savedNumber: Int) {
                data.getOrmByType(type)?.currentTime = time
                data.getOrmByType(type)?.savedNumber = savedNumber

                view?.showUpdatedOrmInfo(savedNumber, time)
            }
        }, GetSavedTaxonomiesCountUseCase.Parameters(type))
    }

    private fun clearGreenDao(@Orm.Type type: String) {
        clearGreenDaoUseCase.execute(object : CustomCompletableObserver() {
            override fun onComplete() {

            }
        }, ClearGreenDaoUseCase.Parameters(type))
    }

    private fun startTimer(@Orm.Type type: String) {
        timerDisposable = Observable.interval(1, TimeUnit.SECONDS)
                .doOnNext { time ->
                    updateInfo(type, time + 1)
                }
                .repeat()
                .subscribe()
    }

    override fun dispose() {
        loadTaxonomiesUseCase.dispose()
        saveTaxonomiesUseCase.dispose()
        getSavedTaxonomiesCountUseCase.dispose()
        clearGreenDaoUseCase.dispose()
    }
}