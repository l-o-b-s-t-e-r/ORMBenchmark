package com.lobster.ormbenchmark.core

import com.lobster.ormbenchmark.view.base.mvp.IBasePresenter
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Lobster on 30.03.18.
 */
abstract class UseCaseCompletable<in P : UseCaseParameters> : DisposableHandler() {

    lateinit var observer: DisposableCompletableObserver

    abstract fun createObservable(params: P): Completable

    fun <T : IBasePresenter.View> execute(observer: DisposableCompletableObserver, view: T?, params: P) {
        this.observer = observer

        val observable = createObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        view?.let {
            observable.doOnSubscribe { view.showLoading() }
                    .doFinally { view.hideLoading() }
        }

        addDisposable(observable.subscribeWith(observer))
    }

    fun <T : IBasePresenter.View> execute(observer: DisposableCompletableObserver, view: T) {
        execute(observer, view, UseCaseParameters() as P)
    }

    fun execute(observer: DisposableCompletableObserver) {
        execute(observer, null, UseCaseParameters() as P)
    }

    fun execute(observer: DisposableCompletableObserver, params: P) {
        execute(observer, null, params)
    }
}