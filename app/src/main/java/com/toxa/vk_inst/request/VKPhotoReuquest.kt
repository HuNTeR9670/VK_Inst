package com.toxa.vk_inst.request

import com.toxa.vk_inst.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONException
import org.json.JSONObject

class VKPhotoReuquest(uid: Int = 0): VKRequest<ArrayList<UserModel>>("photos.getAll") {
    init {
         addParam("owner_id", uid)
    }

    override fun parse(r: JSONObject): ArrayList<UserModel> {
        val users = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<UserModel>()
        try {
            for (i in 0 until users.length()) {
                val item = users.getJSONObject(i)
                val photo = item.getJSONArray("sizes").getJSONObject(1)
                result.add(UserModel.parse(photo))
            }
        }catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}

