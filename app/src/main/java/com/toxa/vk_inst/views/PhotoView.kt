package com.toxa.vk_inst.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType (AddToEndSingleStrategy::class)
interface PhotoView: MvpView{
    fun setupPhotoList(User : String, URL : String?)
    fun startLoad()
    fun endLoad()
    fun showEror(error: String)
}