package com.toxa.vk_inst.Activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.toxa.vk_inst.R
import com.toxa.vk_inst.presenters.LoginPresenter
import com.toxa.vk_inst.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


            Login_button.setOnClickListener {
           // loginPresenter.login()
                startActivity(Intent(applicationContext, UserActivity::class.java))
       }
    }

    override fun startLoading() {
        Login_button.visibility = View.GONE
        Login_text.visibility = View.GONE
        Login_progress.visibility = View.VISIBLE
    }

    override fun endLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEror(eror: String) {
        Toast.makeText(this@LoginActivity,eror, Toast.LENGTH_LONG).show()
    }

    override fun showUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
