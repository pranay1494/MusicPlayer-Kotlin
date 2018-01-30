package com.example.pranay.musicplayerhero_kotlin.ui.activity

import android.os.Bundle
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.R

/**
 * Created by kuliza-336 on 29/01/18.
 */
class TabActivity : MusicBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_music_main,frameMain)
    }
}