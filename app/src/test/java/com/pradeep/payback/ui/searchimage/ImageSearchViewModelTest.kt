package com.pradeep.payback.ui.searchimage

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.backbase.assignment.util.Resource
import com.pradeep.payback.CoroutineDispatcherRule
import com.pradeep.payback.data.model.ImageData
import com.pradeep.payback.data.model.ImageResponse
import com.pradeep.payback.repository.ImageRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ImageSearchViewModelTest{


    private lateinit var repository: ImageRepository
    private lateinit var viewModel: ImageSearchViewModel
    private lateinit var imgDataList : MutableList<ImageData>


    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule val dispatcherRule = CoroutineDispatcherRule()

    @Before
    fun setup(){
        repository = mockk()
        viewModel = ImageSearchViewModel(repository)

        imgDataList = mutableListOf()
        for (i in 1..20){
            imgDataList.add(ImageData(id = 3063284, previewURL = "https://cdn.pixabay.com/photo/2018/01/05/16/24/rose-3063284_150.jpg",
                largeImageURL = "https://pixabay.com/get/gd5017a6612cd8e6d7f9773d775f7a37969903716572f3bb4c10f22685a7019c9d697bd44bda4ce0bba59be6c71fbad887db559ca7bd1c14a8d10eb16d7ed2405_1280.jpg",
                user =  "anncapictures", favorites = 1125, likes = 1304, comments = 290, userImageURL = "https://cdn.pixabay.com/user/2015/11/27/06-58-54-609_250x250.jpg"
                , tags = "rose, flower, petal"))
        }
    }


    @Test
    fun `test list of search data query data is coming`() = runBlocking {
        //Given
        coEvery { repository.searchImage("flower") } coAnswers {
            Resource.success(ImageResponse(0, 0, imgDataList))
        }
        //When
        viewModel.searchImage("flower")
        val status = viewModel.searchImageLiveData.value

        //Then
        TestCase.assertEquals(20, status?.data?.hits?.size)

    }

    @Test
    fun `test list of search data query error case`() = runBlocking {
        //Given
        coEvery { repository.searchImage("flower") } coAnswers {
            Resource.error("Error case", null)
        }
        //When
        viewModel.searchImage("flower")
        val status = viewModel.searchImageLiveData.value

        //Then
        TestCase.assertEquals(Resource.error("Error case", null), status)

    }

}
