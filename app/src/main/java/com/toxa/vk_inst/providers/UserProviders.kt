package com.toxa.vk_inst.providers

import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter
import com.toxa.vk_inst.request.VKFriendsRequest
import com.toxa.vk_inst.request.VKPhotoReuquest
import com.vk.api.sdk.*
import com.vk.api.sdk.exceptions.VKApiExecutionException

class UserProviders (var presenter: UserPresenter){

    fun loadUser (){
        VK.execute(VKPhotoReuquest(), object: VKApiCallback<ArrayList<UserModel>> {
            override fun success(result: ArrayList<UserModel>) {
                presenter.loadedUser(result)
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }


}