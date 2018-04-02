package com.lobster.ormbenchmark.view.main


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import com.lobster.ormbenchmark.App

import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.domain.model.OrmInfo
import com.lobster.ormbenchmark.view.base.BaseFragment
import com.lobster.ormbenchmark.view.main.mvp.IMainPresenter
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_main.*
import android.support.v4.app.NotificationManagerCompat
import android.os.Build
import android.support.v4.app.NotificationCompat
import org.jetbrains.anko.notificationManager
import android.app.PendingIntent
import android.content.Intent
import com.lobster.ormbenchmark.view.MainActivity


class MainFragment : BaseFragment<IMainPresenter.View, IMainPresenter.Actions>(), IMainPresenter.View {

    companion object {
        val PROGRESS_BAR_VISIBILITY = "progress_bar_visibility"
    }

    @Inject
    override lateinit var presenter: IMainPresenter.Actions
    @Inject
    lateinit var adapter: OrmListAdapter
    @Inject
    lateinit var notificationChannel: String

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        App.mainComponent?.inject(this)
        adapter.onItemSelected = { type -> presenter.loadTaxonomies(type) }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dividerItemDecoration = DividerItemDecoration(context, VERTICAL)
        ormList.addItemDecoration(dividerItemDecoration)
        ormList.adapter = adapter

        savedInstanceState?.getInt(PROGRESS_BAR_VISIBILITY)?.let {
            progressBar.visibility = it
        }

        presenter.loadOrmInfo()
    }

    override fun showOrmInfo(ormList: List<OrmInfo>) {
        adapter.updateItems(ormList)
    }

    override fun showUpdatedOrmInfo(savedNumber: Int, time: Long) {
        ormList.findViewHolderForAdapterPosition(adapter.selectedItemPosition)?.let {
            (it as OrmListAdapter.OrmHolder).updateInfo(savedNumber, time)
        }
    }

    override fun showFinalResult() {
        adapter.enableAllItems()
        showNotification()
    }

    override fun showLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = INVISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(PROGRESS_BAR_VISIBILITY, progressBar.visibility)
        super.onSaveInstanceState(outState)
    }

    private fun showNotification() {
        val contentIntent = PendingIntent.getActivity(context, 0,
                Intent(context, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(context, notificationChannel)
                .setContentTitle(getString(R.string.notification_orm_finished_title))
                .setContentText(getString(R.string.notification_orm_finished_description))
                .setSmallIcon(R.drawable.ic_launcher_round)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .build()

        activity.notificationManager.notify(0, notification)
    }

    override fun resetAdapter() {
        adapter.reset()
    }
}
