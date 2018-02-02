package com.example.pranay.musicplayerhero_kotlin.constants

import android.provider.MediaStore

/**
 * Created by kuliza-336 on 23/01/18.
 */
object Constants{
    //URI's
    val MUSIC_URI = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    val ALBUM_URI = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
    val MUSIC_SELECTION_ARGS = MediaStore.Audio.Media.IS_MUSIC + "!=0"
    val ALBUM_SELECTION_ARG = MUSIC_SELECTION_ARGS + " and album_id" + "=?"
    val TITLE_URI = MediaStore.Audio.Media.TITLE;

    //constants
    val MUSIC_OBJECT = "MUSIC_OBJECT";

}