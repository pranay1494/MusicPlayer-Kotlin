package com.example.pranay.musicplayerhero_kotlin.contracts

import android.view.View
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity

/**
 * Created by kuliza-336 on 23/01/18.
 */
interface BasePresenterContract{
    fun onAttach(activity: MusicBaseActivity)
    fun onDetach()
}