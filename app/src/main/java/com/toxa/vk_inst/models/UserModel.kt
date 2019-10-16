package com.toxa.vk_inst.models

import org.json.JSONObject

class UserModel (var name : String, var Surname : String, var is_Online : Boolean, var avatar : String?){

fun parse(json: JSONObject)= UserModel (name = json.optString("first_name", ""),
    Surname =  json.optString("last_name", ""),
    avatar = json.optString("photo_100", ""),
    is_Online = json.optBoolean("deactivated", false))
}