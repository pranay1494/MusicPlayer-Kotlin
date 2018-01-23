package com.example.pranay.musicplayerhero_kotlin.loaders

import android.content.AsyncTaskLoader
import android.content.Context
import android.database.Cursor
import com.example.pranay.musicplayerhero_kotlin.constants.Constants

/**
 * Created by kuliza-336 on 23/01/18.
 */
class MusicLoader constructor(context:Context): AsyncTaskLoader<Cursor>(context){

    var query:Cursor? = null

    override fun onStartLoading() {
        super.onStartLoading()
        if(query == null) forceLoad() else deliverResult(query)
    }

    override fun loadInBackground(): Cursor {
        query = context.contentResolver.query(Constants.MUSIC_URI,null,Constants.MUSIC_SELECTION_ARGS,null,Constants.TITLE_URI)
        return query!!
    }

    override fun deliverResult(data: Cursor?) {
        query = data
        super.deliverResult(data)
    }
}