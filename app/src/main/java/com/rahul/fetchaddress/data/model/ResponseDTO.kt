package com.rahul.fetchaddress.data.model

import com.google.gson.annotations.SerializedName
import com.rahul.fetchaddress.data.model.DataDTO

data class ResponseDTO(

	@field:SerializedName("requestId")
	val requestId: String? = null,

	@field:SerializedName("data")
	val data: DataDTO? = null
)