package com.lobster.ormbenchmark.core

import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Lobster on 02.04.18.
 */
open class CustomSingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

}