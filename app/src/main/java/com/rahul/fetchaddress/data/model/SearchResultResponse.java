package com.rahul.fetchaddress.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SearchResultResponse {
    @SerializedName("requestId")
    @Expose
    private String requestId;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
