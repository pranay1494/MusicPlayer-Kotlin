package com.example.pranay.musicplayerhero_kotlin.contracts

import android.database.Cursor
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO

/**
 * Created by kuliza-336 on 23/01/18.
 */
interface MusicLoadingContract {
    interface MusicLoadingView{
        fun getUpdatedMusicData(musicData: MusicPOJO);
    }
    interface MusicLoadingPresenter : BasePresenterContract {
        fun populateMusicList(data: Cursor?, musicData: MusicPOJO)
    }
}