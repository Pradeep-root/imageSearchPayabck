package com.pradeep.payback.ui.imagedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.backbase.assignment.util.Status
import com.pradeep.payback.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : AppCompatActivity() {

    private lateinit var viewModel : ImageDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        viewModel = ViewModelProvider(this).get(ImageDetailViewModel::class.java)

        setupImageDetailObserver()
    }

    private fun setupImageDetailObserver() {
        viewModel.imageDetailsLiveData.observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.LOADING ->{

                    }

                    Status.SUCCESS ->{

                    }

                    Status.ERROR ->{

                    }
                }

            }
        })
    }
}