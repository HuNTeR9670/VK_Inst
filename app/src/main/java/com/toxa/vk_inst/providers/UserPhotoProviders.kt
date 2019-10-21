package com.toxa.vk_inst.providers

import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPhotoPresenter
import com.toxa.vk_inst.request.VKUserRequerst
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class UserPhotoProviders (var presenter: UserPhotoPresenter){

    fun loadPhotoUser (id : Int){
        VK.execute(VKUserRequerst(id), object: VKApiCallback<ArrayList<UserModel>> {
            override fun success(result: ArrayList<UserModel>) {
                presenter.setupUserInfo(result)
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }
}