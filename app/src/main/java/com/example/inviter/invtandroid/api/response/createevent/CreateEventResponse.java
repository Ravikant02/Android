package com.example.inviter.invtandroid.api.response.createevent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ravikant on 16/12/16.
 */

public class CreateEventResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
