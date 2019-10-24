package com.toxa.vk_inst.presenters

import com.toxa.vk_inst.models.PhotoModel
import com.toxa.vk_inst.models.UserModel
import com.toxa.vk_inst.providers.UserPhotoProviders
import com.toxa.vk_inst.views.PhotoView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class UserPhotoPresenter : MvpPresenter<PhotoView>() {

        fun loadUserInfo (id : Int){
            viewState.startLoad()
            UserPhotoProviders(presenter = this).loadUserInfo(id)
        }

        fun  setupUserInfo (userModel: ArrayList<UserModel>){
            if (userModel.size == 0){
                viewState.showEror("PPc0")
            }else{
                viewState.setupUserInfo("${userModel[0].firstName} ${userModel[0].lastName}",userModel[0].photo,
                    userModel[0].is_Online)
            }
            viewState.endLoad()
        }

    fun loadUserPhoto (id: Int){
        viewState.startLoad()
        UserPhotoProviders (presenter = this).loadUserPhoto(id)
    }

    fun  setupUserPhoto (photoModel: ArrayList<PhotoModel>){
        viewState.endLoad()
        if (photoModel.size == 0){
            viewState.showEror("Пользователь не имеет фотографий либо загрузил их очень давно :(")
        }else{
            viewState.setupPhotoList(photoModel)
        }
    }


}