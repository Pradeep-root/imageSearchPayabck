package com.pradeep.payback.ui.imagedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backbase.assignment.util.Resource
import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.repository.ImageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageDetailViewModel @Inject constructor( val repository: ImageRepository) : ViewModel(){

    private val _imageDetailsLiveData = MutableLiveData<Resource<ImageResponse>>() // not accessible in ui for safety

    val imageDetailsLiveData : LiveData<Resource<ImageResponse>> = _imageDetailsLiveData

    fun getImageDetails(imgId : Int){
        viewModelScope.launch {
            if(imgId != -1){
                _imageDetailsLiveData.postValue(Resource.loading())
                val result =  repository.getDetails(imgId)
                _imageDetailsLiveData.postValue(result)
            }else{
                _imageDetailsLiveData.postValue(Resource.error("Invalid image id", null))
            }
        }
    }
}