package com.example.pranay.musicplayerhero_kotlin.presenters

import android.app.Activity
import android.database.Cursor
import android.provider.MediaStore
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.contracts.MusicLoadingContract
import com.example.pranay.musicplayerhero_kotlin.data.AlbumPojo
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO
import com.example.pranay.musicplayerhero_kotlin.data.SongsPojo

/**
 * Created by kuliza-336 on 23/01/18.
 */
class MusicLoadingPresenter : MusicLoadingContract.MusicLoadingPresenter{

    lateinit var view:MusicBaseActivity

    override fun onAttach(activity: Activity) {
        view = activity as MusicBaseActivity
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
        data?.close()
    }

    override fun populateAlbumList(data: Cursor?, musicData: MusicPOJO) {
        val albums = ArrayList<AlbumPojo>()
        if (data != null && data.count > 0){
            data.moveToFirst()
            while (data.moveToNext()){
                val albumPojo = AlbumPojo()
                setAlbum(data,albumPojo)
                albums.add(albumPojo)
            }
        }
        view.getUpdatedAlbumList(albums)
        data?.close()
    }

    private fun setAlbum(cursor: Cursor,albumPojo : AlbumPojo) {

        albumPojo.id = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums._ID)))
        albumPojo.albumName = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)))
        albumPojo.artist = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST)))
        albumPojo.albumArtUri = (cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART)))
        albumPojo.numberOfSongs = (Integer.parseInt(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS))))

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