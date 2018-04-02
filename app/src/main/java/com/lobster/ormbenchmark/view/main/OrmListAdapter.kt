package com.lobster.ormbenchmark.view.main

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.domain.model.OrmInfo
import com.lobster.ormbenchmark.utils.*
import kotlinx.android.synthetic.main.item_orm.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Lobster on 31.03.18.
 */
class OrmListAdapter : RecyclerView.Adapter<OrmListAdapter.OrmHolder>() {

    private val DEFAULT_ITEM_POSITION = -1
    private val sdf = SimpleDateFormat("mm:ss")

    private var items: List<OrmInfo> = listOf()
    lateinit var onItemSelected: (type: String) -> Unit

    var selectedItemPosition = DEFAULT_ITEM_POSITION

    init {
        sdf.timeZone = TimeZone.getTimeZone("UTC")
    }

    override fun onBindViewHolder(holder: OrmHolder?, position: Int) {
        holder?.bind(items[position], position)
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): OrmHolder =
            OrmHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_orm, parent, false))

    fun enableAllItems() {
        reset()
        notifyDataSetChanged()
    }

    fun updateItems(newItems: List<OrmInfo>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun reset() {
        selectedItemPosition = DEFAULT_ITEM_POSITION
    }

    inner class OrmHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var ormInfo: OrmInfo
        private var holderPosition = 0

        fun bind(item: OrmInfo, position: Int) {
            ormInfo = item
            holderPosition = position
            itemView.titleView.setText(ormInfo.nameRes)
            updateInfo(ormInfo.savedNumber, ormInfo.currentTime)
        }

        fun updateInfo(savedNumber: Int, time: Long) {
            ormInfo.savedNumber = savedNumber
            ormInfo.currentTime = time

            itemView.apply {
                val percent = ormInfo.calculatePercent()

                progressView.text = "${ormInfo.savedNumber} / ${ormInfo.totalNumber}"
                arcProgress.setupProgress(percentView, percent)
                timerView.text = sdf.format(Date(ormInfo.currentTime * 1000))

                onClick {
                    if (selectedItemPosition != DEFAULT_ITEM_POSITION) {
                        showShortToast(getContext(), R.string.toast_operation_running)
                    } else {
                        arcProgress.resetSession(percentView)
                        selectedItemPosition = holderPosition
                        onItemSelected.invoke(ormInfo.type)
                    }
                }
            }
        }
    }
}