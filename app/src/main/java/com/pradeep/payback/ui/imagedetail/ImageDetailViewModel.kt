package com.pradeep.payback.ui.imagedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pradeep.payback.data.model.ImageData


class ImageDetailViewModel  : ViewModel(){


    private val _imageLiveData = MutableLiveData<ImageData>() // not accessible from outside

     val imageLiveData : LiveData<ImageData> = _imageLiveData

    fun setSelectedImageData(imageData: ImageData){
        _imageLiveData.postValue(imageData)
    }

}