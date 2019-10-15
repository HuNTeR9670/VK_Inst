package com.toxa.vk_inst.providers

import android.os.Handler
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.presenters.UserPresenter

class UserProviders (var presenter: UserPresenter){


    fun testLoadUsers (hasUsers : Boolean){
        Handler().postDelayed({
            val userList : ArrayList<UserModel> = ArrayList()
            if (hasUsers){
                val user1 = UserModel(name = "Anton", Surname = "Artem'ev", is_Online = true, photo_count = 10,
                    avatar = "https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjN58P9gp_lAhWKxMQBHRrIDD0QjRx6BAgBEAQ&url=https%3A%2F%2Fvalet.ru%2Fuser%2F4375918%2F&psig=AOvVaw0QKvl2eUozDQCEECqVdwBM&ust=1571254946821600")
                val user2 = UserModel (name = "Ivan", Surname = "Ivanov", is_Online = false, photo_count = 12, avatar = null)
                userList.add(user1)
                userList.add(user2)
            }
            presenter.
        })
    }
}