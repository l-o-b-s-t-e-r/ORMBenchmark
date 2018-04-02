package com.lobster.ormbenchmark

import android.app.Application
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.lobster.ormbenchmark.di.AppComponent
import com.lobster.ormbenchmark.di.AppModule
import com.lobster.ormbenchmark.di.DaggerAppComponent
import com.lobster.ormbenchmark.utils.showShortToast
import com.lobster.ormbenchmark.view.main.di.MainComponent
import com.lobster.ormbenchmark.view.main.di.MainModule
import io.realm.Realm
import io.reactivex.plugins.RxJavaPlugins
import java.net.UnknownHostException


/**
 * Created by Lobster on 29.03.18.
 */
class App : MultiDexApplication() {

    companion object {
        lateinit var appComponent: AppComponent
        var mainComponent: MainComponent? = null
            get() {
                if (field == null) {
                    field = appComponent
                            .plusMainComponent(MainModule())
                }

                return field
            }
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}