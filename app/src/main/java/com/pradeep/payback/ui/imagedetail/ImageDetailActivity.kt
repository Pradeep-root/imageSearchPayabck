package com.pradeep.payback.ui.imagedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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

        setupActionBar()
        getPutExtraArgument()

    }

   private fun setupActionBar(){
       supportActionBar?.apply {
           setDisplayHomeAsUpEnabled(true)
           title = getString(R.string.image_details)
       }
    }

    private fun getPutExtraArgument(){
        val imageData =  intent.getParcelableExtra<ImageData>(IMG_DATA_PUT_EXTRA_KEY)
        imageData?.let {
            viewModel.setSelectedImageData(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}