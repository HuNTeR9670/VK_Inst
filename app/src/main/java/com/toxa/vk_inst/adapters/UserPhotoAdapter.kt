package com.toxa.vk_inst.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import com.toxa.vk_inst.helpers.FullScreenPhoto
import com.toxa.vk_inst.models.PhotoModel
import kotlinx.android.synthetic.main.activity_full_screen_photo.view.*
import kotlinx.android.synthetic.main.photo_items.view.*

class UserPhotoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mPhotoList: ArrayList<PhotoModel> = ArrayList()

    private var context: Context? = null

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
            holder.itemView.Photo_Users.setOnClickListener {
                context = it.context
                val intent = Intent(context, FullScreenPhoto::class.java)
                intent.putExtra("photo_url", mPhotoList[position].Photo_URL)
                it.context.startActivity(intent)
            }
        }
    }

    class PhotoHolder (itemView : View): RecyclerView.ViewHolder(itemView){

        private var mPhoto : ImageView = itemView.findViewById(R.id.Photo_Users)

        fun bind (photoModel: PhotoModel){
            if (photoModel.Photo_URL!!.isEmpty())
            {
                Picasso.get().load(R.drawable.no_photo).into(mPhoto)
            }
            else
            {
                Picasso.get().load(photoModel.Photo_URL)
                    .resize(800,600)
                    .centerCrop()
                    .into(mPhoto)
            }
        }
    }

}