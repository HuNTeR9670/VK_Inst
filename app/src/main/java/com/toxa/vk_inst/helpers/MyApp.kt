package com.toxa.vk_inst.helpers

import android.app.Application
import com.toxa.vk_inst.Activity.LoginActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler

class MyApp :Application(){

    override fun onCreate() {
        super.onCreate()
        VK.initialize(applicationContext)
        VK.addTokenExpiredHandler(tokenTracker)
    }
    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            // token expired
        }
    }
}