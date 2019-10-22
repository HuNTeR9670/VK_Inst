package com.toxa.vk_inst.views

import com.toxa.vk_inst.models.UserModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType (value = AddToEndSingleStrategy::class)
interface UserView:MvpView{
    fun setupEmptyList()
    fun setupUserList(userList: ArrayList<UserModel>)
    fun startLoading()
    fun endLoading()
    fun showError(error:String)
}