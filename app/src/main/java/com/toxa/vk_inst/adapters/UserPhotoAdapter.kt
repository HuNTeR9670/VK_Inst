package com.toxa.vk_inst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import com.toxa.vk_inst.models.UserModel

class UserPhotoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mPhotoList: ArrayList<UserModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.photo_items, parent, false)
        return UserAdapter.UserHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mPhotoList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoHolder){
            holder.bind(userModel = mPhotoList[position])
        }
    }

    class PhotoHolder (itemView : View): RecyclerView.ViewHolder(itemView){

        private var mPhoto : ImageView = itemView.findViewById(R.id.Photo_Users)

        fun bind (userModel: UserModel){
            if (userModel.photo == ""){}else{
                Picasso.get().load(userModel.photo).into(mPhoto)
            }
        }
    }

}