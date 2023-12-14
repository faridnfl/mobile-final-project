package com.D121211012.myanimelist

import android.app.Application
import com.D121211012.myanimelist.data.AppContainer
import com.D121211012.myanimelist.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}