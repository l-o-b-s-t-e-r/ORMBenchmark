package com.lobster.ormbenchmark.utils

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import com.hookedonplay.decoviewlib.DecoView
import com.hookedonplay.decoviewlib.charts.SeriesItem
import com.hookedonplay.decoviewlib.events.DecoEvent
import com.lobster.ormbenchmark.view.base.mvp.IBasePresenter
import io.reactivex.ObservableTransformer

/**
 * Created by Lobster on 01.04.18.
 */
fun DecoView.setupProgress(percentView: TextView, percent: Float = 0.0f) {
    if (isEmpty) {
        addSeries(SeriesItem.Builder(Color.argb(255, 218, 218, 218))
                .setRange(0f, 100.0f, 100.0f)
                .setLineWidth(32f)
                .build())

        addSeries(SeriesItem.Builder(Color.argb(255, 255, 64, 129))
                .setRange(0f, 100.0f, percent)
                .setLineWidth(32f)
                .build())

        percentView.text = "${percent.toInt()}%"
    } else {
        val series = getChartSeries(1)
        if (percent - series.positionPercent * 100 >= 1.0f) {
            series.setPosition(percent)
            addEvent(DecoEvent.Builder(percent).setDuration(0L).setIndex(1).build())
            percentView.text = "${percent.toInt()}%"
        }
    }
}

fun DecoView.resetSession(percentView: TextView) {
    val series = getChartSeries(1)
    series.setPosition(0.0f)
    addEvent(DecoEvent.Builder(0.0f).setDuration(0L).setIndex(1).build())
    percentView.text = "0%"
}

fun showShortToast(context: Context, textResId: Int) {
    Toast.makeText(context, context.resources.getString(textResId), Toast.LENGTH_SHORT).show()
}