package com.pradeep.payback.ui.searchimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.backbase.assignment.util.Status
import com.pradeep.payback.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_image_search.*

@AndroidEntryPoint
class ImageSearchActivity : AppCompatActivity() {

    lateinit var viewModel : ImageSearchViewModel
    lateinit var imageSearchAdapter: ImageSearchAdapter
    val TAG = ImageSearchActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        viewModel = ViewModelProvider(this).get(ImageSearchViewModel::class.java)
        setupImageSearchObserver()
        viewModel.searchImage("fruits")

        initUi()
    }

    private fun initUi() {
        imageSearchAdapter = ImageSearchAdapter(arrayListOf());
        with(rv_search_feeds) {
            layoutManager = GridLayoutManager(this@ImageSearchActivity, resources.getInteger(R.integer.rv_span_count))
            adapter = imageSearchAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupImageSearchObserver() {
        viewModel.searchImageLiveData.observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        Log.i(TAG, resource.data.toString())
                        it.data?.hits?.let { imageData -> imageSearchAdapter.updateList(imageData) }
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