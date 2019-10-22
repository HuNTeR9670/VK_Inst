package com.toxa.vk_inst.providers

import com.toxa.vk_inst.models.PhotoModel
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPhotoPresenter
import com.toxa.vk_inst.request.VKPhotoReuquest
import com.toxa.vk_inst.request.VKUserRequerst
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.exceptions.VKApiExecutionException

class UserPhotoProviders (var presenter: UserPhotoPresenter){

    fun loadUserInfo (id : Int){
        VK.execute(VKUserRequerst(id), object: VKApiCallback<ArrayList<UserModel>> {
            override fun success(result: ArrayList<UserModel>) {
                presenter.setupUserInfo(result)
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }

    fun loadUserPhoto (id : Int){
        VK.execute(VKPhotoReuquest(id), object: VKApiCallback<ArrayList<PhotoModel>> {
            override fun success(result: ArrayList<PhotoModel>) {
                presenter.setupUserPhoto(result)
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }

}