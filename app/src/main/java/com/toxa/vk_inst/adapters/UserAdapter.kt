package com.toxa.vk_inst.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import com.toxa.vk_inst.models.UserModel
import de.hdodenhof.circleimageview.CircleImageView
import java.util.Locale.filter

class UserAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mSourceList: ArrayList<UserModel> = ArrayList()
    private var mUserList: ArrayList<UserModel> = ArrayList()

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

            if (userModel.deactivated){
                mImgOnline.visibility = View.VISIBLE
            }else{
                mImgOnline.visibility = View.GONE
            }
        }
    }

}