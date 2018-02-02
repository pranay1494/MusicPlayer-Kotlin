package com.example.pranay.musicplayerhero_kotlin.ui.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.pranay.musicplayerhero_kotlin.R
import com.example.pranay.musicplayerhero_kotlin.data.SongsPojo
import org.jetbrains.anko.find
import android.graphics.Bitmap
import android.support.annotation.Nullable
import android.support.v7.graphics.Palette
import android.widget.LinearLayout
import com.bumptech.glide.request.transition.Transition
import java.util.*


/**
 * Created by pranay on 01/02/18.
 */
class RecentlyAddedAdapter(context:Context, var songs: ArrayList<SongsPojo>) : RecyclerView.Adapter<RecentlyAddedAdapter.RecentlyAddedViewHolder>() {

    val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecentlyAddedViewHolder {
        return RecentlyAddedViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.row_recently_added,parent,false))
    }

    override fun getItemCount(): Int {
        if (songs.size<=3) return songs.size else return 3
    }

    override fun onBindViewHolder(holder: RecentlyAddedViewHolder?, position: Int) {
        holder!!.tvName.text = songs.get(position).title
        Glide.with(mContext).asBitmap().load(songs[position].albumArtturi).into(object: BitmapImageViewTarget(holder.imgAlbumart){
            override fun onResourceReady(bitmap: Bitmap?, transition: Transition<in Bitmap>?) {
                super.onResourceReady(bitmap, transition)
                val swatchesTemp = Palette.from(bitmap).generate().getVibrantSwatch()
                if (swatchesTemp != null) {
                    holder.llSongName.setBackgroundColor(swatchesTemp.getRgb())
                    holder.tvName.setTextColor(swatchesTemp.getTitleTextColor())
                }else {
                    val swatchesTempList = Palette.from(bitmap).generate().getSwatches()
                    val swatches = ArrayList<Palette.Swatch>(swatchesTempList)
                    Collections.sort(swatches, object : Comparator<Palette.Swatch> {
                        override fun compare(swatch1: Palette.Swatch, swatch2: Palette.Swatch): Int {
                            return if (swatch1.getPopulation() > swatch2.getPopulation()) swatch1.getPopulation() else swatch2.getPopulation()
                        }
                    })
                    holder.llSongName.setBackgroundColor(swatches.get(0).getRgb())
                    holder.tvName.setTextColor(swatches.get(0).getTitleTextColor())
                }
            }
        })
    }


    class RecentlyAddedViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val imgAlbumart = itemView!!.find<ImageView>(R.id.ivRecent)
        val tvName = itemView!!.find<TextView>(R.id.tvName)
        val llSongName = itemView!!.find<LinearLayout>(R.id.llSongName)
    }
}