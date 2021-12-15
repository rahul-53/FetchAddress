package com.rahul.fetchaddress.data.remote

import com.rahul.fetchaddress.data.model.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {
    @Headers("Accept: application/json")
    @GET("autocomplete")
    suspend fun getMatchingAddress(
        @Header("Content-Type") contentType: String,
        @Query("queryString") queryString : String,
        @Query("city") city : String
    ): SearchResultResponse
}