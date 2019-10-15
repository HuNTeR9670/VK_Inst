package com.toxa.vk_inst.presenters

import android.os.Handler
import com.toxa.vk_inst.views.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>(){
        fun login(){
            viewState.startLoading()
            Handler().postDelayed({
                viewState.showEror(eror = "Ошибка при входе")
            },500)
        }
}