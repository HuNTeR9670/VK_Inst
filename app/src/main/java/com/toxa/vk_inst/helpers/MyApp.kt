package com.toxa.vk_inst.helpers

import android.app.Application
import com.vk.api.sdk.VK

class MyApp :Application(){

    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
    }
}