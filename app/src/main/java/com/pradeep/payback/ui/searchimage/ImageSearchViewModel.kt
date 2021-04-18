package com.pradeep.payback.ui.searchimage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backbase.assignment.util.Resource
import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.repository.ImageRepository
import com.pradeep.payback.utils.Constants.Companion.DEFAULT_SEARCH_QUERY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageSearchViewModel @Inject constructor(var repository: ImageRepository) : ViewModel(){

    private val _searchImageLiveData = MutableLiveData<Resource<ImageResponse>>() // not accessible from outside
    val searchImageLiveData : LiveData<Resource<ImageResponse>> = _searchImageLiveData

    init {
        searchImage(DEFAULT_SEARCH_QUERY)
    }

    fun searchImage(searchText : String){
        _searchImageLiveData.postValue(Resource.loading())

        viewModelScope.launch {
          val result =  repository.searchImage(searchText)
            _searchImageLiveData.postValue(result)
        }
    }
}