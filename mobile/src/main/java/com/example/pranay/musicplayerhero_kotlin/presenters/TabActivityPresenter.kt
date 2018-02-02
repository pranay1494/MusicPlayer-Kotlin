package com.example.pranay.musicplayerhero_kotlin.presenters

import android.app.Activity
import android.content.Intent
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.MusicViewModel
import com.example.pranay.musicplayerhero_kotlin.constants.Constants
import com.example.pranay.musicplayerhero_kotlin.contracts.TabActivityContract
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO
import com.example.pranay.musicplayerhero_kotlin.ui.activity.TabActivity

/**
 * Created by kuliza-336 on 01/02/18.
 */
class TabActivityPresenter : TabActivityContract.TabPresenter {

    lateinit var tabActivity: TabActivity

    override fun onAttach(activity: Activity) {
        tabActivity = activity as TabActivity
    }

    override fun onDetach() {

    }

    override fun updateViewModel(intent: Intent, viewModel: MusicViewModel) {
        if (intent.hasExtra(Constants.MUSIC_OBJECT)){
            viewModel.musicData = intent.extras[Constants.MUSIC_OBJECT] as MusicPOJO?
        }
    }
}