package com.lobster.ormbenchmark.view.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.utils.showShortToast
import com.lobster.ormbenchmark.view.base.mvp.IBasePresenter

/**
 * Created by Lobster on 02.04.18.
 */
open class BaseFragment<VIEW : IBasePresenter.View, ACTIONS : IBasePresenter.Actions<VIEW>> : Fragment(), IBasePresenter.View {

    open lateinit var presenter: ACTIONS

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this as VIEW)
    }

    override fun onDestroyView() {
        presenter.unbindView()
        if (activity.isFinishing) {
            presenter.dispose()
        }
        super.onDestroyView()
    }

    override fun showToast(messageResId: Int) {
        showShortToast(context, messageResId)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}