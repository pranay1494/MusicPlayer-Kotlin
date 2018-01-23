package com.example.pranay.musicplayerhero_kotlin

import android.Manifest
import android.app.LoaderManager
import android.content.Loader
import android.content.pm.PackageManager
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.example.pranay.musicplayerhero_kotlin.contracts.MusicLoadingContract
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO
import com.example.pranay.musicplayerhero_kotlin.loaders.MusicLoader
import com.example.pranay.musicplayerhero_kotlin.presenters.MusicLoadingPresenter
import org.jetbrains.anko.custom.onUiThread
import org.jetbrains.anko.doAsync

class MusicBaseActivity : AppCompatActivity() , LoaderManager.LoaderCallbacks<Cursor>,MusicLoadingContract.MusicLoadingView{

    val musicPresenter : MusicLoadingPresenter = MusicLoadingPresenter()
    var musicData = MusicPOJO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_base)
        handlePermission()
        musicPresenter.onAttach(this)
    }

    private fun retrieveSongs() {
        loaderManager.initLoader(Const.MUSIC_LIST, null, this)
    }

    override fun getUpdatedMusicData(musicData: MusicPOJO) {
        this.musicData = musicData
        runOnUiThread({
            Toast.makeText(this,"data received",Toast.LENGTH_SHORT).show();
        })
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        if (id == Const.MUSIC_LIST){
            return MusicLoader(this)
        }else{
            return MusicLoader(this)
        }
    }

    override fun onLoadFinished(loader: Loader<Cursor>?, data: Cursor?) {
        doAsync {
            if (loader?.id == Const.MUSIC_LIST)
                musicPresenter.populateMusicList(data,musicData)
        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>?) {
        //todo reset your pojo accordingly
    }

    private fun handlePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), Const.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), Const.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE)
            }
        } else {
            retrieveSongs()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            Const.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    retrieveSongs()
                } else {
                    //TODO what to do if the permission is denied.
                }
                return
            }
        }
    }


    object Const{
        val MUSIC_LIST = 1
        val ALBUM_LIST = 2
        val MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 3
    }
}
