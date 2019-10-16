package com.toxa.vk_inst.presenters

import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.providers.UserProviders
import com.toxa.vk_inst.views.UserView
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class UserPresenter: MvpPresenter<UserView>(){

        fun  loadUser(){
            viewState.startLoading()
            UserProviders(presenter = this).testLoadUsers(hasUsers = true)
        }

        fun loadedUser(userList: ArrayList<UserModel>){
            viewState.endLoading()
            if (userList.size == 0){
                viewState.setupEmptyList()
                viewState.showError(error = "Ошибка загрузки пользователей!")
              }else{
                viewState.setupUserList(userList = userList)
            }

        }

}