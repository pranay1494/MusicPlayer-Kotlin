package com.example.pranay.musicplayerhero_kotlin.data

import java.util.ArrayList

/**
 * Created by Pranay on 17-02-2017.
 */

/**
 * Model for albums based songs.
 */
class AlbumPojo {
    var id: String? = null
    var artist: String? = null
    var numberOfSongs: Int = 0
    var albumName: String? = null
    var albumArtUri: String? = null
    var albumID: Long? = null
    private val albumSongsList = ArrayList<SongsPojo>()
}
