package com.toxa.vk_inst.request

import com.toxa.vk_inst.models.PhotoModel
import com.toxa.vk_inst.models.UserModel
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONException
import org.json.JSONObject

class VKPhotoReuquest(uid: Int = 0): VKRequest<ArrayList<PhotoModel>>("photos.getAll") {
    init {
         addParam("owner_id", uid)
    }

    override fun parse(r: JSONObject): ArrayList<PhotoModel> {
        val users = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<PhotoModel>()
        try {
            for (i in 0 until users.length()) {
                val item = users.getJSONObject(i)
                val photo = item.getJSONArray("sizes").getJSONObject(4)
                result.add(PhotoModel.parse(photo))
            }
        }catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}

