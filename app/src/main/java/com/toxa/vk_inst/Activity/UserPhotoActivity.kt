package com.toxa.vk_inst.Activity

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import com.toxa.vk_inst.adapters.UserPhotoAdapter
import com.toxa.vk_inst.models.PhotoModel
import com.toxa.vk_inst.presenters.UserPhotoPresenter
import com.toxa.vk_inst.views.PhotoView
import kotlinx.android.synthetic.main.activity_user_photo.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class UserPhotoActivity : MvpAppCompatActivity(), PhotoView  {

    @InjectPresenter
    lateinit var userPhotoPresenter: UserPhotoPresenter

    lateinit var mAdapter: UserPhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_photo)
        userPhotoPresenter.loadUserInfo(intent.getIntExtra("user_id",0))
        userPhotoPresenter.loadUserPhoto(intent.getIntExtra("user_id",0))
        mAdapter = UserPhotoAdapter()
        photo_list.adapter = mAdapter
        photo_list.layoutManager = GridLayoutManager(this,3)

        val actionBar = supportActionBar // добавляем кнопку "Назад"
        actionBar!!.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // обработка нажатия кнопки "Назад"
        this.finish() // завершаем текущее активити
        return true
    }


    override fun setupUserInfo(User: String, URL: String?, isOnline: Int) {
        photo_name.text = User
        if (isOnline == 1)
        {
            isOnline_textView.visibility = View.VISIBLE
        }else
        {
            isOnline_textView.visibility = View.GONE
        }

        if (URL!!.isEmpty())
        {
            Picasso.get().load(R.drawable.no_photo).into(photo_avatar)
        }
        else
        {
        Picasso.get().load(URL).into(photo_avatar)
        }
    }

    override fun setupPhotoList(photoModel: ArrayList<PhotoModel>) {
        Handler().postDelayed({UserPhoto_progress.visibility = View.GONE},2000)
        mAdapter.setupPhotoList(photoModel = photoModel)
    }

    override fun startLoad() {
        UserPhoto_progress.visibility = View.VISIBLE
    }

    override fun endLoad() {
        Handler().postDelayed({UserPhoto_progress.visibility = View.GONE},2000)
    }

    override fun showEror(error: String) {
        Toast.makeText(this@UserPhotoActivity, error, Toast.LENGTH_LONG).show()
    }
}
