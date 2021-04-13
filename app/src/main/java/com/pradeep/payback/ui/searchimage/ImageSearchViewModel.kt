package com.pradeep.payback.ui.searchimage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backbase.assignment.util.Resource
import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageSearchViewModel @Inject constructor(var repository: ImageRepository) : ViewModel(){


    val searchImageLiveData = MutableLiveData<Resource<ImageResponse>>()

    fun searchImage(searchText : String){
        searchImageLiveData.postValue(Resource.loading())
        viewModelScope.launch {
          val result =  repository.searchImage(searchText)
            searchImageLiveData.postValue(result)
        }
    }
}