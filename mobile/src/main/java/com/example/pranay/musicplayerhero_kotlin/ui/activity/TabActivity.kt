package com.example.pranay.musicplayerhero_kotlin.ui.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.MusicViewModel
import com.example.pranay.musicplayerhero_kotlin.R
import com.example.pranay.musicplayerhero_kotlin.constants.Constants
import com.example.pranay.musicplayerhero_kotlin.presenters.TabActivityPresenter
import com.example.pranay.musicplayerhero_kotlin.ui.ViewPagerAdapter.ViewPagerAdapter
import com.example.pranay.musicplayerhero_kotlin.ui.framents.MusicListframent
import kotlinx.android.synthetic.main.activity_music_main.*

/**
 * Created by kuliza-336 on 29/01/18.
 */
class TabActivity : MusicBaseActivity() {

    lateinit var musicViewModel: MusicViewModel
    val presenter = TabActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_music_main, frameMain)

        musicViewModel = ViewModelProviders.of(this).get(MusicViewModel::class.java)
        presenter.onAttach(this)
        presenter.updateViewModel(intent,musicViewModel)
        setupTabs()
    }

    private fun setupTabs() {
        val vPager = ViewPagerAdapter(supportFragmentManager)
        vPager.addFragment(MusicListframent(), title = getString(R.string.All_Songs))
        vPager.addFragment(Fragment(), title = getString(R.string.Albums))
        vPager.addFragment(Fragment(), title = getString(R.string.Playlist))
        viewpager.offscreenPageLimit = 2
        viewpager.adapter = vPager
        tab_layout.setupWithViewPager(viewpager)
    }
}