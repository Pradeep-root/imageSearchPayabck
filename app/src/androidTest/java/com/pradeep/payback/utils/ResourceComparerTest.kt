package com.pradeep.payback.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.pradeep.payback.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ResourceComparerTest{


    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup(){
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameInternetCheckMsg_returnTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.no_internet_connection, "No internet connection, Please check.")

        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceWrongInternetCheckMsg_returnFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.no_internet_connection, "No internet connection")

        assertThat(result).isFalse()
    }

    @Test
    fun stringResourceEmptyResponseMsg_returnTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.empty_response, "No record found!")

        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceEmptyResponseMsg_returnFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.empty_response, "No record")

        assertThat(result).isFalse()
    }

    @Test
    fun stringResourceOpenDetailDialogMsg_returnTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.confirmation_dialog_to_open_detail, "Do you want to open more details?")

        assertThat(result).isTrue()
    }


}