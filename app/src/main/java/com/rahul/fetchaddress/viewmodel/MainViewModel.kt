package com.rahul.fetchaddress.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rahul.fetchaddress.data.model.SearchResultResponse
import com.rahul.fetchaddress.data.remote.Resource
import com.rahul.fetchaddress.repo.MyRepo
import kotlinx.coroutines.Dispatchers

class MainViewModel(val dataRepository: MyRepo): ViewModel() {

    fun getMatchingAddress(queryString: String, city: String): LiveData<Resource<SearchResultResponse>> {

        return liveData(Dispatchers.IO) {

            emit(Resource.loading(null))
            val data = dataRepository.getMatchingAddress(queryString, city)
            emit(data)

        }
    }
}