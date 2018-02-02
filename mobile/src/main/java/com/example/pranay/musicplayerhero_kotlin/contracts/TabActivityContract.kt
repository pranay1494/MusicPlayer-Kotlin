package com.example.pranay.musicplayerhero_kotlin.contracts

import android.content.Intent
import com.example.pranay.musicplayerhero_kotlin.MusicViewModel

/**
 * Created by kuliza-336 on 01/02/18.
 */
interface TabActivityContract {
    interface TabView{

    }
    interface TabPresenter : BasePresenterContract{
        fun updateViewModel(intent: Intent, viewModel : MusicViewModel)
    }
}