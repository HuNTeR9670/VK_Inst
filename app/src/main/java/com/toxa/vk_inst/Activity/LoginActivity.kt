package com.toxa.vk_inst.Activity


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.toxa.vk_inst.R
import com.toxa.vk_inst.presenters.LoginPresenter
import com.toxa.vk_inst.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.VKUtils.getCertificateFingerprint
import kotlinx.android.synthetic.main.activity_login.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter


class LoginActivity : MvpAppCompatActivity(), LoginView {

    val TAG = LoginActivity::class.simpleName

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


            Login_button.setOnClickListener {
                VK.login(this@LoginActivity, listOf(VKScope.FRIENDS))
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!loginPresenter.loginVk(requestCode = requestCode, resultCode = resultCode, data = data)){
        super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun startLoading() {
        Login_button.visibility = View.GONE
        Login_text.visibility = View.GONE
        Login_progress.visibility = View.VISIBLE
    }

    override fun endLoading() {
        Login_button.visibility = View.VISIBLE
        Login_text.visibility = View.VISIBLE
        Login_progress.visibility = View.GONE
    }

    override fun showEror(eror: String) {
        Toast.makeText(this@LoginActivity,eror, Toast.LENGTH_LONG).show()
    }

    override fun showUser() {
        startActivity(Intent(applicationContext, UserActivity::class.java))
    }

}
