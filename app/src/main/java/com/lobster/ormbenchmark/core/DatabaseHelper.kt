package com.lobster.ormbenchmark.core

import android.content.Context
import com.lobster.ormbenchmark.domain.model.greendao.DaoMaster

/**
 * Created by Lobster on 30.03.18.
 */
class DatabaseHelper(context: Context, name: String) : DaoMaster.OpenHelper(context, name)