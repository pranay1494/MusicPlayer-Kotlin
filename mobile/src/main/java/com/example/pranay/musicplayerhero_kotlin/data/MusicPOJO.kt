package com.example.pranay.musicplayerhero_kotlin.data

import java.util.ArrayList

/**
 * Created by Pranay on 27-02-2017.
 */

/**
 * Driver model
 *
 */
class MusicPOJO {
    var songsList = ArrayList<SongsPojo>()
    var albums = ArrayList<AlbumPojo>()
    var nowPlayingList = ArrayList<SongsPojo>()
        set(nowPlayingList) {
            for (song in nowPlayingList) {
                this.nowPlayingList.add(song)
            }
        }
    var tempNowPlayingList = ArrayList<SongsPojo>()
        set(tempNowPlayingList) {
            this.tempNowPlayingList.clear()
            for (song in tempNowPlayingList) {
                this.tempNowPlayingList.add(song)
            }
        }
    var tempListForRepeat = ArrayList<SongsPojo>()
        set(tempListFooRepeat) {
            field = this.tempListForRepeat
        }
    var playlist = ArrayList<PlaylistPojo>()
    var indexOfCurrentSong: Int = 0
    var tempIndexOfCurrentSong: Int = 0
    var tempIndexForRepeat: Int = 0

    fun clearNowPlayingList() {
        this.nowPlayingList.clear()
    }

    fun addToTempList(song: SongsPojo) {
        this.tempListForRepeat.add(song)
    }

    fun setSong(song: SongsPojo) {
        songsList.add(song)
    }

    fun addAlbum(albumPojo: AlbumPojo) {
        albums.add(albumPojo)
    }

    fun addPlaylist(playlist: PlaylistPojo) {
        this.playlist.add(playlist)
    }
}
