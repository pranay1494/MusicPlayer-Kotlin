package com.example.pranay.musicplayerhero_kotlin.ui.framents

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pranay.musicplayerhero_kotlin.MusicBaseActivity
import com.example.pranay.musicplayerhero_kotlin.MusicViewModel
import com.example.pranay.musicplayerhero_kotlin.R
import com.example.pranay.musicplayerhero_kotlin.ui.adapters.RecentlyAddedAdapter
import com.example.pranay.musicplayerhero_kotlin.ui.adapters.SongListAdapter
import kotlinx.android.synthetic.main.fragment_music_list.*

/**
 * Created by kuliza-336 on 30/01/18.
 */
class MusicListframent : Fragment() {

    lateinit var musicViewModel: MusicViewModel
    lateinit var mContext: Context
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        musicViewModel = ViewModelProviders.of(activity!!).get(MusicViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_music_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val adapter = RecentlyAddedAdapter(mContext,musicViewModel.musicData!!.songsList)
        rvRecentlyAdded.setLayoutManager(GridLayoutManager(activity,3))
        rvRecentlyAdded.adapter = adapter

        val songsAdapter = SongListAdapter(mContext,musicViewModel.musicData!!)
        rvMusicList.setLayoutManager(LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false))
        rvMusicList.adapter = songsAdapter
        rvMusicList.isNestedScrollingEnabled = false
    }
}