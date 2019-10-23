package com.toxa.vk_inst.helpers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.toxa.vk_inst.R
import kotlinx.android.synthetic.main.activity_full_screen_photo.*

class FullScreenPhoto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_photo)
        loadImage()

        val actionBar = supportActionBar // добавляем кнопку "Назад"
        actionBar!!.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadImage(){
        Picasso.get().load(intent.getStringExtra("photo_url")).into(fullScreenImageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // обработка нажатия кнопки "Назад"
        this.finish() // завершаем текущее активити
        return true
    }
}
