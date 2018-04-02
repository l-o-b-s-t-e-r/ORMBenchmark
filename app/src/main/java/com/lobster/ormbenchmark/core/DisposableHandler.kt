package com.lobster.ormbenchmark.core

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Lobster on 31.03.18.
 */
open class DisposableHandler {

    private var disposables = CompositeDisposable()

    fun dispose() {
        getCompositeDisposable().dispose()
    }

    private fun getCompositeDisposable(): CompositeDisposable {
        if (disposables.isDisposed) {
            disposables = CompositeDisposable()
        }

        return disposables
    }

    protected fun addDisposable(disposable: Disposable) {
        getCompositeDisposable().add(disposable)
    }
}