package com.toxa.vk_inst.models

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class PhotoModel(
        val Photo_URL : String? = ""): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Photo_URL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoModel> {
        override fun createFromParcel(parcel: Parcel): PhotoModel {
            return PhotoModel(parcel)
        }

        override fun newArray(size: Int): Array<PhotoModel?> {
            return arrayOfNulls(size)
        }

    fun parse(json: JSONObject)
            = PhotoModel (Photo_URL = json.optString("src",""))

}
}