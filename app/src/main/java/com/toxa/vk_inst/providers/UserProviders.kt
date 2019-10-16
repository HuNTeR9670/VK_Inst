package com.toxa.vk_inst.providers

import android.os.Handler
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter
import com.vk.api.sdk.*
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class UserProviders (var presenter: UserPresenter){

    fun loadUser (){
        VK.execute(VKFriendsRequest(), object: VKApiCallback<ArrayList<UserModel>> {
            override fun success(result: ArrayList<UserModel>) {
                presenter.loadedUser(result)
            }
            override fun fail(error: VKApiExecutionException) {
            }
        })
    }

}