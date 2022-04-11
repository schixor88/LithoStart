package com.example.lithostart

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class Litho : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}