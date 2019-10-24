package com.toxa.vk_inst.views

import com.toxa.vk_inst.models.PhotoModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType (value = AddToEndSingleStrategy::class)
interface PhotoView: MvpView{
    fun setupUserInfo(User : String, URL : String?, isOnline : Int)
    fun setupPhotoList (photoModel: ArrayList<PhotoModel>)
    fun startLoad()
    fun endLoad()
    fun showEror(error: String)
}