package com.lobster.ormbenchmark.view.base.mvp

/**
 * Created by Lobster on 02.04.18.
 */
interface IBasePresenter {

    interface View {
        fun showLoading()

        fun hideLoading()

        fun showToast(messageResId: Int)
    }

    open class Actions<T : IBasePresenter.View> {
        var view: T? = null

        fun bindView(view: T) {
            this.view = view
        }

        fun unbindView() {
            this.view = null
        }

        open fun dispose() {

        }
    }

}