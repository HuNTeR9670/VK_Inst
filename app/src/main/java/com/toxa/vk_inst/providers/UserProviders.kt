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
                    avatar = "https://lh3.googleusercontent.com/2U_cqO4TzssD9gcccMAlRU54b3GMOcw7BT1DdEEP3eqKo6eOMGwHkMBMpMR3NAArh2vH7SSiEHNhe5AdKBXx6SaEHLkDQ3CLGM2Qg7kwipj7b2DcowVbdAgTu4vAC_80ayaHLNbd")
                val user2 = UserModel (name = "Ivan", Surname = "Ivanov", is_Online = false, photo_count = 12, avatar = null)
                userList.add(user1)
                userList.add(user2)
            }
            presenter.loadedUser(userList)
        },2000)
    }
}