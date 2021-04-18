package com.pradeep.payback.ui.imagedetail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pradeep.payback.R
import com.pradeep.payback.data.model.ImageData
import com.pradeep.payback.databinding.ActivityImageDetailBinding
import com.pradeep.payback.utils.Constants.Companion.IMG_DATA_PUT_EXTRA_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailActivity : AppCompatActivity() {

    private lateinit var viewModel : ImageDetailViewModel
    private lateinit var binding: ActivityImageDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
         viewModel = ViewModelProvider(this).get(ImageDetailViewModel::class.java)

        binding.viewModel = viewModel

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
            Log.i("imageDATA", it.toString())
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