package com.toxa.vk_inst.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.toxa.vk_inst.R
import com.toxa.vk_inst.adapters.UserAdapter
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter
import com.toxa.vk_inst.views.UserView
import kotlinx.android.synthetic.main.activity_user.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class UserActivity : MvpAppCompatActivity(), UserView {

    @InjectPresenter
    lateinit var userPresenter: UserPresenter

    private lateinit var mAdapter: UserAdapter

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        userPresenter.loadUser()
        mAdapter = UserAdapter()
        User_List.adapter = mAdapter
        User_List.layoutManager = LinearLayoutManager(applicationContext, OrientationHelper.VERTICAL,false)
        User_List.setHasFixedSize(true)

        Seach_Edit.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(s.toString())
            }


        })
    }


    override fun setupEmptyList() {
        Seach_Edit.visibility = View.GONE
        User_List.visibility = View.GONE
        user_progress_bar.visibility = View.VISIBLE
    }

    override fun setupUserList(userList: ArrayList<UserModel>) {
        Seach_Edit.visibility = View.VISIBLE
        User_List.visibility = View.VISIBLE
        user_progress_bar.visibility = View.GONE
        mAdapter.setupUser(userList = userList)
    }

    override fun startLoading() {
        User_List.visibility = View.GONE
        Seach_Edit.visibility = View.GONE
        user_progress_bar.visibility = View.VISIBLE
    }

    override fun endLoading() {
        user_progress_bar.visibility = View.GONE
    }

    override fun showError(error: String) {
        Toast.makeText(this@UserActivity, error, Toast.LENGTH_LONG).show()
    }
}
