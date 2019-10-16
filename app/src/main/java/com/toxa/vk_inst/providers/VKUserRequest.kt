package com.toxa.vk_inst.providers

import com.toxa.vk_inst.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKFriendsRequest(uid: Int = 0): VKRequest<ArrayList<UserModel>>("friends.get") {
    init {
        if (uid != 0) {
            addParam("user_id", uid)
        }
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): ArrayList<UserModel> {
        val users = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<UserModel>()
        for (i in 0 until users.length()) {
            result.add(UserModel.parse(users.getJSONObject(i)))
        }
        return result
    }
}