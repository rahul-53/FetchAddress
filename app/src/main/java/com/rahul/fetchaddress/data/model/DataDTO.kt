package com.rahul.fetchaddress.data.model

import com.google.gson.annotations.SerializedName
import com.rahul.fetchaddress.data.model.AddressListDTO

data class DataDTO(

	@field:SerializedName("autoCompleteRequestString")
	val autoCompleteRequestString: String? = null,

	@field:SerializedName("focusWord")
	val focusWord: String? = null,

	@field:SerializedName("addressList")
	val addressList: List<AddressListDTO?>? = null,

	@field:SerializedName("totalFindByRSUHits")
	val totalFindByRSUHits: Int? = null,

	@field:SerializedName("totalNoRSUReturned")
	val totalNoRSUReturned: Int? = null
)