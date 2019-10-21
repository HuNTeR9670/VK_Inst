package com.toxa.vk_inst.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.Activity.UserPhotoActivity
import com.toxa.vk_inst.R
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPhotoPresenter
import com.toxa.vk_inst.presenters.UserPresenter
import com.toxa.vk_inst.providers.UserProviders
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_items.view.*
import java.util.Locale.filter

class UserAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mSourceList: ArrayList<UserModel> = ArrayList()
    private var mUserList: ArrayList<UserModel> = ArrayList()

    private var context: Context? = null

    fun setupUser(userList : ArrayList<UserModel>){
        mSourceList.clear()
        mSourceList.addAll(userList)
        filter(query = "")
    }

    fun filter(query: String) {
        mUserList.clear()
        mSourceList.forEach {
            if (it.firstName.contains(query, ignoreCase = true) || it.lastName.contains(query, ignoreCase = true)){
                mUserList.add(it)
            }
            }
        notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.user_items, parent, false)
        return UserHolder (itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mUserList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserHolder) {
            holder.bind(userModel = mUserList[position])
        }
        holder.itemView.user_txt_username.setOnClickListener {
            context = it.context
            val intent = Intent(context, UserPhotoActivity::class.java)
            intent.putExtra("user_id", mUserList[position].id)
            it.context.startActivity(intent)
        }
    }


    class UserHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        private var mCivAvatar: CircleImageView = itemView.findViewById(R.id.user_civ_avatar)
        private var mTxtUsername: TextView = itemView.findViewById(R.id.user_txt_username)
        private var mTxtCounter: TextView = itemView.findViewById(R.id.user_photo_count)
        private var mImgOnline: View = itemView.findViewById(R.id.user_img_online)


        @SuppressLint("SetTextI18n")
        fun bind (userModel: UserModel){
            if (userModel.photo == ""){
            }else{
                Picasso.get().load(userModel.photo).into(mCivAvatar)
            }
            mTxtUsername.text ="${userModel.firstName} ${userModel.lastName}"
            //mTxtCounter.text = userModel.photo_count.toString()

            if (userModel.is_Online==1){
                mImgOnline.visibility = View.VISIBLE
            }else{
                mImgOnline.visibility = View.GONE
            }
        }
    }

}