package com.toxa.vk_inst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import com.toxa.vk_inst.models.PhotoModel

class UserPhotoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mPhotoList: ArrayList<PhotoModel> = ArrayList()

    fun setupPhotoList(photoModel: ArrayList<PhotoModel>){
        mPhotoList.clear()
        mPhotoList.addAll(photoModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.photo_items, parent, false)
        return PhotoHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mPhotoList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhotoHolder){
            holder.bind(photoModel = mPhotoList[position])
        }
    }

    class PhotoHolder (itemView : View): RecyclerView.ViewHolder(itemView){

        private var mPhoto : ImageView = itemView.findViewById(R.id.Photo_Users)

        fun bind (photoModel: PhotoModel){
            if (photoModel.Photo_URL == ""){}else{
                Picasso.get().load(photoModel.Photo_URL).into(mPhoto)
            }
        }
    }

}