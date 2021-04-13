package com.pradeep.payback.ui.searchimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pradeep.payback.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)
    }
}