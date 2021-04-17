package com.pradeep.payback.ui.imagedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.backbase.assignment.util.Status
import com.pradeep.payback.R
import com.pradeep.payback.data.model.ImageData
import com.pradeep.payback.utils.Constants.Companion.IMG_DATA_PUT_EXTRA_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : AppCompatActivity() {

    private lateinit var viewModel : ImageDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        viewModel = ViewModelProvider(this).get(ImageDetailViewModel::class.java)

        val imageData =  intent.getParcelableExtra<ImageData>(IMG_DATA_PUT_EXTRA_KEY)

        imageData?.let {
            viewModel.setSelectedImageData(it)
        }

    }

}