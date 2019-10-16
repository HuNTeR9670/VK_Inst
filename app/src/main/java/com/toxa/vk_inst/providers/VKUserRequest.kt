package com.toxa.vk_inst.providers

import com.toxa.vk_inst.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKUsersRequest: VKRequest<ArrayList<UserModel>> {
    constructor(uids: IntArray = intArrayOf()): super("users.get") {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString(","))
        }
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