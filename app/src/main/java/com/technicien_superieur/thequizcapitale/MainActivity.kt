package com.technicien_superieur.thequizcapitale

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickBtnPlay(view:View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }


}
