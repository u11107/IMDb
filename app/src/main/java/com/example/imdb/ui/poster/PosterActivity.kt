package com.example.imdb.ui.poster

import android.app.Activity
import android.os.Bundle
import com.example.imdb.util.Creator
import com.example.imdb.R

class PosterActivity : Activity() {

    private val posterController = Creator.providePosterController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster)
        posterController.onCreate()
    }
}