package com.example.pranay.musicplayerhero_kotlin.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pranay.musicplayerhero_kotlin.R
import com.example.pranay.musicplayerhero_kotlin.data.MusicPOJO
import com.example.pranay.musicplayerhero_kotlin.data.SongsPojo
import org.jetbrains.anko.find

/**
 * Created by pranay on 02/02/18.
 */
class SongListAdapter(mContext : Context, songs:MusicPOJO) : RecyclerView.Adapter<SongListAdapter.SongsListViewHolder>() {

    val songs = songs
    val context = mContext

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SongsListViewHolder {
        return SongsListViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.row_music_list,parent,false))
    }

    override fun getItemCount(): Int {
        return songs.songsList.size
    }

    override fun onBindViewHolder(holder: SongsListViewHolder?, position: Int) {
        val list = songs.songsList

        val req  = RequestOptions()
        req.error(R.drawable.guitar)
        req.placeholder(R.drawable.guitar)
        req.centerCrop()

        Glide.with(context).setDefaultRequestOptions(req).load(list[position].albumArtturi).into(holder!!.ivMusic)
        holder.tvSongName.text = list[position].title
        holder.tvDuration.text = list[position].duration.toString()
        holder.tvAlbumName.text = list[position].album
    }

    class SongsListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val ivMusic = itemView!!.find<ImageView>(R.id.ivMusic)
        val tvSongName = itemView!!.find<TextView>(R.id.tvSongName)
        val tvDuration = itemView!!.find<TextView>(R.id.tvDuration)
        val tvAlbumName = itemView!!.find<TextView>(R.id.tvAlbumName)
    }
}