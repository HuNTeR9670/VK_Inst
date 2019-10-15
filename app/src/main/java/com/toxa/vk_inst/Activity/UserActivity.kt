package com.toxa.vk_inst.Activity

import android.os.Bundle
import com.toxa.vk_inst.R
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter
import com.toxa.vk_inst.views.UserView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class UserActivity : MvpAppCompatActivity(), UserView {

    @InjectPresenter
    lateinit var userView: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

    }


    override fun setupEmptyList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setupUserList(userList: ArrayList<UserModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun endLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
