package com.pradeep.payback.ui.searchimage

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.backbase.assignment.util.Status
import com.google.android.material.snackbar.Snackbar
import com.pradeep.payback.R
import com.pradeep.payback.utils.hide
import com.pradeep.payback.utils.hideKeyboard
import com.pradeep.payback.utils.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_image_search.*


@AndroidEntryPoint
class ImageSearchActivity : AppCompatActivity() {

    lateinit var viewModel : ImageSearchViewModel
    lateinit var imageAdapter: ImageAdapter
    val TAG = ImageSearchActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        viewModel = ViewModelProvider(this).get(ImageSearchViewModel::class.java)
        setupImageSearchObserver()

        initUi()
        searchBarAction()

    }


    private fun searchBarAction() {
        tv_search_bar.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                viewModel.searchImage(tv_search_bar.text.toString())
                v.hideKeyboard()
                true
            }else{
              false
            }
        }
    }

    private fun initUi() {
        imageAdapter = ImageAdapter(arrayListOf());
        with(rv_search_feeds) {
            layoutManager = GridLayoutManager(
                this@ImageSearchActivity,
                resources.getInteger(R.integer.rv_span_count)
            )
            val dividerItemDecorator = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            getDrawable(R.drawable.image_item_devider)?.let { dividerItemDecorator.setDrawable(it) }
            addItemDecoration(dividerItemDecorator)
            adapter = imageAdapter
            setHasFixedSize(true)
        }

        swipe_Layout.isEnabled = false
    }

    private fun setupImageSearchObserver() {
        viewModel.searchImageLiveData.observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        tv_error_msg.hide()
                        swipe_Layout.isRefreshing = false
                        it.data?.hits?.let { imageData ->
                            if(imageData.isNotEmpty()){
                                imageAdapter.updateList(imageData)
                            }else{
                                coordinator_main_layout.snakeBar(getString(R.string.empty_response)
                                    , Snackbar.LENGTH_LONG)
                            }
                        }
                    }

                    Status.ERROR -> {
                        swipe_Layout.isRefreshing = false
                        tv_error_msg.show()
                        tv_error_msg.text = resource.message.toString()
                        imageAdapter.updateList(mutableListOf())
                        coordinator_main_layout.snakeBar(resource.message.toString(), Snackbar.LENGTH_LONG)
                    }

                    Status.LOADING -> {
                        tv_error_msg.hide()
                        swipe_Layout.isRefreshing = true
                    }
                }
            }
        })
    }

    fun View.snakeBar(message: String, duration: Int = Snackbar.LENGTH_LONG){
        Snackbar.make(this, message, duration).show()
    }
}