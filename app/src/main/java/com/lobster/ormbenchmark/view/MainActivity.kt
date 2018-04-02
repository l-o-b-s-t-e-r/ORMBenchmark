package com.lobster.ormbenchmark.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lobster.ormbenchmark.R
import com.lobster.ormbenchmark.utils.showShortToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showShortToast(this, R.string.toast_tap_on_orm)
    }

}
