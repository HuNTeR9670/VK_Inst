package com.toxa.vk_inst.request


import com.toxa.vk_inst.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject
import java.util.ArrayList

class VKUserRequerst(uids: Int = 0) : VKRequest<ArrayList<UserModel>>("users.get") {
    init {
        if (uids!= 0) {
            addParam("user_ids", uids)
        }
        addParam("fields", "online")
        addParam("fields", "photo_200")
    }

    override fun parse(r: JSONObject): ArrayList<UserModel> {
        val users = r.getJSONArray("response")
        val result = ArrayList<UserModel>()
        for (i in 0 until users.length()) {
            result.add(UserModel.parse(users.getJSONObject(i)))
        }
        return result
    }
}