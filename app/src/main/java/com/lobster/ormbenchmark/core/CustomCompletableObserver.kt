package com.lobster.ormbenchmark.core

import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Lobster on 02.04.18.
 */
open class CustomCompletableObserver : DisposableCompletableObserver() {

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}