package com.rahul.fetchaddress.repo

import com.rahul.fetchaddress.data.local.RoomDatabase
import com.rahul.fetchaddress.data.model.SearchResultResponse
import com.rahul.fetchaddress.data.remote.APIService
import com.rahul.fetchaddress.data.remote.Resource
import com.rahul.fetchaddress.data.remote.ResponseHandler
import com.rahul.fetchaddress.data.remote.RetrofitGenerator

class MyRepo  {
    private val api: APIService = RetrofitGenerator.createService(
        APIService::class.java
    )
    private val responseHandler: ResponseHandler = ResponseHandler()

    val CONTENT_TYPE = "application/json"


    suspend fun getMatchingAddress(
        queryString: String,
        city: String
    ): Resource<SearchResultResponse> {

        return try {
            val response = api.getMatchingAddress(CONTENT_TYPE, queryString, city)

            responseHandler.handleSuccess(response)

        } catch (e: Exception) {
            //just extra logging
            responseHandler.handleException(e)
        }

    }
}