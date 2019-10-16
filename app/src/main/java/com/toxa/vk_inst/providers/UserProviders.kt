package com.toxa.vk_inst.providers

import android.os.Handler
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKApiIllegalCredentialsListener
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class UserProviders (var presenter: UserPresenter){

    fun loadUser (){
        //val request = VKApi
    }

}