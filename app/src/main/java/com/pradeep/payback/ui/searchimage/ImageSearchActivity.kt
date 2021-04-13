package com.pradeep.payback.ui.searchimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.backbase.assignment.util.Status
import com.pradeep.payback.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSearchActivity : AppCompatActivity() {

    lateinit var viewModel : ImageSearchViewModel

    val TAG = ImageSearchActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        viewModel = ViewModelProvider(this).get(ImageSearchViewModel::class.java)
        setupImageSearchObserver()
        viewModel.searchImage("fruits")
    }

    private fun setupImageSearchObserver() {
        viewModel.searchImageLiveData.observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        Log.i(TAG, resource.data.toString())
                    }

                    Status.ERROR ->{
                        Log.i(TAG, resource.message.toString())
                    }

                    Status.LOADING ->{
                        Log.i(TAG, resource.status.toString())
                    }
                }
            }
        })
    }
}