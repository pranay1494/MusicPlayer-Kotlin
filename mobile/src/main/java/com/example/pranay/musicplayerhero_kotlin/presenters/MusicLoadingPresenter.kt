package com.example.pranay.musicplayerhero_kotlin.presenters

import android.database.Cursor
import android.provider.MediaStore
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.contracts.MusicLoadingContract
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO
import com.example.pranay.musicplayerhero_kotlin.data.SongsPojo

/**
 * Created by kuliza-336 on 23/01/18.
 */
class MusicLoadingPresenter : MusicLoadingContract.MusicLoadingPresenter{

    lateinit var view:MusicBaseActivity

    override fun onAttach(activity: MusicBaseActivity) {
        view = activity
    }

    override fun onDetach() {
    }

    override fun populateMusicList(data: Cursor?, musicData: MusicPOJO) {
        if (data !=null && data.count>0){
            data.moveToFirst()
            while (data.moveToNext()){
                val song = SongsPojo()
                setSongs(song,data)
                if(song.id != null) {
                    musicData.setSong(song)
                }
            }
        }
        view.getUpdatedMusicData(musicData)
    }

    private fun setSongs(songs: SongsPojo, cursor: Cursor) {
        songs.title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
        songs.album = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)))
        songs.albumID = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)))
        songs.artist = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)))
        songs.displayName = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)))
        songs.duration = (cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
        songs.id = (cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID)))
        songs.path = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)))
        songs.dateAdded = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED)))
    }

}