package com.lobster.ormbenchmark.core

import android.util.Log
import com.lobster.ormbenchmark.view.base.mvp.IBasePresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Lobster on 30.03.18.
 */
abstract class UseCaseSingle<R, in P : UseCaseParameters> : DisposableHandler() {

    lateinit var observer: DisposableSingleObserver<R>

    abstract fun createObservable(params: P): Single<R>

    fun <T : IBasePresenter.View> execute(observer: DisposableSingleObserver<R>, view: T?, params: P) {
        this.observer = observer

        val observable = if (view == null) {
            createObservable(params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        } else {
            createObservable(params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { view.showLoading() }
                    .doFinally { view.hideLoading() }
        }

        addDisposable(observable.subscribeWith(observer))
    }

    fun <T : IBasePresenter.View> execute(observer: DisposableSingleObserver<R>, view: T?) {
        execute(observer, view, UseCaseParameters() as P)
    }

    fun execute(observer: DisposableSingleObserver<R>, params: P) {
        execute(observer, null, params)
    }

    fun execute(observer: DisposableSingleObserver<R>) {
        execute(observer, UseCaseParameters() as P)
    }
}