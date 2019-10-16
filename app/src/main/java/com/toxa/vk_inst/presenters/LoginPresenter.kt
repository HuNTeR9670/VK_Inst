package com.toxa.vk_inst.presenters

import android.content.Intent
import android.os.Handler
import com.toxa.vk_inst.Activity.UserActivity
import com.toxa.vk_inst.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>(){

    fun loginVk (requestCode: Int, resultCode: Int, data: Intent?): Boolean{
        if (!VK.onActivityResult(requestCode,resultCode,data, object : VKAuthCallback{
                override fun onLogin(token: VKAccessToken) {
                    viewState.showUser()
                }
                override fun onLoginFailed(errorCode: Int) {
                    viewState.showEror(eror = "Ошибка входа!")
                }
            })) {
            return true
        }
        return false
    }
}