package com.example.pranay.musicplayerhero_kotlin.ui.activity

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.R
import com.example.pranay.musicplayerhero_kotlin.constants.Constants
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

/**
 * Created by kuliza-336 on 24/01/18.
 */
class SplashActivity : MusicBaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupHandler(MyHandler())
    }

    inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            startActivity<TabActivity>(Constants.MUSIC_OBJECT to musicData)
        }
    }
}